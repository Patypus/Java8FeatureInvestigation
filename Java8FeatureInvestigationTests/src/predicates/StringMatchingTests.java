package predicates;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringMatchingTests {

	private static StringMatching matcher;
	
	@BeforeClass
	public static void Setup()
	{
		matcher = new StringMatching();
	}
	
	@Test
	public void ShortStringMessageIsCorrect()
	{
		String testMessage = "short";
		String result = matcher.getMessageForStringMessage(testMessage);
		
		Assert.assertEquals("Short string", result);
	}
	
	@Test
	public void MediumStringMessageIsCorrect()
	{
		String testMessage = "medium string";
		String result = matcher.getMessageForStringMessage(testMessage);
		
		Assert.assertEquals("Medium string", result);
	}
	
	@Test
	public void LongStringMessageIsCorrect()
	{
		String testMessage = "This string counts as a long string for the purposes of this test";
		String result = matcher.getMessageForStringMessage(testMessage);
		
		Assert.assertEquals("Long string", result);
	}
}
