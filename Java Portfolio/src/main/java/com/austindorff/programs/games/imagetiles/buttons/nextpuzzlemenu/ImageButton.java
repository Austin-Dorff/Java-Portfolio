package com.austindorff.programs.games.imagetiles.buttons.nextpuzzlemenu;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.AdvancedButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.runner.Reference;
import com.austindorff.programs.games.imagetiles.states.GameState;

public class ImageButton extends AdvancedButton 
{
	private int id;
	private GUIContext c;
	
	public ImageButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos, GameSound soundInput, int id)
	{
		super(container, sbGame, theMap, buttonImage, textStr, screenLocation, yPos, soundInput);
		this.id = id;
		c = container;
	}
	
	@Override
	public void doAction() throws SlickException
	{
		super.doAction();
		GameState.setImageIndex(id);
		Resources.getPuzzleImageInstance1(Resources.getPuzzleArray1().get(id).getName()).generateSubImages(id);
		super.getSBG().enterState(Reference.GAME_STATE_ID);
		Resources.getMusicInstance(Reference.GAME_MUSIC_NAME).play();
	}
	
	@Override
	public boolean isMouseHovering()
	{
		if ((c.getInput().getMouseX() >= getX()) && (c.getInput().getMouseX() <= (getX() + (getWidth() / 4))) && (c.getInput().getMouseY() >= getY()) && (c.getInput().getMouseY() <= (getY() + (getHeight() / 4))))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
