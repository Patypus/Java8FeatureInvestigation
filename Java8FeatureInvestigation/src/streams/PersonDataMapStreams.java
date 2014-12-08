package streams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import data.Address;
import data.Person;

public class PersonDataMapStreams {

	public Collection<String> createCollectionOfFirstNames( final Collection<Person> allPersons ) {
		return allPersons.stream()
						 .map( Person::getFirstName )
						 .collect( Collectors.toList() );
	}
	
	public List<Integer> getCollectionOfHouseNumbersOfPeopleLivingOnSpecifiedRoad( final Collection<Person> allPersons, 
																				   final String roadNameOfInterest ) 
	{
		return allPersons.stream()
						 .filter( person -> person.getHomeAddress().getRoadName().equals( roadNameOfInterest ) )
						 .map( Person::getHomeAddress )
						 .map( Address::getHouseNumber )
						 .collect( Collectors.toList() );
	}
	
}
