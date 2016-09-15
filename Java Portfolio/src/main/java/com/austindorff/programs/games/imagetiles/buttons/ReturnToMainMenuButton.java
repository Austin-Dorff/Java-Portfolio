package com.austindorff.programs.games.imagetiles.buttons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class ReturnToMainMenuButton extends AdvancedButton 
{
	public ReturnToMainMenuButton(GUIContext container, StateBasedGame sbGame,  TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		Resources.getMusicInstance(Reference.GAME_MUSIC_NAME).stop();
		super.getSBG().enterState(0);
	}

}
