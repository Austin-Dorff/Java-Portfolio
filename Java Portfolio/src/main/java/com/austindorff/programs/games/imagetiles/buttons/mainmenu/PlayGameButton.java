package com.austindorff.programs.games.imagetiles.buttons.mainmenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class PlayGameButton extends AdvancedButton 
{

	public PlayGameButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound buttonSound)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, buttonSound);
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		super.getSBG().enterState(Reference.CHOOSE_IMAGE_STATE_ID);
	}

}
