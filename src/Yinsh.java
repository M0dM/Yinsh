import java.util.HashMap;
import java.util.Vector;


public class Yinsh {

    public enum color {BLACK, WHITE, UNDEFINED}

    public enum state {RING, MARKER}

    private color currentColor;
    private int numberOfRings;
    private final HashMap<Integer, Vector<Intersection>> plate = new HashMap<Integer, Vector<Intersection>>();
    private int numberOfWhiteRings;
    private int numberOfBlackRings;
    private final int[] ligneMin = {2, 1, 1, 1, 1, 2, 2, 3, 4, 5, 7};
    private final int[] ligneMax = {5, 7, 8, 9, 10, 10, 11, 11, 11, 11, 10};
    private int blackPoints = 0;
    private int whitePoints = 0;

    public Yinsh() {
        this.numberOfRings = 0;
        this.numberOfBlackRings = 0;
        this.numberOfWhiteRings = 0;
        this.currentColor = null;
        for (int i = 0; i < 10; i++) {
            Vector<Intersection> line = new Vector<Intersection>();
            initLineIntersections(line);
            plate.put(i, line);
        }
    }

    void initLineIntersections(Vector<Intersection> line){
        for (int i = 0; i < 10; i++) {
            Intersection intersect = new Intersection(color.UNDEFINED, null);
            line.add(intersect);
        }
    }

    void incrementBlackPoints(){
        blackPoints++;
    }

    void incrementWhitePoints(){
        whitePoints++;
    }

    public int getWhitePoints(){
        return whitePoints;
    }

    public int getBlackPoints(){
        return blackPoints;
    }

    public void setIntersectionColor(char col, int line, color color){
        plate.get(col -'a').get(line - 1).setColor(color);
    }

    public void setIntersectionState(char col, int line, state state){
        plate.get(col -'a').get(line - 1).setState(state);
    }

    public color getIntersectionColor(char col, int line){
        return plate.get(col -'a').get(line - 1).getColor();
    }

    public state getIntersectionState(char col, int line){
        return plate.get(col -'a').get(line - 1).getState();
    }

    public void setCurrentColor(color color) {
        this.currentColor = color;
    }

    public void incrementNumberOfRings() {
        numberOfRings++;
    }

    public void incrementNumberOfBlackRings(){
        numberOfBlackRings++;
    }

    public void incrementNumberOfWhiteRings(){
        numberOfWhiteRings++;
    }

    void removeCol(char col, int lineInit, int lineFinale){
        for (int j = lineInit; j < lineFinale; j++){
            setIntersectionColor(col, j, color.UNDEFINED);
            setIntersectionState(col, j, null);
        }
    }

    void removeLine(int line, char colInit, char colFinale){
        for (int i = (int)colInit; i < (int)colFinale; i++){
            setIntersectionColor((char)(i + 'a'), line, color.UNDEFINED);
            setIntersectionState((char)(i + 'a'), line, null);
        }
    }

    public void removeRow(char colInit, int lineInit, char colFinale, int lineFinale) {
        if(colInit == colFinale){
            removeCol(colInit, lineInit, lineFinale);
        }
        else if(lineInit == lineFinale){
            removeLine(lineInit, colInit, colFinale);
        }
        else{
            if(colFinale > colInit){
                for(int i=(int)colInit; i<=colFinale ;i++){
                    if(lineFinale > lineInit){
                        for(int j= lineInit; j<=lineFinale ;j++){
                           resetIntersect((char)i, j);
                        }
                    }
                    else{
                        for(int j= lineFinale; j<=lineInit ;j++){
                            resetIntersect((char)i, j);
                        }
                    }
                }
            }
            else{
                for(int i=(int)colFinale; i<=colInit ;i++){
                    if(lineFinale > lineInit){
                        for(int j= lineInit; j<=lineFinale ;j++){
                            resetIntersect((char)i, j);
                        }
                    }
                    else{
                        for(int j= lineFinale; j<=lineInit ;j++){
                            resetIntersect((char)i, j);
                        }
                    }
                }
            }
        }
    }

    private void resetIntersect(char col, int line) {
        setIntersectionColor(col, line, color.UNDEFINED);
        setIntersectionState(col, line, null);
    }

    public void removeRing(char col, int line) {
        numberOfBlackRings--;
        numberOfRings--;
        if (getIntersectionColor(col,line) == color.BLACK){
            incrementBlackPoints();
        }
        else{
            incrementWhitePoints();
        }
        resetIntersect(col, line);
    }

    public color currentColor() {
        return this.currentColor;
    }

    public void putRing(char col, int ligne, color color) throws Exception {
        if (!hasCoordinates(col, ligne)) {
            throw new Exception("Invalid coordinate.");
        } else {
            if (hasRing(col, ligne)) {
                throw new Exception("Duplicate ring.");
            } else {
                if (currentColor == color) {
                    throw new Exception("Invalid color.");
                } else {
                    currentColor = color;
                }
                numberOfRings++;
                if (color == Yinsh.color.BLACK) {
                    numberOfBlackRings++;
                } else {
                    numberOfWhiteRings++;
                }
                setIntersection(col, ligne, new Intersection(color, state.RING));
            }
        }
    }

    public void putMarker(char col, int ligne, color color) throws Exception {

        if (hasRingWithWrongColor(col, ligne, color)) {
            throw new Exception("Invalid ring color.");
        } else if (hasRing(col, ligne)) {
            setIntersection(col, ligne, new Intersection(color, state.MARKER));
        } else {
            throw new Exception("No ring matched");
        }
    }

    public boolean hasRing(char col, int ligne) {
        return plate.get((int) col - 'a').get(ligne - 1).getState() == Yinsh.state.RING;
    }

    private boolean hasRingWithWrongColor(char col, int ligne, color color) {
        return plate.get((int) col - 'a').get(ligne - 1).getState() == Yinsh.state.RING &&
                plate.get((int) col - 'a').get(ligne - 1).getColor() != color;
    }

    public boolean hasRingOnPlate() {
        return (numberOfRings > 0);
    }

    public int getNumberOfRingsOnPlate() {
        return this.numberOfRings;
    }

    boolean hasCoordinates(char col, int ligne) {
       return(colHasLigne(col, ligne));
    }

    private boolean colHasLigne(char col, int ligne) {
        Boolean colHasLigne = true;
        if (col < 'a' || col > 'k')
            colHasLigne = false;
        if (ligne < ligneMin[(int) col - 'a'] || ligne > ligneMax[(int) col - 'a'])
            colHasLigne = false;
        return colHasLigne;
    }

    void setIntersection(char col, int ligne, Intersection value) {
        plate.get((int) col - 'a').get(ligne - 1).setState(value.getState());
        plate.get((int) col - 'a').get(ligne - 1).setColor(value.getColor());
    }

    public boolean isInitialized() {
        return numberOfBlackRings == 5 && numberOfWhiteRings == 5;
    }

    public void move_ring(char colInit, int lineInit, char colFinale, int lineFinale) throws Exception {
        if (hasRing(colFinale, lineFinale)) {
            throw new Exception("Ring already in intersection.");
        } else {
            if (sameColomnOrLine(colInit, lineInit, colFinale, lineFinale)) {
                setIntersectionState(colInit, lineInit, state.MARKER);
                color oldColor = getIntersectionColor(colInit, lineInit);
                setIntersectionState(colFinale, lineFinale, state.RING);
                setIntersectionColor(colFinale, lineFinale, oldColor);
                if(colInit == colFinale){
                    for (int j = lineInit; j < lineFinale; j++)
                        plate.get((int)colInit-'a').get(j).setColor(getOppositeColor(plate.get((int)colInit-'a').get(j).getColor()));
                }
                if(lineInit == lineFinale){
                    for (int i = (int) colInit; i < (int) colFinale; i++)
                        plate.get((int)colInit-'a').get(lineInit - 1).setColor(getOppositeColor(plate.get((int)colInit-'a').get(lineInit - 1).getColor()));
                }
            } else {
                throw new Exception("No same colomn or line");
            }
        }
    }

    private color getOppositeColor(color color) {
        Yinsh.color oppColor = Yinsh.color.WHITE;
        if (color == Yinsh.color.WHITE) {
            oppColor = Yinsh.color.BLACK;
        }
        return oppColor;
    }

    private boolean sameColomnOrLine(char colInit, int lineInit, char colFinale, int lineFinale) {
        return colInit == colFinale || lineInit == lineFinale;
    }

    public boolean isPossibleMove(char colInit, int lineInit, char colFinale, int lineFinale){
        return  true;
    }

}
