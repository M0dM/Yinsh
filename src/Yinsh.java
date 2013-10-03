import java.util.HashMap;
import java.util.Vector;


public class Yinsh {

    public enum color {BLACK, WHITE, UNDEFINED};

    public enum state {RING, MARKER, BOTH};

    private color currentColor;
    private int numberOfRings;
    private HashMap<Integer, Vector<Intersection>> plate = new HashMap<Integer, Vector<Intersection>>();
    private int numberOfWhiteRings;
    private int numberOfBlackRings;
    private int[] ligneMin = {2, 1, 1, 1, 1, 2, 2, 3, 4, 5, 7};
    private int[] ligneMax = {5, 7, 8, 9, 10, 10, 11, 11, 11, 11, 10};
    private int blackPoints = 0;
    private int whitePoints = 0;

    public Yinsh() {
        this.numberOfRings = 0;
        this.numberOfBlackRings = 0;
        this.numberOfWhiteRings = 0;
        this.currentColor = null;
        for (int i = 0; i < 10; i++) {
            Integer index = new Integer(i);
            Vector<Intersection> line = new Vector<Intersection>();
            for (int j = 0; j < 10; j++) {
                Intersection intersect = new Intersection(color.UNDEFINED, null);
                line.add(intersect);
            }
            plate.put(index, line);
        }
    }

    public void incrementBlackPoints(){
        blackPoints++;
    }

    public void incrementWhitePoints(){
        whitePoints++;
    }

    public int getWhitePoints(){
        return whitePoints;
    }

    public int getBlackPoints(){
        return blackPoints;
    }

    public void setIntersectionColor(char col, int line, color color){
        ((Vector<Intersection>) plate.get(col -'a')).get(line-1).setColor(color);
    }

    public void setIntersectionState(char col, int line, state state){
        ((Vector<Intersection>) plate.get(col -'a')).get(line-1).setState(state);
    }

    public color getIntersectionColor(char col, int line){
        return ((Vector<Intersection>) plate.get(col -'a')).get(line-1).getColor();
    }

    public state getIntersectionState(char col, int line){
        return ((Vector<Intersection>) plate.get(col -'a')).get(line-1).getState();
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

    public void removeRow(char colInit, int lineInit, char colFinale, int lineFinale) {
        if(colInit == colFinale){
            for (int j = lineInit; j < lineFinale; j++){
                setIntersectionColor(colInit, j, color.UNDEFINED);
                setIntersectionState(colInit, j, null);
            }
        }
        else if(lineInit == lineFinale){
            for (int i = (int)colInit; i < (int)colFinale; i++){
                setIntersectionColor((char)(i + 'a'), lineInit, color.UNDEFINED);
                setIntersectionState((char)(i + 'a'), lineInit, null);
            }
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

    public HashMap getPlate() {
        return plate;
    }

    public color currentColor() {
        return this.currentColor;
    }

    public void putRing(char col, int ligne, color color) throws DuplicateRingException, InvalidCoordinateException, InvalidColorException {
        if (!hasCoordinates(col, ligne)) {
            throw new InvalidCoordinateException();
        } else {
            if (hasRing(col, ligne)) {
                throw new DuplicateRingException();
            } else {
                if (currentColor == color) {
                    throw new InvalidColorException();
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

    public void putMarker(char col, int ligne, color color) throws NoMatchedRingException, InvalidRingColorException {

        if (hasRingWithWrongColor(col, ligne, color)) {
            throw new InvalidRingColorException();
        } else if (hasRing(col, ligne)) {
            setIntersection(col, ligne, new Intersection(color, state.MARKER));
        } else {
            throw new NoMatchedRingException();
        }
    }

    public boolean hasRing(char col, int ligne) {
        return ((Vector<Intersection>) plate.get((int) col - 'a')).get(ligne - 1).getState() == Yinsh.state.RING;
    }

    private boolean hasRingWithWrongColor(char col, int ligne, color color) {
        return ((Vector<Intersection>) plate.get((int) col - 'a')).get(ligne - 1).getState() == Yinsh.state.RING &&
                ((Vector<Intersection>) plate.get((int) col - 'a')).get(ligne - 1).getColor() != color;
    }

    public boolean hasRingOnPlate() {
        return (numberOfRings > 0);
    }

    public int getNumberOfRingsOnPlate() {
        return this.numberOfRings;
    }

    public boolean hasCoordinates(char col, int ligne) {
        if (!colHasLigne(col, ligne)) {
            return false;
        }
        return true;
    }

    private boolean colHasLigne(char col, int ligne) {
        if (col < 'a' || col > 'k')
            return false;
        if (ligne < ligneMin[(int) col - 'a'] || ligne > ligneMax[(int) col - 'a'])
            return false;
        return true;
    }

    public void setIntersection(char col, int ligne, Intersection value) {
        ((Vector<Intersection>) plate.get((int) col - 'a')).get(ligne - 1).setState(value.getState());
        ((Vector<Intersection>) plate.get((int) col - 'a')).get(ligne - 1).setColor(value.getColor());
    }

    public boolean isInitialized() {
        return numberOfBlackRings == 5 && numberOfWhiteRings == 5;
    }

    public void move_ring(char colInit, int lineInit, char colFinale, int lineFinale) throws RingAlreadyInIntersectionException, NoSameColomnOrLineException {
        if (hasRing(colFinale, lineFinale)) {
            throw new RingAlreadyInIntersectionException();
        } else {
            if (sameColomnOrLine(colInit, lineInit, colFinale, lineFinale)) {
                ((Vector<Intersection>) plate.get((int) colInit - 'a')).get(lineInit - 1).setState(Yinsh.state.MARKER);
                Yinsh.color oldColor = ((Vector<Intersection>) plate.get((int) colInit - 'a')).get(lineInit - 1).getColor();
                ((Vector<Intersection>) plate.get((int) colFinale - 'a')).get(lineFinale - 1).setState(Yinsh.state.RING);
                ((Vector<Intersection>) plate.get((int) colFinale - 'a')).get(lineFinale - 1).setColor(oldColor);
                if(colInit == colFinale){
                    for (int j = lineInit; j < lineFinale; j++)
                        ((Vector<Intersection>) plate.get((int)colInit-'a')).get(j).setColor(getOppositeColor(((Vector<Intersection>) plate.get((int)colInit-'a')).get(j).getColor()));
                }
                if(lineInit == lineFinale){
                    for (int i = (int) colInit; i < (int) colFinale; i++)
                        ((Vector<Intersection>) plate.get((int)colInit-'a')).get(lineInit-1).setColor(getOppositeColor(((Vector<Intersection>) plate.get((int)colInit-'a')).get(lineInit-1).getColor()));
                }
            } else {
                throw new NoSameColomnOrLineException();
            }
        }
    }

    private color getOppositeColor(color color) {
        if (color == Yinsh.color.BLACK) {
            return Yinsh.color.WHITE;
        } else if (color == Yinsh.color.WHITE) {
            return Yinsh.color.BLACK;
        }
        return color;
    }

    private boolean sameColomnOrLine(char colInit, int lineInit, char colFinale, int lineFinale) {
        return colInit == colFinale || lineInit == lineFinale;
    }

}
