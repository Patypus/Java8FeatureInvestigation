package streams;

import java.util.Collection;
import java.util.stream.Collectors;

import data.Person;

public class PersonDataCollectionStreams {

	public double getAverageAgeOfPersonsInCollection( Collection<Person> allPersons ) {
		return allPersons.stream()
						 .collect(Collectors.averagingInt(Person::getAge));
	}
	
}
