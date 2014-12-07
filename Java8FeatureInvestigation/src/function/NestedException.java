package function;

public class NestedException extends Exception {
	
	/** Eclipse generated. */
	private static final long serialVersionUID = 773531045001242597L;

	private final ExpectedException causingException;
	
	public NestedException( final String message, final ExpectedException cause ) {
		super( message );
		causingException = cause;
	}
	
	public ExpectedException getNestedCause() {
		return causingException;
	}
	
}
