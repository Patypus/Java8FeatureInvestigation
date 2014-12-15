package functionalinterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

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
	
	@Test
	public void populateWithPutFunction() {
		Value<String> item1 = new Value<String>( "this is a value" );
		Value<String> item2 = new Value<String>( "this is also value" );
		Value<String> item3 = new Value<String>( "this is pretending not to be a value. hehe." );
		Map<String, Value<String>> data = new HashMap<>();
		data.put( "item1", item1 );
		data.put( "item2", item2 );
		data.put( "item3", item3 );
		
		
		TypedValueStore<String> store = new TypedValueStore<>();
		PutFunction<String> putFunction = new PutFunction<>( store );
		
		data.entrySet().stream().forEach(putFunction::accept);
		
		assertEquals( item1, store.getItemFromDataStore( "item1" ) );
		assertEquals( item2, store.getItemFromDataStore( "item2" ));
		assertEquals( item3, store.getItemFromDataStore( "item3" ));
	}
	
}
