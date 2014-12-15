package functionalinterface;

public class Value<T> {
	
	private T value;
	
	public Value( final T val ) {
		value = val;
	}
	
	public T getValue() {
		return value;
	}
	
}
