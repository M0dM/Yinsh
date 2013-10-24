
import junit.framework.TestCase;
// Story 3 tests

public class DuplicateRingTest extends TestCase {
    public DuplicateRingTest(String name) {
        super(name);
    }

    public void testDuplicateRing() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('A', 2), YinshGame.GAMECOLOR.BLACK);
        try {
            yinsh.putRing(new Coordinates('A', 2), YinshGame.GAMECOLOR.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

}

