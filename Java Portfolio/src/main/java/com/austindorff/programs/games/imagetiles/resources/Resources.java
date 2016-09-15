package com.austindorff.programs.games.imagetiles.resources;

import java.util.ArrayList;

import com.austindorff.programs.games.imagetiles.resources.images.GameImage;
import com.austindorff.programs.games.imagetiles.resources.images.PuzzleImage;
import com.austindorff.programs.games.imagetiles.resources.maps.GameTiledMap;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameMusic;
import com.austindorff.programs.games.imagetiles.resources.sounds.GameSound;

public class Resources
{
	static ArrayList<GameMusic> music = new ArrayList<GameMusic>();
	static ArrayList<GameSound> sounds = new ArrayList<GameSound>();
	static ArrayList<GameImage> images = new ArrayList<GameImage>();
	static ArrayList<PuzzleImage> puzzleImages = new ArrayList<PuzzleImage>();
	static ArrayList<PuzzleImage> puzzleImages1 = new ArrayList<PuzzleImage>();
	static ArrayList<PuzzleImage> puzzleImages2 = new ArrayList<PuzzleImage>();
	static ArrayList<GameTiledMap> tiledMaps = new ArrayList<GameTiledMap>();
	
	public static void addMusic(GameMusic newMusic)
	{
		music.add(newMusic);
	}
	
	public static void addSound(GameSound newSound)
	{
		sounds.add(newSound);
	}
	
	public static void addImage(GameImage newImage)
	{
		images.add(newImage);
	}
	
	public static void addPuzzleImage(PuzzleImage newImage)
	{
		puzzleImages.add(newImage);
	}
	
	public static void addPuzzleImage1(PuzzleImage newImage)
	{
		puzzleImages1.add(newImage);
	}
	
	public static void addPuzzleImage2(PuzzleImage newImage)
	{
		puzzleImages2.add(newImage);
	}
	
	public static void addTiledMap(GameTiledMap newTiledMap)
	{
		tiledMaps.add(newTiledMap);
	}
	
	public static GameMusic getMusicInstance(String name)
	{
		for (int i = 0; i < music.size(); i++)
		{
			if (music.get(i).getMusicName().equals(name))
			{
				return music.get(i);
			}
		}
		return null;
	}
	
	public static GameSound getSoundInstance(String name)
	{
		for (int i = 0; i < sounds.size(); i++)
		{
			if (sounds.get(i).getSoundName().equals(name))
			{
				return sounds.get(i);
			}
		}
		return null;
	}

	public static GameImage getImageInstance(String name)
	{
		for (int i = 0; i < images.size(); i++)
		{
			if (images.get(i).getName().equals(name))
			{
				return images.get(i);
			}
		}
		return null;
	}
	
	public static PuzzleImage getPuzzleImageInstance(String name)
	{
		for (int i = 0; i < puzzleImages.size(); i++)
		{
			if (puzzleImages.get(i).getName().equals(name))
			{
				return puzzleImages.get(i);
			}
		}
		return null;
	}
	
	public static PuzzleImage getPuzzleImageInstance1(String name)
	{
		for (int i = 0; i < puzzleImages1.size(); i++)
		{
			if (puzzleImages1.get(i).getName().equals(name))
			{
				return puzzleImages1.get(i);
			}
		}
		return null;
	}
	
	public static PuzzleImage getPuzzleImage2Instance(String name)
	{
		for (int i = 0; i < puzzleImages2.size(); i++)
		{
			if (puzzleImages2.get(i).getName().equals(name))
			{
				return puzzleImages2.get(i);
			}
		}
		return null;
	}
	
	
	public static GameTiledMap getTiledMapInstance(String name)
	{
		for (int i = 0; i < tiledMaps.size(); i++)
		{
			if (tiledMaps.get(i).getTiledMapName().equals(name))
			{
				return tiledMaps.get(i);
			}
		}
		return null;
	}
	
	public static ArrayList<PuzzleImage> getPuzzleArray()
	{
		return puzzleImages;
	}
	
	public static ArrayList<PuzzleImage> getPuzzleArray1()
	{
		return puzzleImages1;
	}
	
	public static ArrayList<PuzzleImage> getPuzzleArray2()
	{
		return puzzleImages2;
	}
	
	public static void setPuzzleArray(ArrayList<PuzzleImage> array)
	{
		puzzleImages = array;
	}
	
	public static void setPuzzleArray1(ArrayList<PuzzleImage> array)
	{
		puzzleImages1 = array;
	}
	
	public static void setPuzzleArray2(ArrayList<PuzzleImage> array)
	{
		puzzleImages2 = array;
	}

}
