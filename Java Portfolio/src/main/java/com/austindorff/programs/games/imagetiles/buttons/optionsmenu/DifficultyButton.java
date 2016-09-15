package com.austindorff.programs.games.imagetiles.buttons.optionsmenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.images.PuzzleImage;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;

public class DifficultyButton extends AdvancedButton 
{
	int counter = 0;
	private String	difficultyButtonText = "Difficulty: Easy";
	public static int difficulty = 0;

	public DifficultyButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		if (counter == 0)
		{
			difficulty = 1;
			difficultyButtonText = "Difficulty: Medium";
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			counter++;
		}
		else if (counter == 1)
		{
			difficulty = 2;
			difficultyButtonText = "Difficulty: Hard";
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			counter++;
		}
		else if (counter == 2)
		{
			difficulty = 3;
			difficultyButtonText = "Difficulty: Expert";
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			counter++;
		}
		else if (counter == 3)
		{
			difficulty = 0;
			difficultyButtonText = "Difficulty: Easy";
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			counter = 0;
		}
	}
	
	@Override
	public String getText()
	{
		return difficultyButtonText;
	}
	
	public static int getDifficulty()
	{
		return difficulty;
	}

}
