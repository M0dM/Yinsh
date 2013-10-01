import junit.framework.TestCase;
// Story 5 tests


public class MarkerTest extends TestCase{
	public MarkerTest(String name){
		super(name);
	}
	
	public void testPutMarker() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException, NoMatchedRingException, InvalidRingColorException{
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
	
	public void testMoveMarker() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException, RingAlreadyInIntersectionException {
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
		yinsh.move_ring('d', 2, 'd', 5);
		yinsh.hasRing('d', 5);
	}
	
	public void testInvalidRingColor() throws NoMatchedRingException, DuplicateRingException, InvalidCoordinateException, InvalidColorException, RingAlreadyInIntersectionException {
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
		try{
			yinsh.putMarker('d', 2, Yinsh.color.WHITE);
			assertTrue(false);
		}catch(InvalidRingColorException exception)
		{
			assertTrue(true);
		}
		
	}
	
	public void testNoMatchedRing() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException, NoMatchedRingException, InvalidRingColorException, RingAlreadyInIntersectionException{
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
		yinsh.move_ring('d', 2, 'd', 5);
		try{
			yinsh.putMarker('d', 3, Yinsh.color.BLACK);
			assertTrue(false);
		}catch(NoMatchedRingException exception)
		{
			assertTrue(true);
		}
	}
	
	public void testRingAlreadyInIntersection() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException, NoMatchedRingException, InvalidRingColorException{
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
		try{
			yinsh.move_ring('d', 2, 'd', 6);
			assertTrue(false);
		}catch(RingAlreadyInIntersectionException exception)
		{
			assertTrue(true);			
		}
	}
}