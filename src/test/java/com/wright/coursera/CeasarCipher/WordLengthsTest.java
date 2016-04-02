package com.wright.coursera.CeasarCipher;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.duke.FileResource;

public class WordLengthsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private void testFile1() {
		String fileName = "file/small_hamlet.txt";	
		int[] myCounts = new int[WordLengths.maxLength];
		FileResource myResource = new FileResource(fileName);
		WordLengths wl = new WordLengths();
		wl.countWordLengths(myResource, myCounts);
		for (int i = 0; i < WordLengths.maxLength; i++) {
			if (myCounts[i] > 0) {
		//		System.out.println("Words of length " + i + " : " + myCounts[i]);
			}
		}
		System.out.println("Most words in " + fileName + " have a length of: " + wl.indexOfMax(myCounts));
		assertEquals(3,wl.indexOfMax(myCounts));
		
	}
	@Test
	public void test() {
		System.out.println("TEST BEGIN: WordLengths");
		testFile1();
	}

}
