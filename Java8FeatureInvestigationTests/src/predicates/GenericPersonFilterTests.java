package predicates;

import static predicates.PersonPredicates.isAdult;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import data.Address;
import data.Person;

public class GenericPersonFilterTests {
	
	private static GenericPersonFilter filters;
	
	@BeforeClass
	public static void setup() {
		filters = new GenericPersonFilter();
	}
	
	
	@Test
	public void testFilterMethodCorrectlyAppliesSuppliedPredicate() {
		ArrayList<Person> testPersons = createPersonArrayForFilteringBasedOnAge();
		Collection<Person> filteredPersons = filters.filterAllPersonsWithSuppliedPredicate(testPersons, (Person p) -> isAdult(p));
		Assert.assertTrue(filteredPersons.size() == 1);
	}
	
	private ArrayList<Person> createPersonArrayForFilteringBasedOnAge() {
		ArrayList<Person> allPersons = new ArrayList<Person>();
		allPersons.add(new Person("Irma", "Adult", 25, createBasicAddress()));
		allPersons.add(new Person("Joe", "Kid", 11, createBasicAddress()));
		return allPersons;
	}
	
	private Address createBasicAddress() {
		return new Address(0, "Somewhere street", "Town1", "T1 11A", "UK");
	}
}