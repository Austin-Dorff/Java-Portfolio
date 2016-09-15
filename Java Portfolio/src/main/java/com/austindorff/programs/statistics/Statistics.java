package com.austindorff.programs.statistics;

import com.austindorff.utilities.arrays.integers.IntegerArrayUtilities;

public class Statistics 
{
	private final int arraySize = 100000;
	public int[] allNumbers = new int[arraySize];
	private int index = 0;
	private int index2 = 0;
	private int counter = 1;
	private int temp = 0;
	private int temp2 = 0;
	private int instancesOfChecked = 1;
	private int instancesOfMode = 1;
	private int intChecked = 0;
	private int newInt = 0;
	private int newLengthMin = 0;
	private int newLengthMax = 0;
	public int mode = 0;
	private int totalSum = 0;
	private int min = 101;
	private int max = 0;
	private String theArray = "";
	private boolean contains = false;

    public Statistics()
    {
    	allNumbers = IntegerArrayUtilities.createRandomArray(arraySize, 1, 100);
    }
    
    public String toString()
    {
        theArray = "";
        for(index = 0; index < allNumbers.length; index++)
        {
            if(index % 10 == 0) theArray += "\n";
            theArray += allNumbers[index] + "\t";
        }
        return theArray;
    }
    
    public double average()
    {
    	for (index = 0; index < allNumbers.length; index++)
    	{
    		totalSum = totalSum + allNumbers[index];
    	}
    	return (double)(totalSum / allNumbers.length);
    }
    
    public int mode()
    {
    	mode = 0;
    	instancesOfMode = 1;
    	for (index = 0; index < allNumbers.length; index++)
    	{
    		instancesOfChecked = getInstancesOfNumber(allNumbers[index]);
    		if (instancesOfChecked > instancesOfMode)
    		{
    			instancesOfMode = instancesOfChecked;
    			mode = allNumbers[index];
    		}
    	}
    	return mode;
    }
    
    public int getInstancesOfNumber(int number)
    {
    	counter = 0;
    	for (index2 = 0; index2 < allNumbers.length; index2++)
    	{
    		if (allNumbers[index2] == number)
    		{
    			counter++;
    		}
    	}
		return counter;
    }
    
    public int min()
    {
    	for (index = 0; index < allNumbers.length; index++)
    	{
    		intChecked = allNumbers[index];
    		if (intChecked <= min)
    		{
    			min = intChecked;
    		}
    	}
    	return min;
    }
    
    public int max()
    {
    	for (index = 0; index < allNumbers.length; index++)
    	{
    		intChecked = allNumbers[index];
    		if (intChecked >= max)
    		{
    			max = intChecked;
    		}
    	}
    	return max;
    }
    
    public boolean findInt_Linear(int number)
    {
    	return getInstancesOfNumber(number) > 0 ? true : false;
    }
    
    public int median()
    {
    	return allNumbers[(allNumbers.length / 2)];
    }
    
    public boolean findInt_Binary(int number)
    {
    	contains = false;
    	newLengthMax = allNumbers.length;
    	newLengthMin = 0;
    	while (contains == false)
    	{
        	index2 = (int)(((newLengthMax - newLengthMin) / 2) + (newLengthMin - 1));
        	intChecked = allNumbers[index2];
        	if (intChecked == number)
        	{
        		contains = true;
        	}
        	else 
        	{
        		if (intChecked < number)
        		{
            		newLengthMin = index2;
            		newLengthMax = allNumbers.length;
        		}
        		else
        		{
            		newLengthMin = 0;
            		newLengthMax = (index2 - 1);
        		}

        	}
        	
    	}
    	return contains;
    }
}
