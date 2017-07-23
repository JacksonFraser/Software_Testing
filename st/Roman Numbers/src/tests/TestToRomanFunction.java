package tests;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import roman.Roman;
import roman.RomanException;

public class TestToRomanFunction {

	@Test(expected = RomanException.class)
	public void testRomanMinimumValueException() throws RomanException {
		Roman.toRoman(0);
	}
	//test
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
	
	@Test
	public void testTen() throws RomanException {
		System.out.println(Roman.toRoman(10));
	}
}
