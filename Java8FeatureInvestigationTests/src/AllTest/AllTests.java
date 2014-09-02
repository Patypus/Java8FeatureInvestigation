package AllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import streams.StreamTests;

@RunWith(Suite.class)
@SuiteClasses({ StreamTests.class })
public class AllTests {

}