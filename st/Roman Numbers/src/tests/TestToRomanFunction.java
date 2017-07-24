package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import roman.Roman;
import roman.RomanException;

public class TestToRomanFunction {

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

				String romanString = Roman.toRoman(i);
				int romanInt = Roman.fromRoman(romanString);
				assertEquals(i, romanInt);
			} catch (RomanException e) {
				assertNull(e.getMessage());
			}
		}
	}

}
