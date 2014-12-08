package functionalinterface;

@FunctionalInterface
public interface PutFunction {

	void addItem( final String key, final Value<?> item ) throws InvalidValueException;
	
}
