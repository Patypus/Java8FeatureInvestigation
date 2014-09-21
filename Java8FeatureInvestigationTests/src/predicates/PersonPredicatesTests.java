package predicates;

import static predicates.PersonPredicates.*;

import org.junit.Assert;
import org.junit.Test;

import data.Address;
import data.Person;

public class PersonPredicatesTests {
	
	@Test
	public void personIsReportedAsAdultWhenAgeIsHigh() {
		Person testPerson = new Person("Anne", "Adult", 43, createDummyAddress());
		boolean result = isAdult(testPerson);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void personIsNotReportedAsAdultWhenAgeIsLow() {
		Person testPerson = new Person("Sam", "Child", 12, createDummyAddress());
		boolean result = isAdult(testPerson);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void personJustBelowAgeBoundaryForAdulthoodNotReportedAsAdult() {
		Person testPerson = new Person("Terry", "Teenager", 17, createDummyAddress());
		boolean result = isAdult(testPerson);
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void personJustAboveAgeBoundaryForAdulthoodIsReportedAsAdult() {
		Person testPerson = new Person("Jutin", "Adulthood", 18, createDummyAddress());
		boolean result = isAdult(testPerson);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void personWithAddressIsReportedAsHavingAddress() {
		Person testPerson = new Person("Hassah", "House", 28, createDummyAddress());
		boolean result = personHasAddress(testPerson);
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void personWithNullAddressIsReportedAsNotHavingAddress() {
		Person testPerson = new Person("Address", "NotSet", 23, null);
		boolean result = personHasAddress(testPerson);
		Assert.assertEquals(false, result);
	}

	@Test
	public void personWithNoFixedAbodeAddressIsReportedAsNotHavingAddress() {
		Person testPerson = new Person("Address", "NotSet", 30, createNoFixedAbodeAddress());
		boolean result = personHasAddress(testPerson);
		Assert.assertEquals(false, result);
	}
	
	private Address createDummyAddress() {
		return new Address(14, "Eric road", "Cardiff", "CF1 2PH");
	}
	
	private Address createNoFixedAbodeAddress() {
		return new Address(0, Address.NoAddress, "", "");
	}
}
