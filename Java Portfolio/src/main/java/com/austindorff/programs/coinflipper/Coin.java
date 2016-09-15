package com.austindorff.programs.coinflipper;

import java.util.Random;

public class Coin
{
	private int face = 0;
	// 0 == heads
	// 1 == tails
	String finalString = "";
	int numHeads = 0;
	int numTails = 0;
	
	public Coin(String startingFace)
	{
		String sf = startingFace.toLowerCase();
		if (sf.equals("heads"))
		{
			setFace(0);
		}
		else if (sf.equals("tails"))
		{
			setFace(1);
		}
		else
		{
			Random generator = new Random();
			int faceRan = generator.nextInt(2);
			setFace(faceRan);
			System.out.println("Coin was randomly set to: " + getFace() + " due to input error.");
			
		}
	}
	
	public void flipCoin(int numTimes)
	{
		for (int index = 0; index < numTimes; index++)
		{
			Random generator = new Random();
			face = generator.nextInt(2);
			if (face == 0)
			{
				numHeads++;
			}
			else
			{
				numTails++;
			}
			finalString += (getFace() + ", ");
		}
	}
	
	public void printToConsole()
	{
		System.out.println(finalString);
		System.out.println("Heads: " + numHeads + " Tails: " + numTails + " Total: " + (numHeads + numTails));
	}
	
	public String getFace()
	{
		if (face == 0)
		{
			return "Heads";
		}
		else
		{
			return "Tails";
		}
	}
	
	public void setFace(int faceID)
	{
		face = faceID;
	}
}
