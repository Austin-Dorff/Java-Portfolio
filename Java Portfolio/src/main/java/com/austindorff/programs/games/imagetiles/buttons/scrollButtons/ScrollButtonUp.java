package com.austindorff.programs.games.imagetiles.buttons.scrollButtons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.states.ChooseImageState;

public class ScrollButtonUp extends AdvancedButton 
{
	
	private ChooseImageState cis;

	public ScrollButtonUp(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput, ChooseImageState cis)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
		super.setLocation(662, 10);
		this.cis = cis;
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		cis.scrollUp();
	}
	
}
