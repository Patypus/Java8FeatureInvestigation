package streams;

import java.util.Collection;
import java.util.stream.Collectors;

import data.Person;

public class PersonDataFilterStreams {

	public Collection<Person> findPersonsWithFirstName( final Collection<Person> allPersons, final String firstName ) {
		return allPersons.stream()
						 .filter( person -> person.getFirstName().equalsIgnoreCase( firstName ) )
						 .collect( Collectors.toList() );
	}
	
	public Collection<Person> findPersonsWithAgeGreaterThanGivenValue( final Collection<Person> allPersons, final int age ) {
		return allPersons.stream()
						 .filter( person -> person.getAge() > age )
						 .collect( Collectors.toList() );
	}
	
	public Collection<Person> findPersonsWhoseAddressPostcodeContainsGivenSubstring( final Collection<Person> allPersons, 
																				     final String postcodeSubstring) {
		String lowerCasePostcodeSubstring = postcodeSubstring.toLowerCase();
		return allPersons.stream()
						 .filter( person -> person.getHomeAddress()
								 			      .getPostCode().toLowerCase()
								 			      .contains( lowerCasePostcodeSubstring ) )
						 .collect(Collectors.toList() );
	}
	
}
