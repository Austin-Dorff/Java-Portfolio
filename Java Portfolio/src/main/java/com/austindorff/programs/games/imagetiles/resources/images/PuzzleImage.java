package com.austindorff.programs.games.imagetiles.resources.images;

import java.util.ArrayList;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.DifficultyButton;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.states.GameState;

public class PuzzleImage extends GameImage
{
	static GameContainer	gc;
	int						id;
	public boolean			isSelected;
	static int				puzzleNumber	= 0;
	static String			name			= "";
	
	public PuzzleImage(String filePath, String fileName, GameContainer container) throws SlickException
	{
		super(filePath, fileName);
		this.name = fileName;
		gc = container;
	}
	
	public PuzzleImage(PuzzleImage image)
	{
		super(image);
	}
	
	public PuzzleImage(PuzzleImage subImage, String name, int x, int y, GameContainer container, int id)
	{
		super(subImage);
		setName(name);
		setPosX(x);
		setPosY(y);
		gc = container;
		setId(id);
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public PuzzleImage()
	{
	}
	
	public static int getPuzzleNumber()
	{
		return puzzleNumber;
	}
	
	public static void setPuzzleNumber(int number)
	{
		puzzleNumber = number;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public static void generateSubImages(int parentImageIndex) throws SlickException
	{
		int counter = 0;
		puzzleNumber = parentImageIndex;
		Resources.setPuzzleArray(new ArrayList<PuzzleImage>());
		if (Resources.getPuzzleArray1().get(parentImageIndex) != null)
		{
			switch (DifficultyButton.getDifficulty())
			{
				case 0:
					for (int h = 0; h < 2; h++)
					{
						for (int w = 0; w < 2; w++)
						{
							Resources.addPuzzleImage(new PuzzleImage(Resources.getPuzzleArray1().get(parentImageIndex).getSubImage((288 * w), (288 * h), 288, 288), (name + "_" + (w * h)), w > 0 ? ((288 * w) + 64) : 64, h > 0 ? ((288 * h) + 64) : 64, gc, counter));
							counter++;
						}
					}
					break;
				case 1:
					for (int h = 0; h < 3; h++)
					{
						for (int w = 0; w < 3; w++)
						{
							Resources.addPuzzleImage(new PuzzleImage(Resources.getPuzzleArray1().get(parentImageIndex).getSubImage((192 * w), (192 * h), 192, 192), (name + "_" + (w * h)), w > 0 ? ((192 * w) + 64) : 64, h > 0 ? ((192 * h) + 64) : 64, gc, counter));
							counter++;
						}
					}
					break;
				case 2:
					for (int h = 0; h < 6; h++)
					{
						for (int w = 0; w < 6; w++)
						{
							Resources.addPuzzleImage(new PuzzleImage(Resources.getPuzzleArray1().get(parentImageIndex).getSubImage((96 * w), (96 * h), 96, 96), (name + "_" + (w * h)), w > 0 ? ((96 * w) + 64) : 64, h > 0 ? ((96 * h) + 64) : 64, gc, counter));
							counter++;
						}
					}
					break;
				case 3:
					for (int h = 0; h < 9; h++)
					{
						for (int w = 0; w < 9; w++)
						{
							Resources.addPuzzleImage(new PuzzleImage(Resources.getPuzzleArray1().get(parentImageIndex).getSubImage((64 * w), (64 * h), 64, 64), (name + "_" + (w * h)), (64 * (w + 1)), (64 * (h + 1)), gc, counter));
							counter++;
						}
					}
					break;
			
			}
			randomizePuzzleImageArray();
		}
	}
	
	public PuzzleImage getSubImage(int x, int y, int width, int height)
	{
		super.init();
		float newTextureOffsetX = ((x / (float) this.width) * textureWidth) + textureOffsetX;
		float newTextureOffsetY = ((y / (float) this.height) * textureHeight) + textureOffsetY;
		float newTextureWidth = ((width / (float) this.width) * textureWidth);
		float newTextureHeight = ((height / (float) this.height) * textureHeight);
		
		PuzzleImage sub = new PuzzleImage();
		sub.inited = true;
		sub.texture = this.texture;
		sub.textureOffsetX = newTextureOffsetX;
		sub.textureOffsetY = newTextureOffsetY;
		sub.textureWidth = newTextureWidth;
		sub.textureHeight = newTextureHeight;
		
		sub.width = width;
		sub.height = height;
		sub.centerX = width / 2;
		sub.centerY = height / 2;
		
		return sub;
	}
	
	public static void randomizePuzzleImageArray()
	{
		PuzzleImage temp;
		PuzzleImage temp2;
		Random rand = new Random();
		int placeHolder = 0;
		int tempPos = 0;
		int tempPos2 = 0;
		for (int i = 0; i < Resources.getPuzzleArray().size(); i++)
		{
			placeHolder = rand.nextInt(Resources.getPuzzleArray().size() - 1) + 1;
			temp = Resources.getPuzzleArray().get(i);
			temp2 = Resources.getPuzzleArray().get(placeHolder);
			tempPos = temp.getPosX();
			tempPos2 = temp2.getPosX();
			temp.setPosX(tempPos2);
			temp2.setPosX(tempPos);
			tempPos = temp.getPosY();
			tempPos2 = temp2.getPosY();
			temp.setPosY(tempPos2);
			temp2.setPosY(tempPos);
			Resources.getPuzzleArray().set(placeHolder, temp);
			Resources.getPuzzleArray().set(i, temp2);
		}
	}
	
	public boolean isMouseHovering()
	{
		if ((gc.getInput().getMouseX() >= getPosX()) && (gc.getInput().getMouseX() <= (getPosX() + getWidth())) && (gc.getInput().getMouseY() >= getPosY()) && (gc.getInput().getMouseY() <= (getPosY() + getHeight())))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void update()
	{
		if (isMouseHovering())
		{
			if (gc.getInput().isMousePressed(0))
			{
				isSelected = true;
				doAction();
			}
		}
		if (isSelected && (GameState.focusBoxX == getPosX()) && (GameState.focusBoxY == getPosY()))
		{
			if (gc.getInput().isKeyPressed(Keyboard.KEY_W))
			{
				if (canMove(0))
				{
					setPosY(getPosY() - 64);
					GameState.focusBoxY = getPosY();
				}
			}
			else if (gc.getInput().isKeyPressed(Keyboard.KEY_S))
			{
				if (canMove(180))
				{
					setPosY(getPosY() + 64);
					GameState.focusBoxY = getPosY();
				}
			}
			else if (gc.getInput().isKeyPressed(Keyboard.KEY_A))
			{
				if (canMove(270))
				{
					setPosX(getPosX() - 64);
					GameState.focusBoxX = getPosX();
				}
			}
			else if (gc.getInput().isKeyPressed(Keyboard.KEY_D))
			{
				if (canMove(90))
				{
					setPosX(getPosX() + 64);
					GameState.focusBoxX = getPosX();
				}
			}
		}
		else
		{
			isSelected = false;
		}
		
	}
	
	private boolean canMove(int i)
	{
		switch (i)
		{
			case 0:
				if (!isOccupiedByImage((getPosX() / 64), ((getPosY() / 64) - 1)) && ((getPosY() / 64) > 1))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 90:
				if (!isOccupiedByImage(((getPosX() / 64) + 1), (getPosY() / 64)) && ((getPosX() / 64) < 9))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 180:
				if (!isOccupiedByImage((getPosX() / 64), ((getPosY() / 64) + 1)) && ((getPosY() / 64) < 9))
				{
					return true;
				}
				else
				{
					return false;
				}
			case 270:
				if (!isOccupiedByImage(((getPosX() / 64) - 1), (getPosY() / 64)) && ((getPosX() / 64) > 1))
				{
					return true;
				}
				else
				{
					return false;
				}
		}
		return false;
	}
	
	private boolean isOccupiedByImage(int x, int y)
	{
		for (int i = 0; i < Resources.getPuzzleArray().size(); i++)
		{
			if ((Resources.getPuzzleArray().get(i).getPosX() / 64) == x)
			{
				if ((Resources.getPuzzleArray().get(i).getPosY() / 64) == y)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public void doAction()
	{
		GameState.drawFocusBox(getPosX(), getPosY(), this);
	}
	
}
