package AllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import callable.CallableTests;
import streams.StreamTests;

@RunWith(Suite.class)
@SuiteClasses({ StreamTests.class, CallableTests.class })
public class AllTests {

}