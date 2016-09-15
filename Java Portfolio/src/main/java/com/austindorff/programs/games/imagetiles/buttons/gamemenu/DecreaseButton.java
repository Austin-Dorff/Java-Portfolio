package com.austindorff.programs.games.imagetiles.buttons.gamemenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.states.GameState;

public class DecreaseButton extends AdvancedButton 
{

	public DecreaseButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
	}
	
	@Override
	public void doAction()
	{
		GameState.numMovesLeft = GameState.numMovesLeft - 1;
	}

}
