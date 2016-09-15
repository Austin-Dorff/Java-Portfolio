package com.austindorff.programs.games.imagetiles.buttons;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;

public class AdvancedButton extends BasicButton
{
	GameSound	sound;

	public AdvancedButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos);
		sound = soundInput;
	}

	@Override
	public void doAction() throws SlickException
	{
		sound.play();
	}
}
