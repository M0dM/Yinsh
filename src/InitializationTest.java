import junit.framework.TestCase;
// Story 4 tests

public class InitializationTest extends TestCase {

    public InitializationTest(String name) {
        super(name);
    }

    public void testGameInitalized() throws Exception {
        YinshGame yinsh = new YinshGame(YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('B', 1), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 1), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('A', 2), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 2), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('A', 3), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 3), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('A', 4), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 4), YinshGame.GAMECOLOR.WHITE);
        yinsh.putRing(new Coordinates('A', 5), YinshGame.GAMECOLOR.BLACK);
        yinsh.putRing(new Coordinates('C', 5), YinshGame.GAMECOLOR.WHITE);
        assertTrue(yinsh.isInitialized());
    }

}
