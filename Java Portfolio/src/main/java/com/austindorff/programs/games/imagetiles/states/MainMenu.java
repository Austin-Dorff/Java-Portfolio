package com.austindorff.programs.games.imagetiles.states;

import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.mainmenu.OptionsButton;
import com.austindorff.programs.games.imagetiles.buttons.mainmenu.PlayGameButton;
import com.austindorff.programs.games.imagetiles.buttons.mainmenu.QuitGameButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.images.GameImage;
import com.austindorff.programs.games.imagetiles.resources.images.PuzzleImage;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameMusic;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class MainMenu extends BasicGameState
{
	TheMap			theMap;
	StateBasedGame	sbg;
	GameContainer	c;

	OptionsButton	options;
	PlayGameButton	playGame;
	QuitGameButton	quit;

	int				id;

	public MainMenu(GameContainer gc, TheMap map, int idValue) throws IOException, SlickException
	{
		c = gc;
		theMap = map;
		id = idValue;
		loadImages();
	}
	
	private void loadImages() throws IOException, SlickException {
		for (String name : Reference.PUZZLE_IMAGE_NAMES) {
			Resources.addPuzzleImage1(new PuzzleImage(Reference.PUZZLE_IMAGES_RESOURCE_LOCATION + name + ".png", name, c));
		}
	}

	
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		sbg = game;
		Resources.addSound(new GameSound(Reference.BUTTON_SOUND_FILE_NAME, Reference.BUTTON_SOUND_NAME));
		Resources.addMusic(new GameMusic(Reference.GAME_MUSIC_FILE_NAME, Reference.GAME_MUSIC_NAME));
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.BUTTON_IMAGE_FILE_NAME, Reference.BUTTON_IMAGE_NAME));
		Resources.addTiledMap(theMap.getMap());
		playGame = new PlayGameButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), Reference.PLAY_GAME_BUTTON_TEXT, Reference.SCREEN_CENTER, 80, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
		options = new OptionsButton(container, game, theMap, Resources.getImageInstance("BUTTON_IMAGE"), Reference.OPTIONS_BUTTON_TEXT, Reference.SCREEN_CENTER, 210, Resources.getSoundInstance("BUTTON_SOUND"));
		quit = new QuitGameButton(container, game, theMap, Resources.getImageInstance("BUTTON_IMAGE"), Reference.QUIT_GAME_BUTTON_TEXT, Reference.SCREEN_CENTER, 350, Resources.getSoundInstance("BUTTON_SOUND"));
	}

	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		theMap.getMap().render(0, 0);
		g.drawImage(playGame.getImage(), playGame.getX(), playGame.getY());
		g.drawImage(options.getImage(), options.getX(), options.getY());
		g.drawImage(quit.getImage(), quit.getX(), quit.getY());
		g.drawString(playGame.getText(), playGame.getTextXPosition(), playGame.getTextYPosition());
		g.drawString(options.getText(), options.getTextXPosition(), options.getTextYPosition());
		g.drawString(quit.getText(), quit.getTextXPosition(), quit.getTextYPosition());

	}

	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{
		playGame.update();
		options.update();
		quit.update();
	}

	
	public int getID()
	{
		return id;
	}

}
