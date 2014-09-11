package streams;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import data.Address;
import data.Person;

public class PersonDataCollectionStreamsTests {

private static PersonDataCollectionStreams personDataCollectionStreams;
	
	@BeforeClass
	public static void setup()
	{
		personDataCollectionStreams = new PersonDataCollectionStreams();
	}
	
	
	@Test
	public void testGettingAverageAgeOfPersonsCollection() {
		ArrayList<Person> testPeople = createBasicTestPeopleCollection();
		
		double averageResult = personDataCollectionStreams.getAverageAgeOfPersonsInCollection(testPeople);
		Assert.assertEquals(40, averageResult, 0.0);
	}	
	
	
	private ArrayList<Person> createBasicTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add(new Person("Fred", "Bloggs", 43, new Address(3, "Rutlans Gardens", "Brighton", "BN3 4AP")));
		testPeople.add(new Person("Fred", "TheSecond", 25, new Address(23, "Sun Street", "Whitby", "YO22 4AP")));
		testPeople.add(new Person("Linda", "someoneElse", 52, new Address(86, "Belgravia Crescent", "Folkstone", "CT17 9QL")));
		return testPeople;
	}
}
