import junit.framework.TestCase;

import java.util.Vector;
// Story 7 tests

public class WinPointsTest extends TestCase {

    public void testRemoveRow(){
        Yinsh yinsh = new Yinsh();
        yinsh.setIntersectionColor('e', 6, Yinsh.color.BLACK);
        yinsh.setIntersectionState('e', 6, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('f', 7, Yinsh.color.BLACK);
        yinsh.setIntersectionState('f', 7, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('g', 8, Yinsh.color.BLACK);
        yinsh.setIntersectionState('g', 8, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('h', 9, Yinsh.color.BLACK);
        yinsh.setIntersectionState('h', 9, Yinsh.state.MARKER);
        yinsh.setIntersectionColor('i', 10, Yinsh.color.BLACK);
        yinsh.setIntersectionState('i', 10, Yinsh.state.MARKER);
        yinsh.removeRow('e', 6, 'i', 10);
        assertTrue(yinsh.getIntersectionColor('e', 6) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('e', 6) == null
                && yinsh.getIntersectionColor('f', 7) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('f', 7) == null
                && yinsh.getIntersectionColor('g', 8) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('g', 8) == null
                && yinsh.getIntersectionColor('h', 9) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('h', 9) == null
                && yinsh.getIntersectionColor('i', 10) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('i', 10) == null);
    }

    public void testRemoveRing(){
        Yinsh yinsh = new Yinsh();
        yinsh.setIntersectionColor('h', 10, Yinsh.color.BLACK);
        yinsh.setIntersectionState('h', 10, Yinsh.state.RING);
        yinsh.incrementNumberOfRings();
        yinsh.incrementNumberOfBlackRings();
        int numberOfBlackPointsInit = yinsh.getBlackPoints();
        yinsh.removeRing('h', 10);
        int numberOfBlackPointsFinale = yinsh.getBlackPoints();
        assertTrue(yinsh.getIntersectionColor('h', 10) == Yinsh.color.UNDEFINED
                && yinsh.getIntersectionState('h', 10) == null
                && numberOfBlackPointsFinale-numberOfBlackPointsInit == 1);
    }
}
