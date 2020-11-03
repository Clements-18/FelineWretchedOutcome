import org.junit.runner.RunWith;
import junit.framework.JUnit4TestAdapter;
import org.junit.runners.Suite;


// declares test classes in program
@RunWith(Suite.class)
@Suite.SuiteClasses({
   BowlingTest.class  // Add test classes
})

public class Main 
{

    // Execution begins at main().  In this test class, we will execute
    // text test runner will tell you if any of your tests fail.
    public static void main (String[] args) 
    {
       junit.textui.TestRunner.run (suite());
    }

    // The suite() method when using JUnit 3 Test Runners or Ant.
    public static junit.framework.Test suite() 
    {
       return new JUnit4TestAdapter(Main.class);
    }

}