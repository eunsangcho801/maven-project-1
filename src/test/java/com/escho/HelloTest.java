package com.escho;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HelloTest extends TestCase{

	private Hello hello = null;
	
	public HelloTest(String testName) {
		super(testName);
		hello = new Hello();
	}
	
	public static TestSuite suite() {
		return new TestSuite(HelloTest.class);
	}
	
	public void testApp() {
		assertNotNull(hello);
	}
	
	public void testGetMessage() {
		String name = "ESCho";
		String msg = "Hi, " + name;
		assertEquals(hello.getMessage("ESCho"), msg);
				
	}
	
}
