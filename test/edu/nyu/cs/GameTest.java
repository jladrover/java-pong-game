// DO NOT TOUCH THIS FILE!
package edu.nyu.cs;

// import junit 4 testing framework
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
// import static org.mockito.Mockito.*; // for mocking, stubbing, and spying

public class GameTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void testMain() {
        systemOutRule.enableLog(); // start capturing System.out
        String[] args = {};
        try {
            Game.main(args);
            String actual = systemOutRule.getLogWithNormalizedLineSeparator();
            String expected = "Hello world!\n";
            assertEquals("Your game must meet all the requirements.", "We have not provided tests to check your work for you.  Verify and validate your work yourself.");
        }
        catch (Exception e) {
            assert false; // fail the test if any exception occurs
        }

    }

}
