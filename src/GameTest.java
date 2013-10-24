import junit.framework.TestCase;
// Story 2 tests

public class GameTest extends TestCase {

    public GameTest(String name) {
        super(name);
    }

    public void testHasRing() throws Exception {
        YinshGame yinsh = new YinshGame();

        yinsh.putRing('a', 2, YinshGame.GAMECOLOR.BLACK);
        assertTrue(yinsh.hasRing('a', 2));
    }

    public void testInitial() throws Exception {
        YinshGame yinsh = new YinshGame();
        assertTrue(yinsh.m_numberOfRings == 0);
        yinsh.putRing('a', 2, YinshGame.GAMECOLOR.BLACK);
        assertTrue(yinsh.m_numberOfRings == 1);
    }

    public void testWrongCoord() throws Exception {
        YinshGame yinsh = new YinshGame();
        try {
            yinsh.putRing('j', 4, YinshGame.GAMECOLOR.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testDuplicateColor() throws Exception {
        YinshGame yinsh = new YinshGame();
        try {
            yinsh.putRing('j', 5, YinshGame.GAMECOLOR.BLACK);
            yinsh.putRing('j', 6, YinshGame.GAMECOLOR.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }
}
