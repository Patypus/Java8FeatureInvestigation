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
		ArrayList<Person> TestPeople = new ArrayList<Person>();
		TestPeople.add(new Person("Fred", "Bloggs", 43, new Address(3, "Rutlans Gardens", "Brighton", "BN3 4AP")));
		TestPeople.add(new Person("Fred", "TheSecond", 26, new Address(23, "Sun Street", "Whitby", "YO22 4AP")));
		TestPeople.add(new Person("Linda", "someoneElse", 52, new Address(86, "Belgravia Crescent", "Folkstone", "CT17 9QL")));
		
		Collection<Person> results = personDataStreams.findPersonsWithFirstName(TestPeople, "Fred");
		Assert.assertEquals(2, results.size());
	}
	
}
