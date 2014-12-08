package streams;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import data.Address;
import data.Person;

public class PersonDataMapStreamsTests {

	private static PersonDataMapStreams personDataMapStreams;
	
	@BeforeClass
	public static void setup() {
		personDataMapStreams = new PersonDataMapStreams();
	}
	
	@Test
	public void testCreatingMapOfFirstNames() {
		ArrayList<Person> testPersons = createBasicTestPeopleCollection();
		
		Collection<String> result = personDataMapStreams.createCollectionOfFirstNames( testPersons );
		Collection<String> expected = new ArrayList<String>();
		expected.add( "Fred" );
		expected.add( "Andrew" );
		expected.add( "Linda" );
		Assert.assertArrayEquals( expected.toArray(), result.toArray() );
	}
	
	@Test
	public void testCreatingListOfHouseNumbersOnCertainStreet() {
		ArrayList<Person> testPersons = createTestPoepleFromSameRoadCollection();
		
		Collection<Integer> result = 
				personDataMapStreams.getCollectionOfHouseNumbersOfPeopleLivingOnSpecifiedRoad( testPersons, "Mahler Avenue" );
		Collection<Integer> expected = new ArrayList<Integer>();
		expected.add( 15 );
		expected.add( 66 );
		expected.add( 45 );
		Assert.assertArrayEquals( expected.toArray(), result.toArray() );
	}
	
	
	private ArrayList<Person> createBasicTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add( new Person( "Fred", "Bloggs", 43, new Address( 3, "Rutlans Gardens", "Brighton", "BN3 4AP", "UK" ) ) );
		testPeople.add( new Person( "Andrew", "Nother", 25, new Address( 23, "Sun Street", "Whitby", "YO22 4AP", "UK" ) ) );
		testPeople.add( new Person( "Linda", "someoneElse", 52, new Address( 86, "Belgravia Crescent", "Folkstone", "CT17 9QL", "UK" ) ) );
		return testPeople;
	}
	
	private ArrayList<Person> createTestPoepleFromSameRoadCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add( new Person( "George", "Byron", 36, new Address( 15, "Mahler Avenue", "Grimsby", "YO22 4AP", "UK" ) ) );
		testPeople.add( new Person( "Percy", "Shelly", 29, new Address( 66, "Mahler Avenue", "Grimsby", "YO22 4AP", "UK" ) ) );
		testPeople.add( new Person( "Johann", "Geothe", 82, new Address( 45, "Mahler Avenue", "Grimsby", "YO22 4AP", "UK" ) ) );
		return testPeople;
	}
}
