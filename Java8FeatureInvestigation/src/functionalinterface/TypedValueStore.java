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
		return null;
	}
	
}
