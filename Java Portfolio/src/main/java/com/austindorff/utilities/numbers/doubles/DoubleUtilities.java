package com.austindorff.utilities.numbers.doubles;

public class DoubleUtilities 
{
	public static double roundToGivenDecimalPlace(double input, int decimalPlaces)
	{
		double returnedDouble = 0;
		int multiplier = 1;
		for (int index = 0; index < decimalPlaces; index++)
		{
			multiplier = multiplier * 10;
		}
		returnedDouble = input * multiplier;
		returnedDouble = Math.round(returnedDouble);
		returnedDouble = returnedDouble / multiplier;
		return returnedDouble;
	}
}
