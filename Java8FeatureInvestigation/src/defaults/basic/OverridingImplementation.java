package defaults.basic;

public class OverridingImplementation implements Implementable {

	@Override
	public String getClassGreeting() {
		return "Greetings from override land";
	}
	
	@Override
	public String getGreeting() {
		return "Greetings from override land also";
	}

}
