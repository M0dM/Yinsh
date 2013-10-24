import junit.framework.TestCase;
// Story 4 tests

public class InitializationTest extends TestCase {

    public InitializationTest(String name) {
        super(name);
    }

    public void testGameInitalized() throws Exception {
        YinshGame yinsh = new YinshGame();
        yinsh.putRing('b', 1, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 1, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('a', 2, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 2, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('a', 3, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 3, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('a', 4, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 4, YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing('a', 5, YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing('c', 5, YinshGame.GAMECOLOR.WHITE);
        assertTrue(yinsh.isInitialized());
    }

}
