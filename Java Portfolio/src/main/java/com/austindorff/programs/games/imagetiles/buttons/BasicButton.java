package com.austindorff.programs.games.imagetiles.buttons;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.state.StateBasedGame;

import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.runner.Reference;
import com.austindorff.utilities.strings.StringMetrics;
import com.sun.corba.se.spi.orbutil.fsm.Input;

public class BasicButton
{
	GameContainer	c;
	StateBasedGame	sbg;
	Input			in;
	Image			image;
	int				posX	= 0;
	int				posY	= 0;
	String			text	= "";
	StringMetrics	sMet;

	public BasicButton(GUIContext container, StateBasedGame sbGame, TheMap theMap, Image buttonImage, String textStr, String screenLocation, int yPos)
	{
		if (screenLocation.equals(Reference.SCREEN_CENTER))
		{
			posX = getButtonXPosForCenterScreen(theMap);
		}
		else if (screenLocation.equals(Reference.SCREEN_RIGHT))
		{
			posX = getButtonXPosForRightScreen(theMap);
		}
		else
		{
			posX = getButtonXPosForLeftScreen(theMap);
		}
		posY = yPos;
		text = textStr;
		image = buttonImage;
		c = (GameContainer) container;
		sbg = sbGame;
		sMet = new StringMetrics(c.getGraphics());
	}
	
	public BasicButton()
	{
		
	}
	
	public GameContainer getGC()
	{
		return c;
	}

	public StateBasedGame getSBG()
	{
		return sbg;
	}

	public void setLocation(int x, int y)
	{
		posX = x;
		posY = y;
	}
	
	public void setText(String setText)
	{
		text = setText;
	}

	public int getX()
	{
		return posX;
	}

	public int getY()
	{
		return posY;
	}

	public int getWidth()
	{
		return image.getWidth();
	}

	public int getHeight()
	{
		return image.getHeight();
	}

	public Image getImage()
	{
		return image;
	}

	public String getText()
	{
		return text;
	}

	public void update() throws SlickException
	{
		if (isMouseHovering())
		{
			if (c.getInput().isMousePressed(0))
			{
				doAction();
			}
		}

	}

	public int getTextXPosition()
	{
		return getX() + ((getWidth() - sMet.getWidth(getText())) / 2);
	}

	public int getTextYPosition()
	{
		return ((getY() + (getHeight() / 2)) - (sMet.getHeight(getText()) / 2));
	}

	public void doAction() throws SlickException
	{
	}
	
	public int getButtonXPosForCenterScreen(TheMap theMap)
	{
		return (((theMap.getMap().getWidth() * theMap.getMap().getTileWidth()) / 2) - (Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME).getWidth() / 2));
	}
	
	public int getButtonXPosForLeftScreen(TheMap theMap)
	{
		return (((theMap.getMap().getWidth() * theMap.getMap().getTileWidth()) / 4) - (Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME).getWidth())) + 35;
	}
	
	public int getButtonXPosForRightScreen(TheMap theMap)
	{
		return (((theMap.getMap().getWidth() / 2) * theMap.getMap().getTileWidth()) + ((theMap.getMap().getWidth() / 4) * theMap.getMap().getTileWidth())) + (Resources.getImageInstance(Reference.BUTTON_IMAGE_NAME).getWidth() / 6) - 10;
	}

	public boolean isMouseHovering()
	{
		if ((c.getInput().getMouseX() >= getX()) && (c.getInput().getMouseX() <= (getX() + getWidth())) && (c.getInput().getMouseY() >= getY()) && (c.getInput().getMouseY() <= (getY() + getHeight())))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
