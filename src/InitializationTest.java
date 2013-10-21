import junit.framework.TestCase;
// Story 4 tests

public class InitializationTest extends TestCase {

    public InitializationTest(String name) {
        super(name);
    }

    public void testGameInitalized() throws Exception {
        Yinsh yinsh = new Yinsh();
        yinsh.putRing('b', 1, Yinsh.color.BLACK);
        yinsh.putRing('c', 1, Yinsh.color.WHITE);
        yinsh.putRing('a', 2, Yinsh.color.BLACK);
        yinsh.putRing('c', 2, Yinsh.color.WHITE);
        yinsh.putRing('a', 3, Yinsh.color.BLACK);
        yinsh.putRing('c', 3, Yinsh.color.WHITE);
        yinsh.putRing('a', 4, Yinsh.color.BLACK);
        yinsh.putRing('c', 4, Yinsh.color.WHITE);
        yinsh.putRing('a', 5, Yinsh.color.BLACK);
        yinsh.putRing('c', 5, Yinsh.color.WHITE);
        assertTrue(yinsh.isInitialized());
    }

}
