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
	
	@Test
	public void putValueAddsItemToValueStore() {
		try {
			String itemKey = "NewItem";
			Value<String> stringValue = new Value<>( "Item" );
			
			TypedValueStore<String> store = new TypedValueStore<String>();
			store.addItemToStore( itemKey, stringValue );
			
			assertNotNull( store.getItemFromDataStore( itemKey ) );
			
		} catch( Exception e ) {
			fail( "No exceptions expected for test" );
		}
	}
	
	@Test( expected = InvalidValueException.class )
	public void putValueWithNullValueThrowsException() throws InvalidValueException {
		String itemKey = "NewItem";
		
		TypedValueStore<String> store = new TypedValueStore<String>();
		store.addItemToStore( itemKey, null );
	}
	
	@Test( expected = InvalidValueException.class )
	public void putValueWithEmptyKeyTHrowsException() throws InvalidValueException {
		Value<Boolean> value = new Value<Boolean>( true );
		TypedValueStore<Boolean> store = new TypedValueStore<Boolean>();
		store.addItemToStore( null, value );
	}
	
}
