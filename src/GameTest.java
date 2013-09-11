import junit.framework.TestCase;
// Story 2 tests

public class GameTest extends TestCase{

	public GameTest(String name){
		super(name);
	}
	
	public void testHasRing() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException{
		Yinsh yinsh = new Yinsh();
		
		yinsh.putRing('a', 2, Yinsh.color.BLACK);
		assertTrue(yinsh.hasRing('a', 2) == true);
	}
	
	public void testInitial() throws DuplicateRingException, InvalidCoordinateException, InvalidColorException{
		Yinsh yinsh = new Yinsh();
		assertTrue(yinsh.hasRingOnPlate() == false);
		yinsh.putRing('a', 2, Yinsh.color.BLACK);
		assertTrue(yinsh.getNumberOfRingsOnPlate() == 1);
	}
	
	public void testWrongCoord() throws InvalidCoordinateException, DuplicateRingException, InvalidColorException{
		Yinsh yinsh = new Yinsh();
		try{
			yinsh.putRing('j', 4, Yinsh.color.BLACK);
			assertTrue(false);
		}
		catch (InvalidCoordinateException exception)
		{
			assertTrue(true);
		}
	}
	
	public void testDuplicateColor() throws InvalidColorException, DuplicateRingException, InvalidCoordinateException{
		Yinsh yinsh = new Yinsh();
		try{
			yinsh.putRing('j', 5, Yinsh.color.BLACK);
			yinsh.putRing('j', 6, Yinsh.color.BLACK);
			assertTrue(false);
		}catch (InvalidColorException exception){
			assertTrue(true);
		}
	}
}
