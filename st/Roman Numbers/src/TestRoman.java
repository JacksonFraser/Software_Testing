import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoman {

	@Test(expected = RomanException.class)
	public void testRomanMinimumValueException() throws RomanException {
		Roman.toRoman(0);
	}

	@Test(expected = RomanException.class)
	public void testRomanMaximumValueException() throws RomanException {
		Roman.toRoman(39000);
	}

	@Test
	public void testValidValuesAccepted() {
		for (int i = 1; i < 39000; ++i) {
			try {
				Roman.toRoman(i);
			} catch (RomanException e) {
				assertNull(e.getMessage());
			}
		}
	}
}