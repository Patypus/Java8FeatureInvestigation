package defaults;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import defaults.basic.ImplementableTests;

@RunWith(Suite.class)
@SuiteClasses({ ImplementableTests.class })
public class DefaultsTests {

}
