package streams;

import java.util.Collection;
import java.util.stream.Collectors;

import data.Person;

public class PersonDataStreams {

	public Collection<Person> findPersonsWithFirstName( Collection<Person> allPersons, String firstName ) {
		return allPersons.stream()
						 .filter(person -> person.getFirstName().equalsIgnoreCase(firstName))
						 .collect(Collectors.toList());
	}
	
	public Collection<Person> findPersonsWithAgeGreaterThanGivenValue( Collection<Person> allPersons, int age) {
		return allPersons.stream()
						 .filter(person -> person.getAge() > age)
						 .collect(Collectors.toList());
	}
	
	public Collection<Person> findPersonsWhoseAddressPostcodeContainsGivenSubstring( Collection<Person> allPersons, 
																				     String postcodeSubstring) {
		return allPersons.stream()
						 .filter(person -> person.getHomeAddress()
								 			     .getPostCode()
								 			     .contains(postcodeSubstring))
						 .collect(Collectors.toList());
	}
	
}
