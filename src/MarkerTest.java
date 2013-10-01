import junit.framework.TestCase;
// Story 5 tests


public class MarkerTest extends TestCase{
	public MarkerTest(String name){
		super(name);
	}
	
	public void testPutMarker() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException{
		Yinsh yinsh = new Yinsh();
		yinsh.putRing('d', 2, Yinsh.color.BLACK);
		yinsh.putRing('c', 2, Yinsh.color.WHITE);
		yinsh.putRing('b', 1, Yinsh.color.BLACK);
		yinsh.putRing('b', 2, Yinsh.color.WHITE);
		yinsh.putRing('f', 7, Yinsh.color.BLACK);
		yinsh.putRing('d', 6, Yinsh.color.WHITE);
		yinsh.putRing('g', 9, Yinsh.color.BLACK);
		yinsh.putRing('g', 8, Yinsh.color.WHITE);
		yinsh.putRing('j', 8, Yinsh.color.BLACK);
		yinsh.putRing('h', 6, Yinsh.color.WHITE);
		yinsh.putMarker('d', 2, Yinsh.color.BLACK);
	}
}
