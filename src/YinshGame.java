import java.util.HashMap;
import java.util.Vector;


public class YinshGame {

    public enum GAMECOLOR {BLACK, WHITE, UNDEFINED}

    public enum GAMESTATE {RINGSTATE, MARKERSTATE}

    private GAMECOLOR m_currentColor;
    protected int m_numberOfRings;
    private final HashMap<Integer, Vector<Intersection>> m_plate = new HashMap<Integer, Vector<Intersection>>();
    private int m_numberOfWhiteRings;
    private int m_numberOfBlackRings;
    private final int[] m_ligneMin = {2, 1, 1, 1, 1, 2, 2, 3, 4, 5, 7};
    private final int[] m_ligneMax = {5, 7, 8, 9, 10, 10, 11, 11, 11, 11, 10};
    private int m_blackPoints = 0;
    private int m_whitePoints = 0;

    public YinshGame(GAMECOLOR firstPlayer) {
        m_numberOfRings = 0;
        m_numberOfBlackRings = 0;
        m_numberOfWhiteRings = 0;
        if(firstPlayer == GAMECOLOR.WHITE)
            m_currentColor = GAMECOLOR.BLACK;
        else
            m_currentColor = GAMECOLOR.WHITE;
        for (int i = 0; i < 10; i++) {
            Vector<Intersection> line = new Vector<Intersection>();
            initLineIntersections(line);
            m_plate.put(i, line);
        }
    }

    void initLineIntersections(Vector<Intersection> line) {
        for (int i = 0; i < 10; i++) {
            Intersection intersect = new Intersection(GAMECOLOR.UNDEFINED, null);
            line.add(intersect);
        }
    }
    void incrementPlayerPoints(GAMECOLOR couleur){
          if(couleur == GAMECOLOR.BLACK){
              m_blackPoints++;
          }else{
              m_whitePoints++;
          }
    }

    public int getPlayerPoints(GAMECOLOR couleur){
        int points = m_whitePoints;
        if(couleur == GAMECOLOR.BLACK){
            points = m_blackPoints;
        }
        return points;
    }
    public void setIntersectionColor(char col, int line, GAMECOLOR color) {
        m_plate.get(col - 'a').get(line - 1).setColor(color);
    }
    public void setIntersectionState(char col, int line, GAMESTATE state) {
        m_plate.get(col - 'a').get(line - 1).setState(state);
    }
    public GAMECOLOR getIntersectionColor(char col, int line) {
        return m_plate.get(col - 'a').get(line - 1).getColor();
    }
    public GAMESTATE getIntersectionState(char col, int line) {
        return m_plate.get(col - 'a').get(line - 1).getState();
    }
    public void setCurrentColor(GAMECOLOR color) {
        m_currentColor = color;
    }
    public void incrementRings(GAMECOLOR color) {

        if (color == GAMECOLOR.BLACK) {
            m_numberOfBlackRings++;
        } else {
            m_numberOfWhiteRings++;
        }
        m_numberOfRings++;
    }


    void removeCol(char col, int lineInit, int lineFinale) {
        for (int j = lineInit; j < lineFinale; j++) {
            setIntersectionColor(col, j, GAMECOLOR.UNDEFINED);
            setIntersectionState(col, j, null);
        }
    }

    void removeLine(int line, char colInit, char colFinale) {
        for (int i = (int) colInit; i < (int) colFinale; i++) {
            setIntersectionColor((char) (i + 'a'), line, GAMECOLOR.UNDEFINED);
            setIntersectionState((char) (i + 'a'), line, null);
        }
    }

    void resetLineIntersect(char col, int firstLine, int lastLine) {
        for (int j = firstLine; j <= lastLine; j++) {
            resetIntersect(col, j);
        }
    }

    void removeDiagFromTopToBot(char colInit, char colFinale, int lineInit, int lineFinale) {
        for (int i = (int) colInit; i <= colFinale; i++) {
            if (lineFinale > lineInit) {
                resetLineIntersect((char) i, lineInit, lineFinale);
            } else {
                resetLineIntersect((char) i, lineFinale, lineInit);
            }
        }
    }

    void removeDiagFromBotTotTop(char colInit, char colFinale, int lineInit, int lineFinale) {
        for (int i = (int) colFinale; i <= colInit; i++) {
            if (lineFinale > lineInit) {
                resetLineIntersect((char) i, lineInit, lineFinale);
            } else {
                resetLineIntersect((char) i, lineFinale, lineInit);
            }
        }
    }

    public void removeRow(Coordinates coordinatesInit, Coordinates coordinatesFinal, GAMECOLOR color) {
        char colInit = coordinatesInit.m_col;
        int lineInit = coordinatesInit.m_line;
        char colFinale = coordinatesFinal.m_col;
        int lineFinale = coordinatesFinal.m_line;
        if (colInit == colFinale) {
            removeCol(colInit, lineInit, lineFinale);
        } else if (lineInit == lineFinale) {
            removeLine(lineInit, colInit, colFinale);
        } else {
            if (colFinale > colInit) {
                removeDiagFromTopToBot(colInit, colFinale, lineInit, lineFinale);
            } else {
                removeDiagFromBotTotTop(colInit, colFinale, lineInit, lineFinale);
            }
        }
    }

    private void resetIntersect(char col, int line) {
        setIntersectionColor(col, line, GAMECOLOR.UNDEFINED);
        setIntersectionState(col, line, null);
    }

    public void removeRing(Coordinates coordinates, GAMECOLOR color) {
        char col = coordinates.m_col;
        int line = coordinates.m_line;
        m_numberOfBlackRings--;
        m_numberOfRings--;
        if (getIntersectionColor(col, line) == GAMECOLOR.BLACK) {
            incrementPlayerPoints(GAMECOLOR.BLACK);
        } else {
            incrementPlayerPoints(GAMECOLOR.WHITE);
        }
        resetIntersect(col, line);
    }

    public GAMECOLOR currentColor() {
        return m_currentColor;
    }

    public void putRing(Coordinates coordinates, GAMECOLOR color) throws Exception {
        char col = coordinates.m_col;
        int ligne = coordinates.m_line;
        if (isNoLineInCol(col, ligne)) {
            throw new Exception("Invalid coordinate.");
        } else {
            if (hasRing(col, ligne)) {
                throw new Exception("Duplicate ring.");
            } else {
                if (m_currentColor == color) {
                    throw new Exception("Invalid color.");
                } else {
                    m_currentColor = color;
                }
                m_numberOfRings++;
                if (color == GAMECOLOR.BLACK) {
                    m_numberOfBlackRings++;
                } else {
                    m_numberOfWhiteRings++;
                }
                setIntersection(col, ligne, new Intersection(color, GAMESTATE.RINGSTATE));
            }
        }
    }

    public void putMarker (Coordinates coordinates, GAMECOLOR color) throws Exception {
        char col = coordinates.m_col;
        int ligne = coordinates.m_line;
        if (hasRingWithWrongColor(col, ligne, color)) {
            throw new Exception("Invalid ring color.");
        } else if (hasRing(col, ligne)) {
            setIntersection(col, ligne, new Intersection(color, GAMESTATE.MARKERSTATE));
        } else {
            throw new Exception("No ring matched");
        }
    }

    public boolean hasRing(char col, int ligne) {
        return m_plate.get((int) col - 'a').get(ligne - 1).getState() == GAMESTATE.RINGSTATE;
    }

    private boolean hasRingWithWrongColor(char col, int ligne, GAMECOLOR color) {
        return m_plate.get((int) col - 'a').get(ligne - 1).getState() == GAMESTATE.RINGSTATE &&
                m_plate.get((int) col - 'a').get(ligne - 1).getColor() != color;
    }

    private boolean isNoLineInCol(char col, int ligne) {
        Boolean colHasNoLine = false;
        if (col < 'a' || col > 'k')
            colHasNoLine = true;
        if (ligne < m_ligneMin[(int) col - 'a'] || ligne > m_ligneMax[(int) col - 'a'])
            colHasNoLine = true;
        return colHasNoLine;
    }

    void setIntersection(char col, int ligne, Intersection value) {
        m_plate.get((int) col - 'a').get(ligne - 1).setState(value.getState());
        m_plate.get((int) col - 'a').get(ligne - 1).setColor(value.getColor());
    }

    public boolean isInitialized() {
        return m_numberOfBlackRings == 5 && m_numberOfWhiteRings == 5;
    }

    void setInitColorForSameColomn(char colInit, int lineInit, int lineFinale) {
        for (int j = lineInit; j < lineFinale; j++)
            m_plate.get((int) colInit - 'a').get(j).setColor(getOppositeColor(m_plate.get((int) colInit - 'a').get(j).getColor()));
    }

    void setInitColorForSameLine(char colInit, char colFinale, int lineInit) {
        for (int i = (int) colInit; i < (int) colFinale; i++)
            m_plate.get((int) colInit - 'a').get(lineInit - 1).setColor(getOppositeColor(m_plate.get((int) colInit - 'a').get(lineInit - 1).getColor()));
    }

    public void moveRing(Coordinates coordinatesInit, Coordinates coordinatesFinal, GAMECOLOR color) throws Exception {
        char colInit = coordinatesInit.m_col;
        int lineInit = coordinatesInit.m_line;
        char colFinale = coordinatesFinal.m_col;
        int lineFinale = coordinatesFinal.m_line;
        if (hasRing(colFinale, lineFinale)) {
            throw new Exception("Ring already in intersection.");
        } else {
            if (isSameColomnOrLine(colInit, lineInit, colFinale, lineFinale)) {
                setIntersectionState(colInit, lineInit, GAMESTATE.MARKERSTATE);
                setIntersectionState(colFinale, lineFinale, GAMESTATE.RINGSTATE);
                setIntersectionColor(colFinale, lineFinale, getIntersectionColor(colInit, lineInit));
                if (colInit == colFinale)
                    setInitColorForSameColomn(colInit, lineInit, lineFinale);
                if (lineInit == lineFinale)
                    setInitColorForSameLine(colInit, colFinale, lineInit);
            } else {
                throw new Exception("No same colomn or line");
            }
        }
    }

    private GAMECOLOR getOppositeColor(GAMECOLOR color) {
        GAMECOLOR oppColor = GAMECOLOR.WHITE;
        if (color == GAMECOLOR.WHITE) {
            oppColor = GAMECOLOR.BLACK;
        }
        return oppColor;
    }

    private boolean isSameColomnOrLine(char colInit, int lineInit, char colFinale, int lineFinale) {
        return colInit == colFinale || lineInit == lineFinale;
    }

    public boolean isPossibleMove(char colInit, int lineInit, char colFinale, int lineFinale) {
        return true;
    }

}
