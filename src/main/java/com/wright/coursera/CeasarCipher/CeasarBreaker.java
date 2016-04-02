// Class: CeasarBreaker
// Description: Breaks a Ceasar Cipher Code string
// Written By: William J. Wright

package com.wright.coursera.CeasarCipher;

public class CeasarBreaker {
	private String alpha = "abcdefghijklmnopqrstuvwxyz";
	private CeasarCipher csr;

	public CeasarBreaker() {
		csr = new CeasarCipher();
	}

	private void showCounts(int[] countArray) {
		for (int i = 0; i < 26; i++) {
			System.out.println("CountIndex " + i + ":" + alpha.charAt(i) + "= " + countArray[i]);
		}
	}

	private void countLetters(String s, int[] countArray) {
		s = s.toLowerCase(); // case insensitiv count
		for (int i = 0; i < s.length(); i++) {
			int k = alpha.indexOf(s.charAt(i));
			if (k >= 0) {
				countArray[k]++;
			}
		}
		// System.out.println("String:" + s);
		// showCounts(countArray);
	}

	private int maxIndex(int[] values) {
		int maxValue = 0;
		int maxIndex = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] > maxValue) {
				maxValue = values[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public String decrypt(String s) {
		int[] letterCounts = new int[26];
		int eIndex = alpha.indexOf('e');
		countLetters(s, letterCounts);
		int maxIndex = maxIndex(letterCounts);
		// System.out.println("MaxIndex:" + maxIndex);
		int deshift = (eIndex-maxIndex);
		return csr.encrypt(s, deshift);
	}

	public static void main(String[] args) {
		CeasarCipher csr = new CeasarCipher();
		CeasarBreaker cb = new CeasarBreaker();
		String msg;
		String encryptedMsg;
		
		msg = "Easier";
		encryptedMsg = csr.encrypt(msg, 22);
		System.out.println("Encryped:"+encryptedMsg);
		System.out.println("Decryped:"+ cb.decrypt(encryptedMsg));
		
		
	}

}
