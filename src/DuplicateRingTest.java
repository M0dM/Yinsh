
import junit.framework.TestCase;
// Story 3 tests

public class DuplicateRingTest extends TestCase {
    public DuplicateRingTest(String name) {
        super(name);
    }

    public void testDuplicateRing() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('a', 2, Yinsh.color.BLACK);
        try {
            yinsh.putRing('a', 2, Yinsh.color.WHITE);
            assertTrue(false);
        } catch (Exception exception) {
            assertTrue(true);
        }

    }

}

