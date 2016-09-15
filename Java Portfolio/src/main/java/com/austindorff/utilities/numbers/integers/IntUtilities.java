package com.austindorff.utilities.numbers.integers;

public class IntUtilities 
{

	public static int sumOfEvens(int num)
	{
		int maxIndex = (num / 2) + 1;
		int sum = 0;
		for (int number = 0; number < maxIndex; number++)
		{
			sum = sum + (number*2);
		}
		return sum;
	}
	
//	public static int sumOfOdds(int num)
//	{
//		int maxIndex = (num / 2) + 2;
//		int sum = 0;
//		for (int number = 1; number < maxIndex; number += 2)
//		{
//			sum = sum + number;
//		}
//		return sum;
//	}
}
