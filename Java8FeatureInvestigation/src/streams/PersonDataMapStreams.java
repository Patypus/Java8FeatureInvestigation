package streams;

import java.util.Collection;
import java.util.stream.Collectors;

import data.Person;

public class PersonDataMapStreams {

	public Collection<String> createCollectionOfFirstNames(Collection<Person> allPersons) {
		return allPersons.stream()
						 .map(Person::getFirstName)
						 .collect(Collectors.toList());
	}
	
}
