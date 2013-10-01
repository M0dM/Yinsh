import junit.framework.Test;
import junit.framework.TestSuite;


public class AllTests {

	public static Test suite(){
		TestSuite suite = new TestSuite("Yinsh Tests");
		
		suite.addTest(new TestSuite(ColorTest.class));
		suite.addTest(new TestSuite(GameTest.class));
		suite.addTest(new TestSuite(DuplicateRingTest.class));
		suite.addTest(new TestSuite(InitializationTest.class));
		suite.addTest(new TestSuite(MarkerTest.class));
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(AllTests.suite());
		
	}

}
