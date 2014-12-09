package functionalinterface;

import java.util.HashMap;
import java.util.Map;

public class TypedValueStore<T> {
	
	private final Map<String, Value<T>> store;
	
	public TypedValueStore() {
		store = new HashMap<>();
	}
	
	public TypedValueStore( final Map<String, Value<T>> exisitingData ) {
		store = new HashMap<>();
		store.putAll( exisitingData );
	}
	
	public Value<T> getItemFromDataStore( final String key ) {
		return store.get( key );
	}
	
	public void addItemToStore( final String key, final Value<T> item ) throws InvalidValueException {
		if ( ( key != null && !key.equals( "" ) ) && item != null ) {			
			store.put( key, item );
		} else {
			throw createExceptionForInvalidValues( key, item );
		}
	}
	
	private InvalidValueException createExceptionForInvalidValues( final String key, final Value<T> item ) {
		String exceptionMessage = "";
		
		if ( key == null  ) {
			exceptionMessage = "Key value cannot be null.";
		} else if ( key.equals( "" ) ) {
			exceptionMessage = "Key value cannot be an empty string.";
		} else if ( item == null ) {
			exceptionMessage = "Item value cannot be null.";
		}
		
		return new InvalidValueException( exceptionMessage );
	}
	
}
