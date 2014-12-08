package streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import data.Person;

public class PersonDataCollectionStreams {

	public double getAverageAgeOfPersonsInCollection( final Collection<Person> allPersons ) {
		return allPersons.stream()
						 .collect( Collectors.averagingInt( Person::getAge ) );
	}
	
	public String concatenateFirstNamesOfPersonsInCollection( final Collection<Person> allPersons ) {
		return allPersons.stream()
						 .collect(Collectors.mapping( Person::getFirstName, Collectors.joining( ", " ) ) );
	}
	
	public Map<Boolean, List<Person>> sortPersonsIntoSubsetsByGreaterAndLessThanAge( final Collection<Person> allPersons, final int age ) {
		return allPersons.stream()
						 .collect( Collectors.partitioningBy( person -> person.getAge() > age ) );
	}
	
}
