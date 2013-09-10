import junit.framework.TestCase;


public class ColorTest extends TestCase
{
	public ColorTest(String name){
		super(name);
	}
	
	public void testColor(){
		Yinsh yinsh = new Yinsh();
		
		assertTrue(yinsh.currentColor() == yinsh.currentColor().BLACK);
	}
}
