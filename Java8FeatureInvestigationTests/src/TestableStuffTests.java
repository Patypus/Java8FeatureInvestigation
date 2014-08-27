
import org.junit.Assert;
import org.junit.Test;

public class TestableStuffTests {

	@Test
	public void testReturnedMessageForName() {
		TestableStuff testItem = new TestableStuff();
		String result = testItem.returnHappyMessage("fred");
		Assert.assertEquals("Hello fred", result);
	}
	
}
