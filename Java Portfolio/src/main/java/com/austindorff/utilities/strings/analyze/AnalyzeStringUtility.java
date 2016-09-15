package com.austindorff.utilities.strings.analyze;

public class AnalyzeStringUtility
{
	/*
	 *Gets the number of instances of a char in a string and returns the value as an integer
	 *@Param str - the string that is checked for the char
	 *@Param ch - checks str for this char
	 */	
	public static int numberOf(char ch, String str)
	{
		int length = (str.length() - 1);
		int counter = 0;
		char charAt;
		
		for (int index = 0; index < length; index++)
		{
			charAt = str.charAt(index);
			if (charAt == ch)
			{
				counter++;
			}
		}
		return counter;
	}
	
	/*
	 *Creates and returns a string containing all of the consonants from the input string
	 *Method is not case sensitive
	 *@Param input - the string that is checked for all consonants
	 */	
	public static String getConsonants(String input)
	{
		char[] charArray = input.toCharArray();
		char[] vowelsLowerCase = new char[] {'a', 'e', 'i', 'o', 'u'};
		char[] vowelsUpperCase = new char[] {'A', 'E', 'I', 'O', 'U'};

		String finalString = "";
		boolean contains = false;
		for (int index = 0; index < charArray.length; index++)
		{
			char charAt = charArray[index];
			
			for (int index1 = 0; index1 < vowelsLowerCase.length; index1++)
			{
				if (charAt != vowelsLowerCase[index1] && charAt != vowelsUpperCase[index1])
				{
					contains = true;
					break;
				}
			}
			if (contains == true)
			{
				finalString = finalString + charAt;
			}
		}
		return finalString;
	}
	
	/*
	 *Creates and returns a string containing all of the vowels from the input string
	 *Method is not case sensitive
	 *@Param input - the string that is checked for all vowels
	 */	
	public static String getVowels(String input)
	{
		char[] charArray = input.toCharArray();
		char[] vowelsLowerCase = new char[] {'a', 'e', 'i', 'o', 'u'};
		char[] vowelsUpperCase = new char[] {'A', 'E', 'I', 'O', 'U'};

		String finalString = "";
		boolean contains = false;
		
		for (int index = 0; index < charArray.length; index++)
		{
			char charAt = charArray[index];
			for (int index1 = 0; index1 < vowelsLowerCase.length; index1++)
			{
				if (charAt == vowelsLowerCase[index1] || charAt == vowelsUpperCase[index1])
				{
					contains = true;
					break;
				}
				else
				{
					contains = false;
				}
			}
			if (contains == true)
			{
				finalString = finalString + charAt;
			}
		}
		return finalString;
	}
	
	/*
	 * Creates a concatenated string from the two input strings
	 * @Param str1 the first input string
	 * @Param str2 the second input string
	 * @Param position the last character from each string to be included in the concatenated string
	 * The resulting string includes the chars from each string starting at an index of 0 and ending at the position
	 */	
	public static String customConcat(String str1, String str2, int position)
	{
		char[] str1CharArray = str1.toCharArray();
		char[] str2CharArray = str2.toCharArray();
		String finalString = "";
		
		if (position < str1CharArray.length)
		{
			for (int index = 0; index < position; index++)
			{
				finalString = finalString + str1CharArray[index];
			}
		}
		else
		{
			finalString = finalString + str1;
		}
		
		if (position < str2CharArray.length)
		{
			for (int index = 0; index < position; index++)
			{
				finalString = finalString + str2CharArray[index];
			}
		}
		else
		{
			finalString = finalString + str2;
		}
		return finalString;
	}
}
