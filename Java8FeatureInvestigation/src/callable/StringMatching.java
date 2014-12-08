package callable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import data.Length;

public class StringMatching {

	private Map<Length, Callable<String>> lengthFunctionMap; 
	
	public StringMatching()
	{
		lengthFunctionMap = createLengthFunctionMap();
	}
	
	public String getMessageForStringMessage( String originalString ) {
		Length stringLength = determineLengthValueFromStringLength( originalString.length() );
		Callable<String> function = lengthFunctionMap.get( stringLength );
		return callSelectedLengthFunction( function );
	}
	
	private String callSelectedLengthFunction( final Callable<String> function ) {
		String message = "";
		try {
			message = function.call();
		} catch ( Exception e ) {
			message = unableToFindMessageForString();
		}
		return message;
	}
	
	private Length determineLengthValueFromStringLength( final int stringLength )
	{
		return stringLength < 10 ? Length.Short : 
								   stringLength > 20 ? Length.Long : 
								 		   			   Length.Medium;
	}
	
	private HashMap<Length, Callable<String>> createLengthFunctionMap()
	{
		 HashMap<Length, Callable<String>> map = new HashMap<Length, Callable<String>>();
		 map.put( Length.Short, () -> shortStringMessage() );
		 map.put( Length.Medium, () -> mediumStringMessage() );
		 map.put( Length.Long, () -> longStringMessage() );
		 return map;
	}
	
	private String shortStringMessage() {
		return "Short string";
	}
	
	private String mediumStringMessage() {
		return "Medium string";
	}
	
	private String longStringMessage() {
		return "Long string";
	}
	
	private String unableToFindMessageForString() {
		return "Unable to find method for string length";
	}

}