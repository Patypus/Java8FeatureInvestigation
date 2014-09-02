package streams;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import data.Address;
import data.Person;

public class PersonDataStreamsTests {

	private static PersonDataStreams personDataStreams;
	
	@BeforeClass
	public static void Setup()
	{
		personDataStreams = new PersonDataStreams();
	}
	
	@Test
	public void TestGettingPersonsWithSetFirstName()
	{
		ArrayList<Person> testPeople = CreateBasicTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWithFirstName(testPeople, "Fred");
		Assert.assertEquals(2, results.size());
	}
	
	@Test
	public void TestGettingPersonsWithAgeOverSetValue() {
		ArrayList<Person> testPeople = CreateBasicTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWithAgeGreaterThanGivenValue(testPeople, 45);
		Assert.assertEquals(1, results.size());
	}
	
	private ArrayList<Person> CreateBasicTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add(new Person("Fred", "Bloggs", 43, new Address(3, "Rutlans Gardens", "Brighton", "BN3 4AP")));
		testPeople.add(new Person("Fred", "TheSecond", 26, new Address(23, "Sun Street", "Whitby", "YO22 4AP")));
		testPeople.add(new Person("Linda", "someoneElse", 52, new Address(86, "Belgravia Crescent", "Folkstone", "CT17 9QL")));
		return testPeople;
	}
}
