import junit.framework.TestCase;
// Story 6 tests

public class FirstMovesTest extends TestCase {

    public void testMoveBlackRing() throws Exception {
        YinshGame yinsh = new YinshGame();
        // init plate for test
        yinsh.setIntersectionColor('e', 3, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('e', 3, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('e', 4, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('e', 4, YinshGame.GAMESTATE.RINGSTATE);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        yinsh.setCurrentColor(YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionColor('e', 5, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('e', 5, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('e', 6, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('e', 6, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('e', 7, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('e', 7, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('e', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('e', 8, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('e', 9, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('e', 9, YinshGame.GAMESTATE.MARKERSTATE);
        // end init plate
        yinsh.putMarker('e', 4, YinshGame.GAMECOLOR.BLACK);
        yinsh.moveRing('e', 4, 'e', 10);
        assertTrue(yinsh.getIntersectionColor('e', 4) == YinshGame.GAMECOLOR.BLACK
                && yinsh.getIntersectionColor('e', 5) == YinshGame.GAMECOLOR.WHITE
                && yinsh.getIntersectionColor('e', 6) == YinshGame.GAMECOLOR.BLACK
                && yinsh.getIntersectionColor('e', 7) == YinshGame.GAMECOLOR.BLACK
                && yinsh.getIntersectionColor('e', 8) == YinshGame.GAMECOLOR.WHITE
                && yinsh.getIntersectionColor('e', 9) == YinshGame.GAMECOLOR.BLACK);
    }
}
