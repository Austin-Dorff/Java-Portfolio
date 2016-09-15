package com.austindorff.utilities.strings.alter;

public class AlteringStringUtilities 
{
	/*
	 * @Param str the string input
	 * Removes all spaces from str
	 * Returns the new string made from str minus all spaces
	 */
	public static String removeSpaces(String str)
	{
		char[] charArray = str.toCharArray();
		String alteredString = str;
		
		for (int index = 0; index < charArray.length; index++)
		{
			char charAt = charArray[index];
			if (charAt == ' ')
			{
				alteredString = removeCharAtLocation(alteredString, index);
			}
		}
		return alteredString;
	}
	
	/*
	 * @Param str the string input
	 * Removes all chars at odd indexes of str
	 * Returns the new string made from str minus all of the chars at odd indexes
	 */
	public static String removeOddChars(String str)
	{
		int length = (str.length() - 1);
		String alteredString = str;
		
		for (int index = 1; index < length; index += 2)
		{
			alteredString = removeCharAtLocation(alteredString, index);
		}
		return alteredString;
	}

	/*
	 * @Param str the string input
	 * Removes all chars at odd indexes of str
	 * Returns the new string made from str minus all of the chars at even indexes
	 */
	public static String removeEvenChars(String str)
	{
		int length = (str.length() - 1);
		String alteredString = str;
		
		for (int index = 0; index < length; index += 2)
		{
			alteredString = removeCharAtLocation(alteredString, index);
		}
		return alteredString;
	}
	
	/*
	 * @Param str the string input
	 * @Param location the location of the char to be removed
	 * Removes the char at the given location in the string
	 * Returns the new string made from str minus the removed char
	 */
	public static String removeCharAtLocation(String str, int location)
	{
		String alteredString = "";

		if (location >= 0 && location <= (str.length() - 1))
		{
			StringBuilder builtString = new StringBuilder(str);
			builtString.deleteCharAt(location);
			alteredString = builtString.toString();
		}
		else
		{
			alteredString = str + " Error. Location does not exist in the inputted string";
		}
		return alteredString;
	}

	/*
	 * @Param str the string input
	 * Returns the new string made from str in reverse
	 */
	public static String reverseString(String str)
	{
		String alteredString = "";
		StringBuilder builtString = new StringBuilder(str);
		builtString.reverse();
		alteredString = builtString.toString();
		return alteredString;
	}
	
	/*
	 * @Param str the string input
	 * @Param locationOfChar the location of the char to be removed
	 * @Param newChar the char that will replace the char at locationOfChar
	 * Replaces the char at locationOfChar with newChar
	 * Returns the new string made from str with the new char at the given location
	 */
	public static String changeCharAtLocationTo(String inputString, int locationOfChar, char newChar)
	{
		char[] charArray = inputString.toCharArray();
		String firstPortion = "";
		String secondPortion = "";
		String replacedPart = "" + newChar;
		String alteredString = "";
		
		if (locationOfChar <= charArray.length && locationOfChar >= 0)
		{
			for (int index = 0; index < locationOfChar; index++)
			{
				char charInIndex = charArray[index];
				firstPortion = firstPortion + charInIndex;
			}
			for (int index = (locationOfChar + 1); index < charArray.length; index++)
			{
				char charInIndex = charArray[index];
				secondPortion = secondPortion + charInIndex;
			}
			alteredString = firstPortion + replacedPart + secondPortion;
		}
		else
		{
			alteredString = inputString + " Error. Location does not exist in the inputted string";
		}	
		return alteredString;
	}
	
	/*
	 * @Param str the string input
	 * @Param firstChar the location of the char to be removed
	 * @Param secondChar the char that will replace the char at locationOfChar
	 * Replaces all instances of firstChar with secondChar and vice versa
	 * Returns the new string made from str with the swapped chars
	 */
	public static String letterSwap(String str, char firstChar, char secondChar)
	{		
		String alteredString = str;
		for (int index = 0; index < (str.length() - 1); index++)
		{
			char charAt = str.charAt(index);
			if (charAt == firstChar)
			{
				alteredString = changeCharAtLocationTo(alteredString, index, secondChar);
			}
			else if (charAt == secondChar)
			{
				alteredString = changeCharAtLocationTo(alteredString, index, firstChar);
			}
		}
		return alteredString;
	}

}
