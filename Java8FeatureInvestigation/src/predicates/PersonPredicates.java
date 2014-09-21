package predicates;

import data.Address;
import data.Person;

public class PersonPredicates {
	
	public static boolean isAdult(Person person) {
		return person.getAge() >= 18;
	}
	
	public static boolean personHasAddress(Person person) {
		return person.getHomeAddress() != null &&
			   !person.getHomeAddress().getRoadName().equals(Address.NoAddress);
	}
}
