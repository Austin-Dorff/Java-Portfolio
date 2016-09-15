package com.austindorff.programs.calculators.boards;

public class Board
{
	double actualWidth = 0;
	double actualHeight = 0;
	double length = 0;
	double width = 0;
	double height = 0;
	String type = "";
	
	
	public Board(double lengthInput, double widthInput, double heightInput)
	{
		length = lengthInput;
		height = heightInput;
		width = widthInput;
		if ((heightInput <= 1.5) && (heightInput >= 1.0) && (heightInput % 0.5 == 0))
		{
			actualHeight = heightInput - 0.25;
		}
		else if ((heightInput > 1.5) && (heightInput % 0.5 == 0))
		{
			actualHeight = heightInput - 0.5;
		}
		if ((widthInput < 2.0) && (widthInput >= 1.0) && (widthInput % 0.5 == 0))
		{
			actualWidth = widthInput - 0.5;
		}
		else if ((widthInput >= 2.0) && (widthInput < 8.0) && (widthInput % 0.5 == 0))
		{
			actualWidth = widthInput - 0.25;
		}
		else
		{
			actualWidth = widthInput - 0.75;
		}
	}
	
	public String getType()
	{
		return height + "\" by " + width + "\"";
	}
	
	public double getLength()
	{
		return length;
	}
	
	public double getActualWidth()
	{
		return actualWidth;
	}
	
	public double getActualHeight()
	{
		return actualHeight;
	}
}
