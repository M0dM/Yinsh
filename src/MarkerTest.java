import junit.framework.TestCase;
// Story 5 tests


public class MarkerTest extends TestCase {
    public MarkerTest(String name) {
        super(name);
    }

    public void testPutMarker() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putMarker('d', 2, YinshGame.GAMECOLOR.BLACK);
    }

    public void testMoveMarker() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing('d', 2, 'd', 5);
        yinsh.hasRing('d', 5);
    }

    public void testInvalidRingColor() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.putMarker('d', 2, YinshGame.GAMECOLOR.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

    public void testNoMatchedRing() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.moveRing('d', 2, 'd', 5);
        try {
            yinsh.putMarker('d', 3, YinshGame.GAMECOLOR.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testRingAlreadyInIntersection() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.moveRing('d', 2, 'd', 6);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testNoSameColomnOrLine() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('d', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('b', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('d', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('g', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('g', 8, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('j', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('h', 6, YinshGame.GAMECOLOR.WHITE);
        try {
            yinsh.moveRing('d', 2, 'i', 7);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }


}