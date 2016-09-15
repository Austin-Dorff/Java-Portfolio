package com.austindorff.programs.games.imagetiles.states;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.buttons.nextpuzzlemenu.ImageButton;
import com.austindorff.programs.games.imagetiles.buttons.scrollButtons.ScrollButtonDown;
import com.austindorff.programs.games.imagetiles.buttons.scrollButtons.ScrollButtonUp;
import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.images.GameImage;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class ChooseImageState extends BasicGameState {
	private int						id;
	private int						start			= 0;
	private int						end;
	private ScrollButtonDown		sbd;
	private ScrollButtonUp			sbu;
	private TheMap					theMap;
	private GameContainer			gc;
	private ArrayList<ImageButton>	imageButtons	= new ArrayList<ImageButton>();
													
	public ChooseImageState(GameContainer gameContainer, TheMap theMap, int stateID) {
		id = stateID;
		gc = gameContainer;
		this.theMap = theMap;
	}
	
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.ARROW_BUTTON_DOWN_FILE_NAME, Reference.ARROW_BUTTON_DOWN_IMAGE_NAME));
		sbd = new ScrollButtonDown(container, game, theMap, Resources.getImageInstance(Reference.ARROW_BUTTON_DOWN_IMAGE_NAME), "", Reference.SCREEN_RIGHT, 558, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME), this);
		Resources.addImage(new GameImage(Reference.GAME_IMAGES_RESOURCE_LOCATION + Reference.ARROW_BUTTON_UP_FILE_NAME, Reference.ARROW_BUTTON_UP_IMAGE_NAME));
		sbu = new ScrollButtonUp(container, game, theMap, Resources.getImageInstance(Reference.ARROW_BUTTON_UP_IMAGE_NAME), "", Reference.SCREEN_RIGHT, 10, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME), this);
		for (int i = 0; i < Resources.getPuzzleArray1().size(); i++) {
			ImageButton temp = new ImageButton(container, game, theMap, Resources.getPuzzleArray1().get(i), "", Reference.SCREEN_CENTER, 32, Resources.getSoundInstance(Reference.BUTTON_SOUND_NAME), i);
			if (((i % 3) != 0) && ((i % 4) != 0)) {
				if (((i % 2) == 0)) {
					temp.setLocation(64, 64);
				} else {
					temp.setLocation(352, 64);
				}
			} else {
				if ((i % 2) == 0) {
					temp.setLocation(64, 352);
				} else {
					temp.setLocation(352, 352);
				}
			}
			imageButtons.add(temp);
		}
		if (imageButtons.size() <= 4) {
			end = imageButtons.size() - 1;
		} else {
			end = 3;
		}
		
	}
	
	public void scrollUp() {
		if (start != 0) {
			start -= 4;
			if (imageButtons.size() - 1 < (end - 4)) {
				end = (imageButtons.size() - 1);
			} else {
				end -= 4;
			}
		}
	}
	
	public void scrollDown() {
		if (end < (imageButtons.size() - 1)) {
			start += 4;
			if (imageButtons.size() - 1 < (end + 4)) {
				end = (imageButtons.size() - 1);
			} else {
				end += 4;
			}
		}
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		theMap.getMap().render(0, 0);
		for (int i = start; i <= end; i++) {
			imageButtons.get(i).getImage().draw(imageButtons.get(i).getX(), imageButtons.get(i).getY(), .5f);
		}
		g.drawImage(Resources.getImageInstance(Reference.ARROW_BUTTON_DOWN_IMAGE_NAME), sbd.getX(), sbd.getY());
		g.drawImage(Resources.getImageInstance(Reference.ARROW_BUTTON_UP_IMAGE_NAME), sbu.getX(), sbu.getY());
	}
	
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		if (game.getCurrentStateID() == id) {
			for (int i = start; i <= end; i++) {
				imageButtons.get(i).update();
			}
		}
		sbd.update();
		sbu.update();
	}
	
	@Override
	public int getID() {
		return id;
	}
	
}
