import junit.framework.TestCase;

import java.util.Vector;
// Story 6 tests

public class FirstMovesTest extends TestCase {

    public void testMoveBlackRing() throws RingAlreadyInIntersectionException, NoSameColomnOrLineException, NoMatchedRingException, InvalidRingColorException {
        Yinsh yinsh = new Yinsh();
        yinsh.setPlateauStory6();
        yinsh.putMarker('e', 4, Yinsh.color.BLACK);
        yinsh.move_ring('e', 4, 'e', 10);
        assertTrue(((Vector<Intersection>) yinsh.getPlate().get(4)).get(3).getColor() == Yinsh.color.BLACK
                && ((Vector<Intersection>) yinsh.getPlate().get(4)).get(4).getColor() == Yinsh.color.WHITE
                && ((Vector<Intersection>) yinsh.getPlate().get(4)).get(5).getColor() == Yinsh.color.BLACK
                && ((Vector<Intersection>) yinsh.getPlate().get(4)).get(6).getColor() == Yinsh.color.BLACK
                && ((Vector<Intersection>) yinsh.getPlate().get(4)).get(7).getColor() == Yinsh.color.WHITE
                && ((Vector<Intersection>) yinsh.getPlate().get(4)).get(8).getColor() == Yinsh.color.BLACK);
    }
}
