package com.austindorff.programs.games.imagetiles.buttons.gamemenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;

public class ResetButton extends AdvancedButton
{
	public ResetButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
	}

}
