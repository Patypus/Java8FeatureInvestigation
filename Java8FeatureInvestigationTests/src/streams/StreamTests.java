package streams;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PersonDataFilterStreamsTests.class, PersonDataMapStreamsTests.class, PersonDataCollectionStreamsTests.class })
public class StreamTests {

}
