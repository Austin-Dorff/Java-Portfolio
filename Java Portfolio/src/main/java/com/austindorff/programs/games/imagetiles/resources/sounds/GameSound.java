package com.austindorff.programs.games.imagetiles.resources.sounds;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import com.austindorff.programs.games.imagetiles.buttons.optionsmenu.SoundsButton;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.runner.Reference;

public class GameSound extends Sound
{
	String soundName = "";

	public GameSound(String fileName, String name) throws SlickException
	{
		super(Reference.SOUNDS_RESOURCE_LOCATION + fileName);
		setSoundName(name);
		Resources.addSound(this);
	}
	
	public String getSoundName()
	{
		return soundName;
	}

	public void setSoundName(String soundName)
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
