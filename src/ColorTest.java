import junit.framework.TestCase;
//Story 1 tests

public class ColorTest extends TestCase {
    public ColorTest(String name) {
        super(name);
    }

    public void testColor() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('A', 2), YinshGame.GAMECOLOR.BLACK);
        assertTrue(yinsh.currentColor() == YinshGame.GAMECOLOR.BLACK);
    }
}
