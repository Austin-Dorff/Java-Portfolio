package com.austindorff.programs.games.imagetiles.runner;

import java.io.IOException;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.maps.GameTiledMap;
import com.austindorff.programs.games.imagetiles.states.ChooseImageState;
import com.austindorff.programs.games.imagetiles.states.GameState;
import com.austindorff.programs.games.imagetiles.states.MainMenu;
import com.austindorff.programs.games.imagetiles.states.NextPuzzleState;
import com.austindorff.programs.games.imagetiles.states.OptionsMenu;

public class TheGame extends StateBasedGame {
	static AppGameContainer	c;
	static GameTiledMap		map;
							
	public TheGame(String name) throws SlickException, IOException {
		super(name);		
	}
	
	public static void main(String[] args) throws SlickException, IOException {
		c = new AppGameContainer(new TheGame("EngineTest"));
		c.setVSync(false);
		c.setShowFPS(true);
		c.setDisplayMode(704, 704, false);
		c.start();
	}
	
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		try {
			addState(new MainMenu(container, new TheMap(Reference.MAIN_MENU_MAP_FILE_NAME, Reference.MAIN_MENU_MAP_NAME), Reference.MAIN_MENU_STATE_ID));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		addState(new ChooseImageState(container, new TheMap(Reference.CHOOSE_IMAGE_STATE_MAP_FILE_NAME, Reference.CHOOSE_IMAGE_STATE_MAP_NAME), Reference.CHOOSE_IMAGE_STATE_ID));
		addState(new OptionsMenu(container, new TheMap(Reference.OPTIONS_MENU_MAP_FILE_NAME, Reference.OPTIONS_MENU_MAP_NAME), Reference.OPTIONS_MENU_STATE_ID));
		try {
			addState(new GameState(container, new TheMap(Reference.GAME_STATE_MAP_FILE_NAME, Reference.GAME_STATE_MAP_NAME), Reference.GAME_STATE_ID));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addState(new NextPuzzleState(container, new TheMap(Reference.GAME_STATE_MAP_FILE_NAME, Reference.GAME_STATE_MAP_NAME), Reference.NEXT_PUZZLE_STATE_ID));
	}
	
}
