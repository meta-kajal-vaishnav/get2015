package sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCharAt {

	@Test
	public void test() {
		CharAtExample sample = new CharAtExample("Hello world");
		char expected = 'e';
		char actual=sample.charAt(1);
		assertEquals(expected, actual);
	}

}
