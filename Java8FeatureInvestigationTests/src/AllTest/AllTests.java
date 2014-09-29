package AllTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import predicates.PredicatesTests;
import callable.CallableTests;
import defaults.DefaultsTests;
import streams.StreamTests;

@RunWith(Suite.class)
@SuiteClasses({ StreamTests.class, CallableTests.class, PredicatesTests.class, DefaultsTests.class })
public class AllTests {

}