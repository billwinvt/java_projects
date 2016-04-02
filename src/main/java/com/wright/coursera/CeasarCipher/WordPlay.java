package com.wright.coursera.CeasarCipher;

public class WordPlay {
	public boolean isVowel(char ch) {
		String vowels = "aeiouAEIOU";
		if (vowels.indexOf(ch)>=0) return true;
		return false;
	}
	public String replaceVowels(String phrase, char ch) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<phrase.length(); i++) {
			if (isVowel(phrase.charAt(i))) {
				sb.append(ch);
			} else {
				sb.append(phrase.charAt(i));
			}
		}
		return sb.toString();
	}
	public String emphasize(String phrase, char ch) {
		StringBuilder sb = new StringBuilder();
		char evenMatchChar = '+';
		char oddMatchChar = '*';
		char evalChar = ' ';
		for (int i=0; i<phrase.length(); i++) {
			evalChar = Character.toLowerCase(phrase.charAt(i)); 
			if (evalChar==ch) {
				if ((i % 2)!=0) {	
					sb.append(evenMatchChar);
				} else {
					sb.append(oddMatchChar);
				}
			} else {
				sb.append(phrase.charAt(i));
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordPlay wp = new WordPlay();
		char ch = ' ';
		
		ch = 'F';
		if (wp.isVowel(ch)) System.out.println(ch + " is a vowel");
		else System.out.println(ch + " is not a vowel");
		
		ch = 'A';
		if (wp.isVowel(ch)) System.out.println(ch + " is a vowel");
		else System.out.println(ch + " is not a vowel");
		
		ch = 'i';
		if (wp.isVowel(ch)) System.out.println(ch + " is a vowel");
		else System.out.println(ch + " is not a vowel");
		
		ch = 'r';
		if (wp.isVowel(ch)) System.out.println(ch + " is a vowel");
		else System.out.println(ch + " is not a vowel");
		
		String s = "Hello World";
		System.out.println(s + " is now:" + wp.replaceVowels(s,'*'));
		
		s="Mary Bella Abracadabra";
		System.out.println(s + " emphasized: " + wp.emphasize(s,'a')); 
	}

}
