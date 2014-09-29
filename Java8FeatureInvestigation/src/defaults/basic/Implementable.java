package defaults.basic;

public interface Implementable {

	default String getGreeting() {
		return "Hello world from the Implementable interface";
	}
	
	String getClassGreeting();
}
