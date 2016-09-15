package com.austindorff.programs.games.imagetiles.buttons.optionsmenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;

public class SoundsButton extends AdvancedButton 
{
	private static boolean	soundEnabled = true;
	private String soundButtonText = "Sounds: Enabled";
	int counter = 0;

	public SoundsButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		if (counter == 0)
		{
			soundEnabled = false;
			soundButtonText = "Sounds: Disabled";
			counter++;
		}
		else
		{
			soundEnabled = true;
			soundButtonText = "Sounds: Enabled";
			counter = 0;
		}
	}
	
	@Override
	public String getText()
	{
		return soundButtonText;
	}
	
	public static boolean soundsEnabled()
	{
		return soundEnabled;
	}

}
