package defaults.basic;

import org.junit.Assert;
import org.junit.Test;

public class ImplementableTests {

	@Test
	public void defaultMethodReturnsSameMessageFromImplementingClassesWhenNotOverridden() {
		EnglishImplementation english = new EnglishImplementation();
		GermanImplementation german = new GermanImplementation();
		
		String defaultFromEnglish = english.getGreeting();
		String defaultFromGerman = german.getGreeting();
		
		Assert.assertEquals( defaultFromGerman, defaultFromEnglish );
	}
	
	@Test
	public void defaultMethodReturnsDifferentMessageWhenOverridden() {
		String defaultMessage = "Hello world from the Implementable interface";
		Implementable overridden = new OverridingImplementation();
		
		String messageFromOverridden = overridden.getGreeting();
		
		Assert.assertNotEquals( defaultMessage, messageFromOverridden );
	}
	
}
