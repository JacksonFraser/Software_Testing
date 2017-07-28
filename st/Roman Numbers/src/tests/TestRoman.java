package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import roman.Roman;
import roman.RomanException;

public class TestRoman {
	
	@Before
	public void before(){
	        System.out.println("@Before");
	}

	@After
	public void after() {
		System.out.println("@After");
	}

	@Test(expected = RomanException.class)
	public void testToRomanMinimumValueException() throws RomanException {
		Roman.toRoman(0);
	}

	@Test(expected = RomanException.class)
	public void testToRomanMaximumValueException() throws RomanException {
		Roman.toRoman(39000);
	}

	@Test(expected = RomanException.class)
	public void testFromRomanMinimumValueException() throws RomanException {
		Roman.fromRoman("");
	}

	@Test(expected = RomanException.class)
	public void testFromRomanMaximumValueException() throws RomanException {
		String max = Roman.toRoman(39000);
		Roman.fromRoman(max);
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

