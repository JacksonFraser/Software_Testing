package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import roman.Roman;
import roman.RomanException;

public class TestFromRomanFunction {

	@Test(expected = RomanException.class)
	public void testRomanMinimumValueException() throws RomanException {
		Roman.fromRoman("");
	}

}
