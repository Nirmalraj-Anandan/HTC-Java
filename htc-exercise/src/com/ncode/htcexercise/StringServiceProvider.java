package com.ncode.htcexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class StringServiceProvider {

	// object method to reverse a string
	public String reverseString(String inString) {
		if ((null == inString) || (inString.length() <= 1)) {
			return inString;
		}
		return reverseString(inString.substring(1)) + inString.charAt(0);
	}

	// object method to search for a character in string
	public void linearSearchChar(String inString, String srchString) {

		int counter = 0;

		for (String chkStr : inString.split(" ")) {
			counter++;

			if (chkStr.equalsIgnoreCase(srchString)) {
				System.out.println(srchString + " found at position " + Integer.toString(counter));
			}
		}
	}

	// object method to search for a character in string
	// overloaded
	public void linearSearchChar(String inString, char srchChar) {

		int counter = 0;
		String position = "";
		int flag=0;

		if (!inString.trim().isEmpty() && srchChar != ' ') {
			for (char ch : inString.toCharArray()) {
				counter++;
				if (ch == srchChar && flag == 0) {
					position = Integer.toString(counter);
					flag=1;
				} else if (ch == srchChar && flag != 0) {
					position += ", " + Integer.toString(counter);
				}

				System.out.println(ch);
			}

			System.out.println("Character " + srchChar + " found at position(s) " + position);
		} else {
			System.out.println("Please check input values.");
		}
	}

	// object method to search replace character in a string
	public String searchReplace(String inString, char srchChar, char repChar) {

		String replacedString = "";

		if (!inString.trim().isEmpty() && srchChar != ' ' && repChar != ' ') {
			for (char ch : inString.toCharArray()) {
				if (ch == srchChar) {
					replacedString = replacedString + repChar;
				} else {
					replacedString = replacedString + ch;
				}
			}

			return replacedString;
		} else {
			System.out.println("Please check input values.");
			return null;
		}
	}

	// class methods
	static void sReverseString(String inString) {

		char[] hello = inString.toCharArray();
		List<Character> rev = new ArrayList<>();

		for (char c : hello)
			rev.add(c);

		Collections.reverse(rev);
		ListIterator li = rev.listIterator();
		while (li.hasNext())
			System.out.print(li.next());

	}

	static void sLinearSearchChar(String inString, char srchChar) {

		int counter = 0;
		String position = "";
		int flag=0;

		if (!inString.trim().isEmpty() && srchChar != ' ') {
			for (char ch : inString.toCharArray()) {
				counter++;
				
				if (ch == srchChar && flag == 0) {
					position = Integer.toString(counter);
					flag = 1;
				} else if (ch == srchChar && flag != 0) {
					position += ", " + Integer.toString(counter);
				}

			}

			System.out.println("Character " + srchChar + " found at position(s) " + position);
		} else {
			System.out.println("Please check input values.");
		}
	}

	static String sSearchReplace(String inString, char srchChar, char repChar) {

		String replacedString = "";

		if (!inString.trim().isEmpty() && srchChar != ' ' && repChar != ' ') {
			for (char ch : inString.toCharArray()) {
				if (ch == srchChar) {
					replacedString = replacedString + repChar;
				} else {
					replacedString = replacedString + ch;
				}
			}

			return replacedString;
		} else {
			System.out.println("Please check input values.");
			return null;
		}
	}

	public static void main(String[] args) {

		StringServiceProvider ssp1 = new StringServiceProvider();

		// reverse string using object
		System.out.println("Object method to reverse a string.");
		System.out.println(ssp1.reverseString("Checkers") + "\n");

		// calling static method
		System.out.println("Static method to search for a character/string.");
		sLinearSearchChar("Publics Transport", 's');
		System.out.println("\n");
		
		// overloaded object method to search string
		System.out.println("Overloaded method to search a string.");
		ssp1.linearSearchChar("how wow dow mow bow wow", "wow");
		System.out.println("\n");
		
		// call static method to search and replace a character in a string
		System.out.println("Static method to search and replace for a character.");
		System.out.println(sSearchReplace("how wow dow mow bow wow", 'w', 'x'));
	}

}
