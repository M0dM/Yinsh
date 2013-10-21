import junit.framework.TestCase;
// Story 2 tests

public class GameTest extends TestCase {

    public GameTest(String name) {
        super(name);
    }

    public void testHasRing() throws Exception {
        Yinsh yinsh = new Yinsh();

        yinsh.putRing('a', 2, Yinsh.color.BLACK);
        assertTrue(yinsh.hasRing('a', 2));
    }

    public void testInitial() throws Exception {
        Yinsh yinsh = new Yinsh();
        assertTrue(yinsh.numberOfRings == 0);
        yinsh.putRing('a', 2, Yinsh.color.BLACK);
        assertTrue(yinsh.numberOfRings == 1);
    }

    public void testWrongCoord() throws Exception {
        Yinsh yinsh = new Yinsh();
        try {
            yinsh.putRing('j', 4, Yinsh.color.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }

    public void testDuplicateColor() throws Exception {
        Yinsh yinsh = new Yinsh();
        try {
            yinsh.putRing('j', 5, Yinsh.color.BLACK);
            yinsh.putRing('j', 6, Yinsh.color.BLACK);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }
    }
}
