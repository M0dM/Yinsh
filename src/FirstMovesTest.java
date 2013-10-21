import junit.framework.TestCase;
// Story 6 tests

public class FirstMovesTest extends TestCase {

    public void testMoveBlackRing() throws Exception {
        Yinsh yinsh = new Yinsh();
        // init plate for test
        yinsh.setIntersectionColor('e', 3, Yinsh.color.WHITE);
        yinsh.setIntersectionState('e', 3, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 4, Yinsh.color.BLACK);
        yinsh.setIntersectionState('e', 4, Yinsh.state.RING);
        yinsh.incrementRings(Yinsh.color.UNDEFINED);
        yinsh.incrementRings(Yinsh.color.UNDEFINED);
        yinsh.setCurrentColor(Yinsh.color.BLACK);
        yinsh.setIntersectionColor('e', 5, Yinsh.color.BLACK);
        yinsh.setIntersectionState('e', 5, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 6, Yinsh.color.WHITE);
        yinsh.setIntersectionState('e', 6, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 7, Yinsh.color.WHITE);
        yinsh.setIntersectionState('e', 7, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 8, Yinsh.color.BLACK);
        yinsh.setIntersectionState('e', 8, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 9, Yinsh.color.WHITE);
        yinsh.setIntersectionState('e', 9, Yinsh.state.MARKER);
        // end init plate
        yinsh.putMarker('e', 4, Yinsh.color.BLACK);
        yinsh.move_ring('e', 4, 'e', 10);
        assertTrue(yinsh.getIntersectionColor('e', 4) == Yinsh.color.BLACK
                && yinsh.getIntersectionColor('e', 5) == Yinsh.color.WHITE
                && yinsh.getIntersectionColor('e', 6) == Yinsh.color.BLACK
                && yinsh.getIntersectionColor('e', 7) == Yinsh.color.BLACK
                && yinsh.getIntersectionColor('e', 8) == Yinsh.color.WHITE
                && yinsh.getIntersectionColor('e', 9) == Yinsh.color.BLACK);
    }
}
