import junit.framework.TestCase;
// Story 5 tests


public class MarkerTest extends TestCase {
    public MarkerTest(String name) {
        super(name);
    }

    public void testPutMarker() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putMarker(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
    }

    public void testMoveMarker() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing(new Coordinates('D', 2), new Coordinates('D', 5), YinshGame.GAMECOLOR.UNDEFINED);
        yinsh.hasRing('d', 5);
    }

    public void testInvalidRingColor() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.putMarker(new Coordinates('D', 2), YinshGame.GAMECOLOR.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

    public void testNoMatchedRing() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing(new Coordinates('D', 2), new Coordinates('D', 5), YinshGame.GAMECOLOR.UNDEFINED);
        try {
            yinsh.putMarker(new Coordinates('D', 3), YinshGame.GAMECOLOR.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testRingAlreadyInIntersection() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.moveRing(new Coordinates('D', 2), new Coordinates('D', 6), YinshGame.GAMECOLOR.UNDEFINED);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testNoSameColomnOrLine() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('F', 7), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('D', 6), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('G', 9), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('G', 8), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('J', 8), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('H', 6), YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.moveRing(new Coordinates('D', 2), new Coordinates('I', 7), YinshGame.GAMECOLOR.UNDEFINED);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }


}