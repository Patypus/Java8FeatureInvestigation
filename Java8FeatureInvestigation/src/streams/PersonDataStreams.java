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
	
}
