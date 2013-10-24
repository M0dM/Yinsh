import junit.framework.TestCase;
// Story 7 tests

public class WinPointsTest extends TestCase {

    public void testRemoveRow() {
        YinshGame yinsh = new YinshGame();
        yinsh.setIntersectionColor('e', 6, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('e', 6, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('f', 7, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('f', 7, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('g', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('g', 8, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('h', 9, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('h', 9, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.setIntersectionColor('i', 10, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('i', 10, YinshGame.GAMESTATE.MARKERSTATE);
        yinsh.removeRow('e', 6, 'i', 10);
        assertTrue(yinsh.getIntersectionColor('e', 6) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('e', 6) == null
                && yinsh.getIntersectionColor('f', 7) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('f', 7) == null
                && yinsh.getIntersectionColor('g', 8) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('g', 8) == null
                && yinsh.getIntersectionColor('h', 9) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('h', 9) == null
                && yinsh.getIntersectionColor('i', 10) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('i', 10) == null);
    }

    public void testRemoveRing() {
        YinshGame yinsh = new YinshGame();
        yinsh.setIntersectionColor('h', 10, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('h', 10, YinshGame.GAMESTATE.RINGSTATE);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        int nbOfBlackPointsInit = yinsh.getPlayerPoints(YinshGame.GAMECOLOR.BLACK);
        yinsh.removeRing('h', 10);
        int nbOfBlackPointsFinal = yinsh.getPlayerPoints(YinshGame.GAMECOLOR.BLACK);
        assertTrue(yinsh.getIntersectionColor('h', 10) == YinshGame.GAMECOLOR.UNDEFINED
                && yinsh.getIntersectionState('h', 10) == null
                && nbOfBlackPointsFinal - nbOfBlackPointsInit == 1);
    }
}
