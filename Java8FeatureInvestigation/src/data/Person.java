package data;

public class Person {
	private String FirstName;
	private String SecondName;
	private int Age;
	private Address HomeAddress;
	
	public Person(String firstName, String secondName, int age, Address address) {
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
