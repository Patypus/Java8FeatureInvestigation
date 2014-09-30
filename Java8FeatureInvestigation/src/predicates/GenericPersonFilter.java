package predicates;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import data.Person;

public class GenericPersonFilter {

	public List<Person> filterAllPersonsWithSuppliedPredicate(ArrayList<Person> allPersons, Predicate<Person> predicate) {
		return allPersons.stream()
						 .filter(predicate)
						 .collect(Collectors.toList());
	}
	
	
}
