package functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

/**
 * This is an implementation of the Consumer interface which allows the addItemToStore function in TypedDataStore, which throws an exception, to
 * be used in a stream's foreach method (The exception thrown by the addItemToStore function stops the method itself being used in a lambda in a 
 * foreach method as the exception stops it from matching the interface of Consumer which foreach is expecting). This implementation
 * allows the exceptions to be managed so put can be used in a stream.
 * 
 * @param <T> The type of the values in the data store to add to
 */
public class PutFunction<T> implements Consumer<Map.Entry<?, ?>>{

	private final TypedValueStore<T> storeToAddTo;
	
	private final List<InvalidValueException> encounteredExceptions;
	
	public PutFunction( final TypedValueStore<T> store ) {
		storeToAddTo = store;
		encounteredExceptions = new ArrayList<>();
	}
	
	@Override
	public void accept( final Entry<?, ?> item ) {
		try {
			@SuppressWarnings("unchecked")
			Value<T> castValue = (Value<T>) item.getValue();
			storeToAddTo.addItemToStore( item.getKey().toString(), castValue );
		} catch ( InvalidValueException e ) {
			encounteredExceptions.add( e );
		}
	}

	public List<InvalidValueException> getListOfExceptionsThrowDuringAdd() {
		return encounteredExceptions;
	}
	
} 