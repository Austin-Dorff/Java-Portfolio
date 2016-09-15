package com.austindorff.programs.games.imagetiles.resources.maps;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import com.austindorff.programs.games.imagetiles.runner.Reference;

public class GameTiledMap extends TiledMap
{
	String	name	= "";

	public GameTiledMap(String fileName, String name) throws SlickException
	{
		super(Reference.MAPS_RESOURCE_LOCATION + fileName);
		setTiledMapName(name);
	}

	public String getTiledMapName()
	{
		return name;
	}

	public void setTiledMapName(String name)
	{
		this.name = name;
	}
}
