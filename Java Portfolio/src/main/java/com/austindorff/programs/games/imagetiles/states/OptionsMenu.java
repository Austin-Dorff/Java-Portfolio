package com.austindorff.programs.games.imagetiles.states;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.ReturnToMainMenuButton;
import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.DifficultyButton;
import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.SoundsButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class OptionsMenu extends BasicGameState
{
	TheMap					theMap;
	StateBasedGame			sbg;
	GameContainer			c;

	SoundsButton			sounds;
	DifficultyButton		difficulty;
	ReturnToMainMenuButton	mm;
	int						id;

	public OptionsMenu(GameContainer gc, TheMap map, int idValue)
	{
		c = gc;
		theMap = map;
		id = idValue;
	}

	
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		Resources.addTiledMap(theMap.getMap());
		difficulty = new DifficultyButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), "Difficulty: Easy", Reference.SCREEN_CENTER, 220, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
		sounds = new SoundsButton(container, game, theMap, Resources.getImageInstance("BUTTON_IMAGE"), "Sounds", Reference.SCREEN_CENTER, 60, Resources.getSoundInstance("BUTTON_SOUND"));
		mm = new ReturnToMainMenuButton(container, game, theMap, Resources.getImageInstance("BUTTON_IMAGE"), "Return To Main Menu", Reference.SCREEN_CENTER, 140, Resources.getSoundInstance("BUTTON_SOUND"));
	}

	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		theMap.getMap().render(0, 0);
		g.drawImage(sounds.getImage(), sounds.getX(), sounds.getY());
		g.drawImage(difficulty.getImage(), difficulty.getX(), difficulty.getY());
		g.drawImage(mm.getImage(), mm.getX(), mm.getY());
		g.drawString(difficulty.getText(), difficulty.getTextXPosition(), difficulty.getTextYPosition());
		g.drawString(sounds.getText(), sounds.getTextXPosition(), sounds.getTextYPosition());
		g.drawString(mm.getText(), mm.getTextXPosition(), mm.getTextYPosition());
	}

	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{
		sounds.update();
		mm.update();
		difficulty.update();
	}

	
	public int getID()
	{
		return id;
	}

}
