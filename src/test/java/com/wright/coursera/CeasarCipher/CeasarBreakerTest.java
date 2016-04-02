package com.wright.coursera.CeasarCipher;

import java.io.File;
import static org.junit.Assert.*;

import org.junit.Before;

import edu.duke.FileResource;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class CeasarBreakerTest extends TestCase {
	CeasarCipher csr;

	@Before
	public void setUp() throws Exception {
		csr = new CeasarCipher();
	}

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public CeasarBreakerTest(String testName) {
		super(testName);
	}

	// TESTS
	public void testDecryptSimple() {
		System.out.println("TEST: testDecryptSimple");
		CeasarBreaker cb = new CeasarBreaker();
		String msg;
		String encryptedMsg;

		// Plenty of 'e'
		msg = "Hello estreet band";
		encryptedMsg = csr.encrypt(msg, 5);
		assertEquals(msg, cb.decrypt(encryptedMsg));
	
		// Shift negative amount
		encryptedMsg = csr.encrypt(msg, -2);
		assertEquals(msg, cb.decrypt(encryptedMsg));

		// Shift a lot (over 24)
		encryptedMsg = csr.encrypt(msg, 22);
		assertEquals(msg, cb.decrypt(encryptedMsg));

		// Plenty of 'e'; has uppercase count
		msg = "Easier said Ed";
		encryptedMsg = csr.encrypt(msg, 8);
		assertEquals(msg, cb.decrypt(encryptedMsg));
		
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new CeasarBreakerTest("testDecryptSimple"));
		return suite;
	}

	// Test
	public void test() {
		System.out.println("BillTest");
		TestSuite tests = suite();

		TestResult result = null;
		tests.run(result);

	}

}
