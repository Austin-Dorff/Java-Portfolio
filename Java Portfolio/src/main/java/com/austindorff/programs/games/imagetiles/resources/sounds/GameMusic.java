package com.austindorff.programs.games.imagetiles.resources.sounds;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.SoundsButton;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class GameMusic extends Music 
{
	String soundName = "";
	
	public GameMusic(String fileName, String name) throws SlickException
	{
		super(Reference.MUSIC_RESOURCE_LOCATION + fileName);
		setMusicName(name);
		Resources.addMusic(this);
	}
	
	public String getMusicName()
	{
		return soundName;
	}

	public void setMusicName(String soundName)
	{
		this.soundName = soundName;
	}
	
	@Override
	public void play()
	{
		if (SoundsButton.soundsEnabled())
		{
			super.play();
		}
	}

}
