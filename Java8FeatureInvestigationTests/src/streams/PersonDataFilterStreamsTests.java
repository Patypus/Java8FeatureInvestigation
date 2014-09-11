package streams;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import data.Address;
import data.Person;

public class PersonDataFilterStreamsTests {

	private static PersonDataFilterStreams personDataStreams;
	
	@BeforeClass
	public static void setup()
	{
		personDataStreams = new PersonDataFilterStreams();
	}
	
	@Test
	public void testGettingPersonsWithSetFirstName()
	{
		ArrayList<Person> testPeople = createBasicTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWithFirstName(testPeople, "Fred");
		Assert.assertEquals(2, results.size());
	}
	
	@Test
	public void testGettingPersonsWithAgeOverSetValue() {
		ArrayList<Person> testPeople = createBasicTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWithAgeGreaterThanGivenValue(testPeople, 45);
		Assert.assertEquals(1, results.size());
	}
	
	@Test
	public void testFindingPersonsWithSubstringInPostCode() {
		ArrayList<Person> testPeople = createPostCodeTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWhoseAddressPostcodeContainsGivenSubstring(testPeople, "BN");
		Assert.assertEquals(3, results.size());
	}
	
	@Test
	public void testFindPersonWithSubstringInPostCodeIsNotCaseSensitive() {
		ArrayList<Person> testPeople = createPostCodeTestPeopleCollection();
		
		Collection<Person> results = personDataStreams.findPersonsWhoseAddressPostcodeContainsGivenSubstring(testPeople, "bn");
		Assert.assertEquals(3, results.size());
	}
	
	private ArrayList<Person> createBasicTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add(new Person("Fred", "Bloggs", 43, new Address(3, "Rutlans Gardens", "Brighton", "BN3 4AP")));
		testPeople.add(new Person("Fred", "TheSecond", 25, new Address(23, "Sun Street", "Whitby", "YO22 4AP")));
		testPeople.add(new Person("Linda", "someoneElse", 52, new Address(86, "Belgravia Crescent", "Folkstone", "CT17 9QL")));
		return testPeople;
	}
	
	private ArrayList<Person> createPostCodeTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add(new Person("Person", "One", 21, new Address(3, "Rutlans Gardens", "Hove", "BN3 4AP")));
		testPeople.add(new Person("Person", "Two", 22, new Address(23, "Canfield Close", "Brighton", "BN2 4DJ")));
		testPeople.add(new Person("Person", "Three", 23, new Address(86, "Ship Street", "Brighton", "BN1 9NP")));
		testPeople.add(new Person("Person", "Four", 24, new Address(24, "Woodland Avenue", "Clacton", "CO15 9SD")));
		return testPeople;
	}
}
