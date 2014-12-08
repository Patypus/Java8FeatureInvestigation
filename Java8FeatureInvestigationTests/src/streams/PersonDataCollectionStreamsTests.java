package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
		
		double averageResult = personDataCollectionStreams.getAverageAgeOfPersonsInCollection( testPeople );
		Assert.assertEquals( 40, averageResult, 0.0 );
	}	
	
	@Test
	public void testGettingConcatenatedStringOfAllPesonsFirstNames() {
		ArrayList<Person> testPeople = createBasicTestPeopleCollection();
		
		String result = personDataCollectionStreams.concatenateFirstNamesOfPersonsInCollection( testPeople );
		String expected = "Fred, Urist, Linda";
		Assert.assertEquals( expected, result );
	}
	
	@Test
	public void TestPartitioningPersonCollectionAroundAge() {
		ArrayList<Person> testPeople = createTestPeopleCollectionForAgeTest();
		
		Map<Boolean, List<Person>> result = personDataCollectionStreams.sortPersonsIntoSubsetsByGreaterAndLessThanAge( testPeople, 35 );
		List<Person> underAgeLimit = result.get( false );
		List<Person> overAgeLimit = result.get( true );
		Assert.assertEquals( 3, underAgeLimit.size() );
		Assert.assertEquals( 3, overAgeLimit.size() );
	}
	
	@Test
	public void TestPartitioningPersonsCollectionAroundAgeToMakeEmptyUnderAgeList() {
		ArrayList<Person> testPeople = createTestPeopleCollectionForAgeTest();
		
		Map<Boolean, List<Person>> result = personDataCollectionStreams.sortPersonsIntoSubsetsByGreaterAndLessThanAge( testPeople, 12 );
		List<Person> underAgeLimit = result.get( false );
		List<Person> overAgeLimit = result.get( true );
		Assert.assertEquals( 0, underAgeLimit.size() );
		Assert.assertEquals( 6, overAgeLimit.size() );
	}
	
	private ArrayList<Person> createBasicTestPeopleCollection() {
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add( new Person( "Fred", "Bloggs", 43, new Address( 3, "Rutlans Gardens", "Brighton", "BN3 4AP", "UK" ) ) );
		testPeople.add( new Person( "Urist", "McEntry", 25, new Address( 23, "Sun Street", "Whitby", "YO22 4AP", "UK" ) ) );
		testPeople.add( new Person( "Linda", "someoneElse", 52, new Address( 86, "Belgravia Crescent", "Folkstone", "CT17 9QL", "UK" ) ) );
		return testPeople;
	}
	
	private ArrayList<Person> createTestPeopleCollectionForAgeTest() {
		Address dummyAddress = new Address( 1, "Somewhere street", "Dartford", "DA1 5PA", "UK" );
		
		ArrayList<Person> testPeople = new ArrayList<Person>();
		testPeople.add( new Person( "Andrew", "Person", 26, dummyAddress ) );
		testPeople.add( new Person( "Bernard", "Person", 58, dummyAddress ) );
		testPeople.add( new Person( "Charlie", "Person", 43, dummyAddress ) );
		testPeople.add( new Person( "Danielle", "Person", 31, dummyAddress ) );
		testPeople.add( new Person( "Ellie", "Person", 19, dummyAddress ) );
		testPeople.add( new Person( "Freddy", "Person", 41, dummyAddress ) );
		return testPeople;
	}
}
