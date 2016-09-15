package com.austindorff.programs.calculators.boards;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BoardCalculator
{
	ArrayList<Board> componentBoards = new ArrayList<Board>();
	Board[][] finalBoards;
	
	int numBoards = 0;
	
	public BoardCalculator()
	{
		addComponentBoards();
	}

	private void addComponentBoards()
	{
		numBoards = Integer.parseInt(JOptionPane.showInputDialog("Please enter the total number of boards to be calculated, tis includes boards of different types."));
		finalBoards = new Board[numBoards][numBoards];
		for (int index = 0; index < numBoards; index++)
		{
			int width = Integer.parseInt(JOptionPane.showInputDialog("Please enter the width board One (do not enter the actual width)."));
			int height = Integer.parseInt(JOptionPane.showInputDialog("Please enter the height board One (do not enter the actual height)."));
			double length = Integer.parseInt(JOptionPane.showInputDialog("Please enter the length board One."));
			int numBoardSpecific = Integer.parseInt(JOptionPane.showInputDialog("Please enter the numbr of board ones to be created"));
			
			for (int index2 = 0; index2 < numBoardSpecific; index2++)
			{
				componentBoards.add(new Board(length, width, height));
			}
		}
	}

	public void matchComponentsToStandardBoard()
	{
		int finalBoardCounter = 0;
		while (numBoards != 0)
		{
			double longestComponentLength = 0;
			int componentBoardCounter = 0;
			int placeMarker = 0;
			for (int index = 0; index < componentBoards.size(); index++)
			{
				Board checked = componentBoards.get(index);
				double temp = checked.getLength();
				if (temp > longestComponentLength)
				{
					placeMarker = index;
					longestComponentLength = temp;
				}
			}
		}

		
	}

}
