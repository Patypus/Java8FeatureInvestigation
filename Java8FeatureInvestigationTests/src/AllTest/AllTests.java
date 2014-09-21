package AllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import callable.PredicatesTests;
import streams.StreamTests;

@RunWith(Suite.class)
@SuiteClasses({ StreamTests.class, PredicatesTests.class })
public class AllTests {

}