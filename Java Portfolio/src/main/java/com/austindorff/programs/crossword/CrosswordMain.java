package com.austindorff.programs.crossword;

import java.util.Random;

import javax.swing.JOptionPane;

public class CrosswordMain 
{
	static int width = 10; 
	static int height = 10;
	static int counter = 0;
	static int numberOfWords = 0;
	
	static boolean validLocation = true;
	static boolean wordFits = true;
	static boolean valid = false;
	
	static String spacer = "  ";
	static String title = "";
	static String word = "";
	
	static char charAt = ' ';
	
	static char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	static char[][] crosswordChars;
	static char[][] usedCrosswordChars;
	
	public static void generateCrossword()
	{
		title = JOptionPane.showInputDialog(null, "Please Enter The Title Of The Crossword.");
		width = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter The Number Of Columns (Horizontal) You Want The Crossword To Have."));
		height = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter The Number Of Rows (Vertical) You Want The Crossword To Have."));
		numberOfWords = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter The Number Of Words You Want The Crossword To Have."));
		String[] crosswordWords = new String[numberOfWords];
		counter = 1;
		for (int index = 0; index < numberOfWords; index++)
		{
			word = JOptionPane.showInputDialog(null, "Please Enter Word Number: " + counter + ".");
			counter++;
			crosswordWords[index] = word; 
		}
		crosswordChars = new char[width][height];
		usedCrosswordChars = new char[width][height];
		for (int index = 0; index < width; index++)
		{
			for (int index2 = 0; index2 < height; index2++)
			{
				Random generator = new Random();
				int letterLocation = generator.nextInt(26);
				crosswordChars[index][index2] = letters[letterLocation];
			}
		}
		for (int index = 0; index < crosswordWords.length; index++)
		{
			addWord(crosswordWords[index]);
		}
	}
	
	public static void printCrossword()
	{
		char[] titleCharArray = title.toUpperCase().toCharArray();
		int startingPosition = (width - title.length())/2;
		for (int index = 0; index < startingPosition; index++)
		{
			System.out.print(" " + spacer);
		}
		for (int index = 0; index < title.length(); index++)
		{
			System.out.print(titleCharArray[index] + spacer);
		}
		System.out.println();
		for(int index = 0; index < width; index++)
		{
			for (int index2 = 0; index2 < height; index2++)
			{
				System.out.print(crosswordChars[index][index2] + spacer);
				if (index2 == width - 1)
				{
					System.out.println();
				}
			}
		}
	}
	
	public static void addWord(String word)
	{
		
		Random generator = new Random();
		int directionHVD = generator.nextInt(3);
		int directionFB = generator.nextInt(2);
		int directionDiagonalLeftOrRight = generator.nextInt(2);
		char[] wordArray = word.toLowerCase().toCharArray();
		int wordLength = word.length() - 1;
		int xLocation = 0;
		int yLocation = 0;
		
		switch (directionHVD)
		{
			case 0: // Diagonal
				switch (directionDiagonalLeftOrRight)
				{
					case 0: // Left to Right
						valid = false;
						while (valid != true)
						{
							yLocation = generator.nextInt(Math.abs(height - wordLength));
							xLocation = generator.nextInt(Math.abs(width - wordLength));
							valid = canAddWordAtLocation(0, directionFB, 0, wordArray, xLocation, yLocation);
						}
						if (valid == true)
						{
							switch (directionFB)
							{
								case 0:
									for (int index = 0; index < wordArray.length; index++)
									{
										crosswordChars[xLocation + index][yLocation + index] = wordArray[index];
										usedCrosswordChars[xLocation + index][yLocation + index] = wordArray[index];
									}
									break;
								case 1:
									for (int index = 0; index < (wordLength + 1); index++)
									{
										crosswordChars[xLocation + index][yLocation + index] = wordArray[word.length() - 1 - index];
										usedCrosswordChars[xLocation + index][yLocation + index] = wordArray[word.length() - 1 - index];
									}
									break;
							}
						}
						break;
					case 1:
						valid = false;
						while (valid != true)
						{
							yLocation = generator.nextInt(Math.abs(height - wordLength)) + wordLength;
							xLocation = generator.nextInt(Math.abs(width - wordLength)) + wordLength;
							valid = canAddWordAtLocation(1, directionFB, 0, wordArray, xLocation, yLocation);
						}
						if (valid == true)
						{
							switch (directionFB)
							{
								case 0:
									for (int index = 0; index < wordArray.length; index++)
									{
										crosswordChars[xLocation - index][yLocation - index] = wordArray[index];
										usedCrosswordChars[xLocation - index][yLocation - index] = wordArray[index];
									}
									break;
								case 1:
									for (int index = 0; index < wordArray.length; index++)
									{
										crosswordChars[xLocation - index][yLocation - index] = wordArray[wordLength - index];
										usedCrosswordChars[xLocation - index][yLocation - index] = wordArray[wordLength - index];
									}
									break;
							}
						}
						break;
				}
				break;
			case 1:
				valid = false;
				while (valid != true)
				{
					yLocation = generator.nextInt(height);
					xLocation = generator.nextInt(Math.abs(width - wordLength));
					valid = canAddWordAtLocation(0, directionFB, 1, wordArray, xLocation, yLocation);
				}
				if (valid == true)
				{
					switch (directionFB)
					{
						case 0:
							for (int index = 0; index < wordArray.length; index++)
							{
								crosswordChars[xLocation + index][yLocation] = wordArray[index];
								usedCrosswordChars[xLocation + index][yLocation] = wordArray[index];
							}
							break;
						case 1:
							for (int index = 0; index < wordArray.length; index++)
							{
								crosswordChars[xLocation + index][yLocation] = wordArray[wordLength - index];
								usedCrosswordChars[xLocation  + index][yLocation] = wordArray[wordLength - index];
							}
							break;
					}
				}
				break;
			case 2:
				valid = false;
				while (valid != true)
				{
					yLocation = generator.nextInt(Math.abs(height - wordLength));
					xLocation = generator.nextInt(width);
					valid = canAddWordAtLocation(0, directionFB, 2, wordArray, xLocation, yLocation);
				}
				if (valid == true)
				{
					switch (directionFB)
					{
						case 0:
							for (int index = 0; index < wordArray.length; index++)
							{
								crosswordChars[xLocation][yLocation + index] = wordArray[index];
								usedCrosswordChars[xLocation][yLocation + index] = wordArray[index];
							}
							break;
						case 1:
							for (int index = 0; index < wordArray.length; index++)
							{
								crosswordChars[xLocation][yLocation + index] = wordArray[wordLength - index];
								usedCrosswordChars[xLocation][yLocation + index] = wordArray[wordLength - index];
							}
							break;
					}
				}
				break;
		}
	}
	
	public static boolean findWord(String word)
	{
		char[] wordCharArray = word.toLowerCase().toCharArray();
		int wordLength = word.length() - 1;
		char charCompared = ' ';
		char charComparedTo = ' '; 
		boolean contains = false;
		int index3 = 0;
		for (int index = 0; index < height; index++)
		{
			Inner_Loop:
				for (int index2 = 0; index2 < width; index2++)
				{
					charCompared = crosswordChars[index][index2];
					if (charCompared == wordCharArray[0])
					{
						// H F
						index3 = word.length();
						contains = false;
						if ((index2 + index3) < width)
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index][index2 + index3];
								charComparedTo = wordCharArray[index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// H B
						index3 = word.length();
						contains = false;
						if ((index2 + index3) < width)
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index][index2 + index3];
								charComparedTo = wordCharArray[wordLength - index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// V F
						index3 = word.length();
						contains = false;
						if ((index2 + index3) < height)
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index + index3][index2];
								charComparedTo = wordCharArray[index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// V B
						index3 = word.length();
						contains = false;
						if ((index - index3) > -1)
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index + index3][index2];
								charComparedTo = wordCharArray[wordCharArray.length - 1 - index3];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// D L2R F
						index3 = word.length();
						contains = false;
						if ((index2 <= (width - index3)) && (index <= (height - index3)))
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index + index3][index2 + index3];
								charComparedTo = wordCharArray[index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// D L2R B
						index3 = word.length();
						contains = false;
						if ((index2 >= (width - index3)) && (index >= (height - index3)))
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index + index3][index2 + index3];
								charComparedTo = wordCharArray[wordLength - index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// D R2L F
						contains = false;
						if ((index2 >= (width - index3)) && (index >= (height - index3)))
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index - index3][index2 + index3];
								charComparedTo = wordCharArray[index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
						}
						// D R2L B
						index3 = word.length();
						contains = false;
						if ((index2 <= (width - index3)) && (index <= (height - index3)))
						{
							for (index3 = 0; index3 < word.length(); index3++)
							{
								charCompared = crosswordChars[index - index3][index2 + index3];
								charComparedTo = wordCharArray[wordLength - index];
								if (charCompared == charComparedTo)
								{
									contains = true;
								}
								else
								{
									contains = false;
									break;
								}
							}
						}
						if ((index3 == wordLength) && (contains == true))
						{
							return true;
						}
						else
						{
							contains = false;
							continue Inner_Loop;
						}
					}
				}
		}
		return contains;
	}
	
	public static boolean canAddWordAtLocation(int directionDiagonal, int directionFB, int directionHVD, char[] charArray, int x, int y)
	{
		switch (directionHVD)
		{
			case 0: // Diagonal
				switch (directionFB)
				{
					case 0: // Forwards
						switch (directionDiagonal) // From Left to Right
						{
							case 0:
								for (int index = 0; index < charArray.length; index++)
								{
									boolean willWork = checkLocation(x + index, y + index, charArray[index]);
									if (willWork == true)
									{
										wordFits = true;
									}
									else
									{
										wordFits = false;
										break;
									}
								}
								break;
							case 1: // From Right to Left
								for (int index = 0; index < charArray.length; index++)
								{
									boolean willWork = checkLocation(x - index, y - index, charArray[index]);
									if (willWork == true)
									{
										wordFits = true;
									}
									else
									{
										wordFits = false;
										break;
									}
								}
								break;
						}
						break;
						
					case 1: // Backwards
						
						switch (directionDiagonal)
						{
							case 0:
								for (int index = 0; index < charArray.length; index++)
								{
									boolean willWork = checkLocation(x + index, y + index, charArray[charArray.length - index - 1]);
									if (willWork == true)
									{
										wordFits = true;
									}
									else
									{
										wordFits = false;
										break;
									}
								}
								break;	
							case 1:
								for (int index = 0; index < charArray.length; index++)
								{
									boolean willWork = checkLocation(x - index, y - index, charArray[charArray.length - index - 1]);
									if (willWork == true)
									{
										wordFits = true;
									}
									else
									{
										wordFits = false;
										break;
									}
								}
								break;	
						}
						break;
						
				}
				break;
			case 1: // Horizontal
				switch (directionFB)
				{
					case 0: // Forwards
						for (int index = 0; index < charArray.length; index++)
						{
							boolean willWork = checkLocation(x + index, y, charArray[index]);
							if (willWork == true)
							{
								wordFits = true;
							}
							else
							{
								wordFits = false;
								break;
							}
						}
						break;
					case 1: // Backwards
						for (int index = 0; index < charArray.length; index++)
						{
							boolean willWork = checkLocation(x + index, y, charArray[charArray.length - index - 1]);
							if (willWork == true)
							{
								wordFits = true;
							}
							else
							{
								wordFits = false;
								break;
							}
						}
						break;	
				}
				break;
			case 2: // Vertical
				switch (directionFB)
				{
					case 0: // Forwards
						for (int index = 0; index < charArray.length; index++)
						{
							boolean willWork = checkLocation(x, y + index, charArray[index]);
							if (willWork == true)
							{
								wordFits = true;
							}
							else
							{
								wordFits = false;
								break;
							}
						}
						break;
					case 1: // Backwards
						for (int index = 0; index < charArray.length; index++)
						{
							boolean willWork = checkLocation(x, y + index, charArray[charArray.length - index - 1]);
							if (willWork == true)
							{
								wordFits = true;
							}
							else
							{
								wordFits = false;
								break;
							}
						}	
				}
				break;
		}
		return wordFits;
	}
	
	
	private static boolean checkLocation(int x, int y, char desiredChar)
	{
		char comparedChar = usedCrosswordChars[x][y];
		if (comparedChar == '\u0000')
		{
			return true;
		}
		else
		{
			if (comparedChar == desiredChar)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
}
