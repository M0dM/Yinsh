import junit.framework.TestCase;
// Story 5 tests


public class MarkerTest extends TestCase {
    public MarkerTest(String name) {
        super(name);
    }

    public void testPutMarker() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        yinsh.putMarker('d', 2, Yinsh.color.BLACK);
    }

    public void testMoveMarker() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        yinsh.move_ring('d', 2, 'd', 5);
        yinsh.hasRing('d', 5);
    }

    public void testInvalidRingColor() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        try {
            yinsh.putMarker('d', 2, Yinsh.color.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

    public void testNoMatchedRing() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        yinsh.move_ring('d', 2, 'd', 5);
        try {
            yinsh.putMarker('d', 3, Yinsh.color.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testRingAlreadyInIntersection() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        try {
            yinsh.move_ring('d', 2, 'd', 6);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testNoSameColomnOrLine() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('d', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('b', 2, Yinsh.color.WHITE);
        yinsh.putRing('f', 7, Yinsh.color.BLACK);
        yinsh.putRing('d', 6, Yinsh.color.WHITE);
        yinsh.putRing('g', 9, Yinsh.color.BLACK);
        yinsh.putRing('g', 8, Yinsh.color.WHITE);
        yinsh.putRing('j', 8, Yinsh.color.BLACK);
        yinsh.putRing('h', 6, Yinsh.color.WHITE);
        try {
            yinsh.move_ring('d', 2, 'i', 7);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }


}