import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestStack {

	private Stack s;

	@Before
	public void doBeore() {
		this.s = new Stack();
	}

	@Test
	public void testDefaultConstructor() {
		assertTrue(s.size() == 0);
	}

	@Test
	public void testConstructorWithSizeParamWithCorrectValues() {
		int numValues = 55;
		Stack ss = new Stack(numValues);
		assertTrue(numValues == ss.valuesSize());
	}

	@Test
	public void testConstructorWithSizeParamWithIncorrectValues() {
		int numValues = 55;
		Stack ss = new Stack(54);
		assertNotEquals(numValues, ss.valuesSize());
	}

	@Test
	public void testPushFunction() throws Overflow {
		s.push(5);
		s.push(2);
		assertTrue("Push function is broken", s.size() == 2);
		assertNotEquals(23, s.size());
		assertTrue(s.contains(5));
		assertTrue(s.contains(2));
		assertFalse(s.contains(6));
		

	}

	@Test
	public void testPopFuction() throws Overflow, Underflow {

		int valueToPush = 300;
		s.push(valueToPush);
		int popValue = s.pop();

		assertEquals(valueToPush, popValue);

	}

	@Test(expected = Underflow.class)
	public void testUnderflowException() throws Underflow {
		s.pop();
	}
	
	@Test(expected = Overflow.class)
	public void testOverflowException() throws Overflow {
		Stack ss = new Stack(2);
		ss.push(2);
		ss.push(2);
		ss.push(2);
	}
	

}
