package com.austindorff.utilities.strings;

import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;

public class StringMetrics
{
	Font				font;

	public StringMetrics(Graphics graphics)
	{
		font = graphics.getFont();
	}

	public int getWidth(String message)
	{
		return (int) font.getWidth(message);
	}

	public int getHeight(String message)
	{
		return (int) font.getHeight(message);
	}
}
