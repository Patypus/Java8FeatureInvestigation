package data;

public class Person {
	private final String FirstName;
	private final String SecondName;
	private final int Age;
	private final Address HomeAddress;
	
	public Person( final String firstName, final String secondName, final int age, final Address address) {
		FirstName = firstName;
		SecondName = secondName;
		Age = age;
		HomeAddress = address;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public int getAge() {
		return Age;
	}
	public Address getHomeAddress() {
		return HomeAddress;
	}
}
