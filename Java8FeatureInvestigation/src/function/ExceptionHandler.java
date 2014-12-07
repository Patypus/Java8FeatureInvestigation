package function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * A class using a map of exception types to functions that that can generate messages for the exception type.
 * This can be used for catch blocks in methods which have to catch multiple exception types but which can only 
 * throw one type:
 * public void doSomething() throws ConvinientExceptionType {
 * 	try {
 * 		//Something dodgy
 * 	} catch ( UnhelpfulExceptionType | OtherExceptionType e ) {
 * 		String usefulMessage = exceptionHandler.getMessageForException( e );
 *  	throw new ConvinientExceptionType( usefulMessage );
 * 	}
 * }
 * The use of functions allows simple exceptions to be handled with only returning a string message, or complex
 * operations, such as mining information out of nested causes, to be used through the same interface. The map
 * with the types against functions allows the required function to easily be found.
 */
public class ExceptionHandler {

	private final Map<Class<?>, Function<Exception, String>> exceptionMap;
	
	public ExceptionHandler() {
		exceptionMap = setupExceptionMap();
	}
	
	private Map<Class<?>, Function<Exception, String>> setupExceptionMap() {
		Map<Class<?>, Function<Exception, String>> map = new HashMap<>();
		map.put( ExpectedException.class, ( excpetion ) -> "The expected exception occurred." );
		map.put( NestedException.class, ( exception ) -> getMessageForNestedExceptionType( exception ) );
		return map;
	}
	
	/**
	 * Method to get an appropriate message for a type of exception. 
	 * @param exception - Exception type to handle
	 * @return relevant string message for exception type
	 */
	public String getMessageForException( final Exception exception ) {
		String result = "";
		
		if ( exceptionMap.containsKey( exception.getClass() ) ) {
			Function<Exception, String> messageForExceptionFunction = exceptionMap.get( exception.getClass() );
			result = messageForExceptionFunction.apply( exception );
		} else {
			result = getDefaultMessageForUnknownExceptionType( exception );
		}
		
		return result;
	}
	
	private String getDefaultMessageForUnknownExceptionType( final Exception exception ) {
		return String.join( " ", "An unexpected exception occurred for exception with type:",
								 exception.getClass().getName(),
								 "The message for this exception was:",
								 exception.getMessage() );
	}
	
	private String getMessageForNestedExceptionType( final Exception exception ) {
		NestedException castException = (NestedException) exception;
		Exception nestedCause = castException.getNestedCause();
		
		return String.join( " ", "An exception occurred and the cause error was:", 
								 nestedCause.getMessage() );
	}
	
}
