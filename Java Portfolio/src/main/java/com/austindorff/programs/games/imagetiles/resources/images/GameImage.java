package com.austindorff.programs.games.imagetiles.resources.images;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GameImage extends Image 
{
	private int posX = 0;
	private int posY = 0;
	String name = "";
	
	public GameImage(String filePath, String fileName) throws SlickException
	{
		super(filePath);
		setName(fileName);
	}
	
	public GameImage()
	{
		
	}
	
	public GameImage(String name)
	{
		setName(name);
	}
	
	public GameImage(Image image)
	{
		super(image);
	}
	
	public GameImage(GameImage image, String name, int x, int y) throws SlickException
	{
		super(image);
		setName(name);
		setPosX(x);
		setPosY(y);
	}
	
	public int getPosX()
	{
		return posX;
	}

	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}
	
	public GameImage getSubImage(int x, int y, int width, int height)
	{
		float newTextureOffsetX = ((x / (float) this.width) * textureWidth) + textureOffsetX;
		float newTextureOffsetY = ((y / (float) this.height) * textureHeight) + textureOffsetY;
		float newTextureWidth = ((width / (float) this.width) * textureWidth);
		float newTextureHeight = ((height / (float) this.height) * textureHeight);
		
		GameImage sub = new GameImage();
		sub.inited = true;
		sub.texture = this.texture;
		sub.textureOffsetX = newTextureOffsetX;
		sub.textureOffsetY = newTextureOffsetY;
		sub.textureWidth = newTextureWidth;
		sub.textureHeight = newTextureHeight;
		
		sub.width = width;
		sub.height = height;
		sub.ref = ref;
		sub.centerX = width / 2;
		sub.centerY = height / 2;
		
		return sub;
	}
}
