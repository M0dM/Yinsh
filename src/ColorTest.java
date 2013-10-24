import junit.framework.TestCase;
//Story 1 tests

public class ColorTest extends TestCase {
    public ColorTest(String name) {
        super(name);
    }

    public void testColor() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('a', 2, YinshGame.GAMECOLOR.BLACK);
        assertTrue(yinsh.currentColor() == YinshGame.GAMECOLOR.BLACK);
    }
}
