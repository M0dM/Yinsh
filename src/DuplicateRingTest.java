
import junit.framework.TestCase;
// Story 3 tests

public class DuplicateRingTest extends TestCase {
    public DuplicateRingTest(String name) {
        super(name);
    }

    public void testDuplicateRing() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('a', 2, YinshGame.GAMECOLOR.BLACK);
        try {
            yinsh.putRing('a', 2, YinshGame.GAMECOLOR.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

}

