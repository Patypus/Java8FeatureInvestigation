package functionalinterface;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TypedValueStoreTests {

	@Test
	public void getValueReturnsValueFromStoreForKey() {
		String itemKey = "Item1";
		Value<Integer> value = new Value<Integer>( 23 );
		Map<String, Value<Integer>> testData = new HashMap<>();
		testData.put( itemKey, value );
		
		TypedValueStore<Integer> store = new TypedValueStore<Integer>( testData );
		Value<?> result = store.getItemFromDataStore( itemKey );
		
		assertEquals( value, result );
	}
	
}
