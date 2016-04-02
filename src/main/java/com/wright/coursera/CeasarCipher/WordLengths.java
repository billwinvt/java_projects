package com.wright.coursera.CeasarCipher;
import edu.duke.FileResource;

public class WordLengths {
	public static int maxLength = 31;
	public void countWordLengths(FileResource resource, int[] counts) {
		for (String s : resource.words()) {
			s = s.replaceAll("[.,?!;\"]+", "");
			int l = s.length();
			if (l < maxLength) {
				counts[l]++;
			} else {
				System.out.println("Unexpected long word:s");
			}
		}
		return;
	}
	
	public int indexOfMax(int[] values) {
		int maxIndex = 0;
		for (int i = 0; i < maxLength; i++) {
			if (values[i] > maxIndex) {
				maxIndex = i;
			}
		
		}
		return maxIndex;
	}
	
/*	public static void main(String[] args) {
	//	String fileName = "/Users/bill/eclipse/workspace/CorseraJV/resources/file/word_counts";
		String fileName = "/Users/bill/eclipse/workspace/CorseraJV/resources/file/small_hamlet.txt";	
		int[] myCounts = new int[WordLengths.maxLength];
		FileResource myResource = new FileResource(fileName);
		WordLengths wl = new WordLengths();
		wl.countWordLengths(myResource, myCounts);
		for (int i = 0; i < maxLength; i++) {
			if (myCounts[i] > 0) {
				System.out.println("Words of length " + i + " : " + myCounts[i]);
			}
		}
		System.out.println("Largest number of words of length:" + wl.indexOfMax(myCounts));
	}
*/
}
