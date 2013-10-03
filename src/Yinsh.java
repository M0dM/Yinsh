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

    public void setPlateauStory6() {
        // Colonne e
        ((Vector<Intersection>) plate.get(4)).get(2).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(4)).get(2).setState(state.MARKER);
        ((Vector<Intersection>) plate.get(4)).get(3).setColor(color.BLACK);
        ((Vector<Intersection>) plate.get(4)).get(3).setState(state.RING);
        numberOfRings++;
        numberOfBlackRings++;
        currentColor = color.BLACK;
        ((Vector<Intersection>) plate.get(4)).get(4).setColor(color.BLACK);
        ((Vector<Intersection>) plate.get(4)).get(4).setState(state.MARKER);
        ((Vector<Intersection>) plate.get(4)).get(5).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(4)).get(5).setState(state.MARKER);
        ((Vector<Intersection>) plate.get(4)).get(6).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(4)).get(6).setState(state.MARKER);
        ((Vector<Intersection>) plate.get(4)).get(7).setColor(color.BLACK);
        ((Vector<Intersection>) plate.get(4)).get(7).setState(state.MARKER);
        ((Vector<Intersection>) plate.get(4)).get(8).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(4)).get(8).setState(state.MARKER);

        //Colone b
        ((Vector<Intersection>) plate.get(1)).get(3).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(1)).get(3).setState(state.RING);
        //Colone c
        ((Vector<Intersection>) plate.get(2)).get(3).setColor(color.BLACK);
        ((Vector<Intersection>) plate.get(2)).get(3).setState(state.MARKER);
        //Colone h
        ((Vector<Intersection>) plate.get(7)).get(4).setColor(color.WHITE);
        ((Vector<Intersection>) plate.get(7)).get(4).setState(state.MARKER);
        //Colone i
        ((Vector<Intersection>) plate.get(8)).get(4).setColor(color.BLACK);
        ((Vector<Intersection>) plate.get(8)).get(4).setState(state.MARKER);
    }

    public HashMap getPlate() {
        return plate;
    }

    public color currentColor() {
        return this.currentColor;
    }

    public void putRing(char colone, int ligne, color color) throws DuplicateRingException, InvalidCoordinateException, InvalidColorException {
        if (!hasCoordinates(colone, ligne)) {
            throw new InvalidCoordinateException();
        } else {
            if (hasRing(colone, ligne)) {
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
                setIntersection(colone, ligne, new Intersection(color, state.RING));
            }
        }
    }

    public void putMarker(char colone, int ligne, color color) throws NoMatchedRingException, InvalidRingColorException {

        if (hasRingWithWrongColor(colone, ligne, color)) {
            throw new InvalidRingColorException();
        } else if (hasRing(colone, ligne)) {
            setIntersection(colone, ligne, new Intersection(color, state.MARKER));
        } else {
            throw new NoMatchedRingException();
        }
    }

    public boolean hasRing(char colone, int ligne) {
        return ((Vector<Intersection>) plate.get((int) colone - 'a')).get(ligne - 1).getState() == Yinsh.state.RING;
    }

    private boolean hasRingWithWrongColor(char colone, int ligne, color color) {
        return ((Vector<Intersection>) plate.get((int) colone - 'a')).get(ligne - 1).getState() == Yinsh.state.RING &&
                ((Vector<Intersection>) plate.get((int) colone - 'a')).get(ligne - 1).getColor() != color;
    }

    public boolean hasRingOnPlate() {
        return (numberOfRings > 0);
    }

    public int getNumberOfRingsOnPlate() {
        return this.numberOfRings;
    }

    public boolean hasCoordinates(char colone, int ligne) {
        if (!coloneHasLigne(colone, ligne)) {
            return false;
        }
        return true;
    }

    private boolean coloneHasLigne(char colone, int ligne) {
        if (colone < 'a' || colone > 'k')
            return false;
        if (ligne < ligneMin[(int) colone - 'a'] || ligne > ligneMax[(int) colone - 'a'])
            return false;
        return true;
    }

    public void setIntersection(char colone, int ligne, Intersection value) {
        ((Vector<Intersection>) plate.get((int) colone - 'a')).get(ligne - 1).setState(value.getState());
        ((Vector<Intersection>) plate.get((int) colone - 'a')).get(ligne - 1).setColor(value.getColor());
    }

    public boolean isInitialized() {
        return numberOfBlackRings == 5 && numberOfWhiteRings == 5;
    }

    public void move_ring(char colInitiale, int ligneInitale, char colFinale, int ligneFinale) throws RingAlreadyInIntersectionException, NoSameColomnOrLineException {
        if (hasRing(colFinale, ligneFinale)) {
            throw new RingAlreadyInIntersectionException();
        } else {
            if (sameColomnOrLine(colInitiale, ligneInitale, colFinale, ligneFinale)) {
                ((Vector<Intersection>) plate.get((int) colInitiale - 'a')).get(ligneInitale - 1).setState(Yinsh.state.MARKER);
                Yinsh.color oldColor = ((Vector<Intersection>) plate.get((int) colInitiale - 'a')).get(ligneInitale - 1).getColor();
                ((Vector<Intersection>) plate.get((int) colFinale - 'a')).get(ligneFinale - 1).setState(Yinsh.state.RING);
                ((Vector<Intersection>) plate.get((int) colFinale - 'a')).get(ligneFinale - 1).setColor(oldColor);
                if(colInitiale == colFinale){
                    for (int j = ligneInitale; j < ligneFinale; j++)
                        ((Vector<Intersection>) plate.get((int)colInitiale-'a')).get(j).setColor(getOppositeColor(((Vector<Intersection>) plate.get((int)colInitiale-'a')).get(j).getColor()));
                }
                if(ligneInitale == ligneFinale){
                    for (int i = (int) colInitiale; i < (int) colFinale; i++)
                        ((Vector<Intersection>) plate.get((int)colInitiale-'a')).get(ligneInitale-1).setColor(getOppositeColor(((Vector<Intersection>) plate.get((int)colInitiale-'a')).get(ligneInitale-1).getColor()));
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

    private boolean sameColomnOrLine(char colInitiale, int ligneInitale, char colFinale, int ligneFinale) {
        return colInitiale == colFinale || ligneInitale == ligneFinale;
    }

}
