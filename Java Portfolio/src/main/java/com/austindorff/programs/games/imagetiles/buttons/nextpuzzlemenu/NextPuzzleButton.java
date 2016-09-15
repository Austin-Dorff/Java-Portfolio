package com.austindorff.programs.games.imagetiles.buttons.nextpuzzlemenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.images.PuzzleImage;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class NextPuzzleButton extends AdvancedButton 
{
	StateBasedGame sbg;
	
	public NextPuzzleButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
		sbg = sbGame;
	}
	
	@Override
	public void doAction() throws SlickException
	{
		PuzzleImage.setPuzzleNumber(PuzzleImage.getPuzzleNumber() + 1);
		if (Resources.getPuzzleArray1().size() > PuzzleImage.getPuzzleNumber())
		{
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			sbg.enterState(Reference.GAME_STATE_ID);
		}
		else
		{
			PuzzleImage.setPuzzleNumber(0);
			PuzzleImage.generateSubImages(PuzzleImage.getPuzzleNumber());
			sbg.enterState(Reference.GAME_STATE_ID);
		}

	}

}
