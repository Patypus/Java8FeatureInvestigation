package function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class ExceptionHandlerTests {
	
	private static ExceptionHandler handler;
	
	@BeforeClass 
	public static void setup() {
		handler = new ExceptionHandler();
	}

	@Test
	public void unexcpectedExceptionGetsDefultMessage() {
		String message = "Who saw this coming?";
		Exception unexpectedException = new TestException( message );
		
		String result = handler.getMessageForException( unexpectedException );
		
		String expectedDefaultMessage = "An unexpected exception occurred ";
		
		assertTrue( result.contains( expectedDefaultMessage ) );
		assertTrue( result.contains( message ) );
	}
	
	@Test
	public void expectedExceptionReturnsCorrectMessage() {
		String exceptionMessage = "We're all doomed.";
		Exception expectedException = new ExpectedException( exceptionMessage );
		
		String result = handler.getMessageForException( expectedException );
		String expectedMessage = "The expected exception occurred.";
		
		assertEquals( expectedMessage, result );
	}
	
	@Test
	public void messageForNestedExceptionTypeContainsMessageFromNestedException() {
		String nestedMessage = "It has all gone wrong.";
		ExpectedException exceptionToNest = new ExpectedException( nestedMessage );
		NestedException topException = new NestedException( "This was caused by the attached exception", exceptionToNest );
		
		String result = handler.getMessageForException( topException );
		
		assertTrue( result.contains( nestedMessage ) );
	}
}
