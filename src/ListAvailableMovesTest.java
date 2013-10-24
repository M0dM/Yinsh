import junit.framework.TestCase;
// Story 8 tests

public class ListAvailableMovesTest extends TestCase {
    public void testIsPossibleMove() {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        // init plate for test
        // col e line 3 to 9
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
        ///////////////////////////////////////////////////////////
        //col b
        yinsh.setIntersectionColor('b', 4, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('b', 4, YinshGame.GAMESTATE.RINGSTATE);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        yinsh.incrementRings(YinshGame.GAMECOLOR.UNDEFINED);
        //col c
        yinsh.setIntersectionColor('c', 4, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('c', 4, YinshGame.GAMESTATE.MARKERSTATE);
        //col h
        yinsh.setIntersectionColor('h', 7, YinshGame.GAMECOLOR.WHITE);
        yinsh.setIntersectionState('h', 7, YinshGame.GAMESTATE.MARKERSTATE);
        //col i
        yinsh.setIntersectionColor('i', 8, YinshGame.GAMECOLOR.BLACK);
        yinsh.setIntersectionState('i', 8, YinshGame.GAMESTATE.MARKERSTATE);
        // end init plate

        assertTrue(yinsh.isPossibleMove('e', 4, 'e', 2)
                && yinsh.isPossibleMove('e', 4, 'e', 10)
                && yinsh.isPossibleMove('e', 4, 'd', 4)
                && yinsh.isPossibleMove('e', 4, 'f', 4)
                && yinsh.isPossibleMove('e', 4, 'g', 4)
                && yinsh.isPossibleMove('e', 4, 'h', 4)
                && yinsh.isPossibleMove('e', 4, 'i', 4)
                && yinsh.isPossibleMove('e', 4, 'f', 5)
                && yinsh.isPossibleMove('e', 4, 'g', 6)
                && yinsh.isPossibleMove('e', 4, 'j', 9));

    }
}
