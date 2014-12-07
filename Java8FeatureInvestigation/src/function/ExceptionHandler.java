package function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

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
	 * Method to get an appropriate message for a type of exception. Should be used like:
	 * try {
	 * 	//Something dodgy
	 * } catch ( UnhelpfulExceptionType e ) {
	 * 	String usefulMessage = exceptionHandler.getMessageForException( e );
	 *  throw new ConvinientExceptionType( usefulMessage );
	 * }
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
