package com.austindorff.programs.games.imagetiles.states;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.ReturnToMainMenuButton;
import com.austindorff.programs.games.imagetiles.buttons.gamemenu.DecreaseButton;
import com.austindorff.programs.games.imagetiles.buttons.gamemenu.IncreaseButton;
import com.austindorff.programs.games.imagetiles.buttons.nextpuzzlemenu.NextPuzzleButton;
import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.DifficultyButton;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.images.GameImage;
import com.austindorff.programs.games.imagetiles.resources.images.PuzzleImage;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameMusic;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class GameState extends BasicGameState
{
	TheMap					theMap;
	StateBasedGame			sbg;
	GameContainer			c;
	static PuzzleImage		currentImage;
	int						id;
	ReturnToMainMenuButton	mm;
	IncreaseButton			ib;
	DecreaseButton			db;
	NextPuzzleButton		npb;
	private boolean			mapIsCompleted;
	public static int		focusBoxX;
	public static int		focusBoxY;
	static boolean			drawFocusBox	= false;
	public static int		numMovesLeft	= 0;
	private static int		imageIndex		= 0;
	
	public GameState(GameContainer gc, TheMap map, int idValue) throws IOException, SlickException
	{
		theMap = map;
		c = gc;
		id = idValue;
	}
	
	public static void setImageIndex(int index)
	{
		imageIndex = index;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException
	{
		sbg = game;
		mm = new ReturnToMainMenuButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), Reference.MAIN_MENU_BUTTON_TEXT, Reference.SCREEN_CENTER, 1, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
		npb = new NextPuzzleButton(container, game, theMap, Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), "Go To Next Puzzle", Reference.SCREEN_CENTER, 120, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME));
		Resources.addMusic(new GameMusic(Reference.GAME_MUSIC_FILE_NAME, Reference.GAME_MUSIC_NAME));
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.FOCUS_BOX_IMAGE_FILE_NAME, Reference.FOCUS_BOX_IMAGE_NAME));
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.FOCUS_BOX_96_IMAGE_FILE_NAME, Reference.FOCUS_BOX_96_IMAGE_NAME));
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.FOCUS_BOX_192_IMAGE_FILE_NAME, Reference.FOCUS_BOX_192_IMAGE_NAME));
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.FOCUS_BOX_288_IMAGE_FILE_NAME, Reference.FOCUS_BOX_288_IMAGE_NAME));
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException
	{
		if (mapIsCompleted)
		{
			theMap.getMap().render(0, 0);
			g.drawImage(Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), mm.getX(), mm.getY());
			g.drawString(mm.getText(), mm.getTextXPosition(), mm.getTextYPosition());
			g.drawImage(npb.getImage(), npb.getX(), npb.getY());
			g.drawString(npb.getText(), npb.getTextXPosition(), npb.getTextYPosition());
		}
		else
		{
			theMap.getMap().render(0, 0);
			g.drawImage(Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME), mm.getX(), mm.getY());
			g.drawString(mm.getText(), mm.getTextXPosition(), mm.getTextYPosition());
			for (int i = 0; i < Resources.getPuzzleArray().size(); i++)
			{
				g.drawImage(Resources.getPuzzleArray().get(i), Resources.getPuzzleArray().get(i).getPosX(), Resources.getPuzzleArray().get(i).getPosY());
			}
			if (drawFocusBox)
			{
				switch (DifficultyButton.getDifficulty())
				{
					case 0:
						g.drawImage(Resources.getImageInstance(Reference.FOCUS_BOX_288_IMAGE_NAME), focusBoxX, focusBoxY);
						break;
					case 1:
						g.drawImage(Resources.getImageInstance(Reference.FOCUS_BOX_192_IMAGE_NAME), focusBoxX, focusBoxY);
						break;
					case 2:
						g.drawImage(Resources.getImageInstance(Reference.FOCUS_BOX_96_IMAGE_NAME), focusBoxX, focusBoxY);
						break;
					case 3:
						g.drawImage(Resources.getImageInstance(Reference.FOCUS_BOX_IMAGE_NAME), focusBoxX, focusBoxY);
						break;
				}
			}
		}
		
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException
	{
		mm.update();
		if (mapIsCompleted)
		{
			npb.update();
		}
		int tracker = -1;
		for (int i = 0; i < Resources.getPuzzleArray().size(); i++)
		{
			Resources.getPuzzleArray().get(i).update();
		}
		for (int h = 0; h < Math.sqrt(Resources.getPuzzleArray().size()); h++)
		{
			Inner:
			for (int w = 0; w < Math.sqrt(Resources.getPuzzleArray().size()); w++)
			{
				Inner2:
				for (int i = 0; i < Resources.getPuzzleArray().size(); i++)
				{
					if (Resources.getPuzzleArray().get(i).getPosX() == (64 + (w * (DifficultyButton.getDifficulty() == 0 ? 288 : (DifficultyButton.getDifficulty() == 1 ? 192 : (DifficultyButton.getDifficulty() == 2 ? 96 : 64))))) && (Resources.getPuzzleArray().get(i).getPosY() == (64 + (h * (DifficultyButton.getDifficulty() == 0 ? 288 : (DifficultyButton.getDifficulty() == 1 ? 192 : (DifficultyButton.getDifficulty() == 2 ? 96 : 64)))))))
					{
						if (Resources.getPuzzleArray().get(i).getId() == tracker + 1)
						{
							tracker++;
							continue Inner;
						}
					}
					else
					{
						continue Inner2;
					}
				}
			}
		}
		if (tracker == Resources.getPuzzleArray().size() - 1 && Resources.getPuzzleArray().size() != 0)
		{
			mapIsCompleted = true;
		}
		else
		{
			mapIsCompleted = false;
		}
	}
	
	public int getID()
	{
		return id;
	}
	
	public static void drawFocusBox(int x, int y, PuzzleImage currentImage)
	{
		if (GameState.currentImage != null)
		{
			swapImages(currentImage);
		}
		else
		{
			if (drawFocusBox && x == focusBoxX && y == focusBoxY)
			{
				drawFocusBox = false;
				GameState.currentImage = null;
				GameState.currentImage.isSelected = false;
			}
			else
			{
				GameState.currentImage = currentImage;
				drawFocusBox = true;
				focusBoxX = x;
				focusBoxY = y;
			}
		}
		
	}
	
	private static void swapImages(PuzzleImage currentImage2)
	{
		if (numMovesLeft >= 0)
		{
			int currentX = focusBoxX;
			int currentY = focusBoxY;
			int newX = currentImage2.getPosX();
			int newY = currentImage2.getPosY();
			GameState.currentImage.setPosX(newX);
			GameState.currentImage.setPosY(newY);
			currentImage2.setPosX(currentX);
			currentImage2.setPosY(currentY);
			GameState.currentImage = null;
			GameState.drawFocusBox = false;
		}
		else
		{
			// end game
		}
	}
	
}
