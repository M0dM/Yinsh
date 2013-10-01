import junit.framework.TestCase;
//Story 1 tests

public class ColorTest extends TestCase {
    public ColorTest(String name) {
        super(name);
    }

    public void testColor() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('a', 2, Yinsh.color.BLACK);
        assertTrue(yinsh.currentColor() == Yinsh.color.BLACK);
    }
}
