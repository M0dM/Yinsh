import junit.framework.TestCase;
// Story 8 tests

public class ListAvailableMovesTest extends TestCase{
    public void testIsPossibleMove(){
        Yinsh yinsh = new Yinsh();
        // init plate for test
        // col e line 3 to 9
        yinsh.setIntersectionColor('e', 3, Yinsh.color.WHITE);
        yinsh.setIntersectionState('e', 3, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('e', 4, Yinsh.color.BLACK);
        yinsh.setIntersectionState('e', 4, Yinsh.state.RING);
        yinsh.incrementNumberOfRings();
        yinsh.incrementNumberOfBlackRings();
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
        ///////////////////////////////////////////////////////////
        //col b
        yinsh.setIntersectionColor('b', 4, Yinsh.color.WHITE);
        yinsh.setIntersectionState('b', 4, Yinsh.state.RING);
        yinsh.incrementNumberOfRings();
        yinsh.incrementNumberOfWhiteRings();
        //col c
        yinsh.setIntersectionColor('c', 4, Yinsh.color.BLACK);
        yinsh.setIntersectionState('c', 4, Yinsh.state.MARKER);
        //col h
        yinsh.setIntersectionColor('h', 7, Yinsh.color.WHITE);
        yinsh.setIntersectionState('h', 7, Yinsh.state.MARKER);
        //col i
        yinsh.setIntersectionColor('i', 8, Yinsh.color.BLACK);
        yinsh.setIntersectionState('i', 8, Yinsh.state.MARKER);
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
