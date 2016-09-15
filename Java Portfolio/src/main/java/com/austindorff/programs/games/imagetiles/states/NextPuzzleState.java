package com.austindorff.programs.games.imagetiles.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.ReturnToMainMenuButton;
import com.austindorff.programs.games.imagetiles.buttons.nextpuzzlemenu.NextPuzzleButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class NextPuzzleState extends BasicGameState
{

	int						id;
	TheMap					theMap;
	GameContainer			gc;
	NextPuzzleButton		npb;
	ReturnToMainMenuButton	mm;

	public NextPuzzleState(GameContainer container, TheMap theMap, int id)
	{
		this.id = id;
		gc = container;
		this.theMap = theMap;
	}

	
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		npb = new NextPuzzleButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), "Go To Next Puzzle", Reference.SCREEN_CENTER, 120, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
		mm = new ReturnToMainMenuButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), Reference.MAIN_MENU_BUTTON_TEXT, Reference.SCREEN_CENTER, 200, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
	}

	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{
		npb.update();
		mm.update();
	}

	
	public int getID()
	{
		return id;
	}

	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		Resources.getTiledMapInstance(Reference.MAIN_MENU_MAP_NAME).render(0, 0);
	}

}
