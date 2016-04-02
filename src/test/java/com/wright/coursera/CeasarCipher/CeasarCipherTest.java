package com.wright.coursera.CeasarCipher;

import java.io.File;
import static org.junit.Assert.*;

import org.junit.Before;

import edu.duke.FileResource;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CeasarCipherTest 
    extends TestCase
{
	CeasarCipher csr;
	@Before
	public void setUp() throws Exception {
		csr = new CeasarCipher();
	}
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CeasarCipherTest( String testName )
    {
        super( testName );
    }

    // TESTS
    public void testEncrypt() {
    	System.out.println("TEST: testEncrypt");
  
    	// Single key
    	String s = csr.encrypt("First Legion", 23);
    	assertEquals(s,"Cfopq Ibdflk");
  
    	// Double key
    	s = csr.encrypt("First Legion", 23,17);
    	assertEquals(s,"Czojq Ivdzle");
    }
    public void testFromFile() {
    	System.out.println("TEST: testFromFile");
    	
    	String msg;
		int key = 1;
		String fileName = "file/small_hamlet.txt";			
		FileResource fr = new FileResource(fileName);
		msg = fr.asString();
//		System.out.println("Read in:" + msg);
//		System.out.println("Encrypted:" + csr.encrypt(msg, key));
		
		String result = csr.encrypt(msg, key);
		String expect = "Mbfs. Nz ofdfttbsjft bsf fncbsl'e. Gbsfxfmm.\n\nBoe, tjtufs, bt uif xjoet hjwf cfofgju\n";
		assertEquals(result,expect);
    }
 
    
    private void assertStringEquals(String s, String s2) {
		// TODO Auto-generated method stub
		
	}

	/**
     * @return the suite of tests being tested
     */
    public static TestSuite suite()
    {
    	TestSuite suite= new TestSuite();
    	suite.addTest(new CeasarCipherTest("testEncrypt"));
    	suite.addTest(new CeasarCipherTest("testFromFile"));
        return suite;
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
    	System.out.println("BillTest");
    	TestSuite tests = suite();
 
    	TestResult result = null;
		tests.run(result);
    	    	
    }
}
