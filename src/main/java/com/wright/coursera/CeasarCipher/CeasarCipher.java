package com.wright.coursera.CeasarCipher;
import edu.duke.FileResource;

public class CeasarCipher {
	String ucAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String lcAlphabet = "abcdefghijklmnopqrstuvwxyz";

	public String encrypt(String input, int shift) {
		while (shift < 0)
			shift += 26;
		StringBuilder result = new StringBuilder(input);
		for (int i = 0; i < result.length(); i++) {
			int idx = -1;
			if ((idx = ucAlphabet.indexOf(result.charAt(i))) >= 0) {
				// Uppercase Character
				int encrIndex = (idx + shift) % ucAlphabet.length();
				result.setCharAt(i, ucAlphabet.charAt(encrIndex));
			}
			if ((idx = lcAlphabet.indexOf(result.charAt(i))) >= 0) {
				// Lowercase Character
				int encrIndex = (idx + shift) % lcAlphabet.length();
				result.setCharAt(i, lcAlphabet.charAt(encrIndex));
			}
		}
		return result.toString();
	}

	public String encrypt(String input, int key1, int key2) {
		StringBuilder result = new StringBuilder(input);
		int key = key1;
		for (int i = 0; i < result.length(); i++) {
			int idx = -1;
			if ((i % 2)==0) {
				key = key1;	
			} else {
				key = key2;	
			}
			if ((idx = ucAlphabet.indexOf(result.charAt(i))) >= 0) {
				// Uppercase Character
				int encrIndex = (idx + key) % ucAlphabet.length();
				result.setCharAt(i, ucAlphabet.charAt(encrIndex));
			}
			if ((idx = lcAlphabet.indexOf(result.charAt(i))) >= 0) {
				// Lowercase Character
				int encrIndex = (idx + key) % lcAlphabet.length();
				result.setCharAt(i, lcAlphabet.charAt(encrIndex));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		CeasarCipher csr = new CeasarCipher();
		System.out.println("Encrypted Single Key Test:" + csr.encrypt("First Legion", 23));
		System.out.println("Encrypted Double Key Test:" + csr.encrypt("First Legion", 23,17));
		
		String msg;
		int key = 1;
		String fileName = "/Users/bill/eclipse/workspace/CorseraJV/resources/file/small_hamlet.txt";	
		FileResource fr = new FileResource(fileName);
		msg = fr.asString();
		System.out.println("Read in:" + msg);
		System.out.println("Encrypted:" + csr.encrypt(msg, key));
	}

}
