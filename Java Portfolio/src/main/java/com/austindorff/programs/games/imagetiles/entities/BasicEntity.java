package com.austindorff.programs.games.imagetiles.entities;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import com.austindorff.programs.games.imagetiles.map.TheMap;
import com.austindorff.programs.games.imagetiles.resources.Resources;
import com.austindorff.programs.games.imagetiles.resources.images.GameImage;

public class BasicEntity
{
	int			posX				= 0;
	int			posY				= 0;
	int			posX2				= 0;
	int			posY2				= 0;
	int			tilePosX			= 0;
	int			tilePosY			= 0;
	
	int			entityImageWidth	= 0;
	int			entityImageHeight	= 0;
	
	GameImage		entityImage;
	
	double		health				= 0;
	double		maxHealth			= 0;
	double		moveSpeed			= 0;
	double		direction			= 0;
	double		lastMovedDirection	= 0;
	double		newDirection		= 0;

	TheMap		theMap;
	
	String		type				= "";
	String		name				= "";
	
	boolean[][]	blocked;
	
	Circle		hitbox;
	
	public BasicEntity(int posX, int posY, String name, String type, String spriteLocation, TheMap theMapThingy, double health, double maxHealth, double moveSpeed) throws SlickException
	{
		hitbox = new Circle(getPosX(), getPosY(), 16);
		entityImage = new GameImage(spriteLocation, "PLAYER_IMAGE");
		Resources.addImage(entityImage);
		theMap = theMapThingy;
		blocked = theMap.getBlockedMatrix();
		setEntityImageHeight(entityImage.getHeight());
		setEntityImageWidth(entityImage.getWidth());
		setPosX(posX);
		setPosY(posY);
		setName(name);
		setType(type);
		setHealth(health);
		setMaxHealth(maxHealth);
		setMoveSpeed(moveSpeed);
	}
	
	public int getPosX()
	{
		return posX;
	}
	
	public int getPosY()
	{
		return posY;
	}
	
	public int getPosX2()
	{
		return getPosX() + getEntityImageWidth();
	}
	
	public int getPosY2()
	{
		return getPosY() + getEntityImageHeight();
	}
	
	public double getDirection()
	{
		return direction;
	}
	
	public double getLastDirectionMoved()
	{
		return lastMovedDirection;
	}
	
	public double getNewDirection()
	{
		return newDirection;
	}
	
	public int getEntityImageWidth()
	{
		return entityImageWidth;
	}
	
	public int getEntityImageHeight()
	{
		return entityImageHeight;
	}
	
	public GameImage getEntityImage()
	{
		return entityImage;
	}
	
	public double getHealth()
	{
		return health;
	}
	
	public double getMaxHealth()
	{
		return maxHealth;
	}
	
	public double getMoveSpeed()
	{
		return moveSpeed;
	}
	
	public TheMap getTheMap()
	{
		return theMap;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Circle getHitbox()
	{
		return hitbox;
	}
	
	public void setPosX(int posX)
	{
		this.posX = posX;
		hitbox.setCenterX(getPosX() + this.getEntityImageWidth() / 2);
		hitbox.setCenterY(getPosY() + this.getEntityImageHeight() / 2);
	}
	
	public void setPosY(int posY)
	{
		this.posY = posY;
		hitbox.setCenterX(getPosX() + this.getEntityImageWidth() / 2);
		hitbox.setCenterY(getPosY() + this.getEntityImageHeight() / 2);
	}
	
	public void setDirection(double value)
	{
		direction = value;
	}
	
	public void setLastDirectionMoved(double value)
	{
		lastMovedDirection = value;
	}
	
	public void setNewDirection(double value)
	{
		newDirection = value;
	}
	
	public void setEntityImageWidth(int entityImageWidth)
	{
		this.entityImageWidth = entityImageWidth;
	}
	
	public void setEntityImageHeight(int entityImageHeight)
	{
		this.entityImageHeight = entityImageHeight;
	}
	
	public void setEntityImage(GameImage entityImage)
	{
		this.entityImage = entityImage;
	}
	
	public void setHealth(double health)
	{
		this.health = health;
	}
	
	public void setMaxHealth(double maxHealth)
	{
		this.maxHealth = maxHealth;
	}
	
	public void setMoveSpeed(double moveSpeed)
	{
		this.moveSpeed = moveSpeed;
	}
	
	public void setTheMap(TheMap theMap)
	{
		this.theMap = theMap;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void decreaseHealthBy(double amount)
	{
		if (getHealth() - amount <= 0)
		{
			setHealth(0);
		}
		else
		{
			setHealth(getHealth() - amount);
		}
	}
	
	public void increaseHealthBy(double amount)
	{
		if (getHealth() + amount >= getMaxHealth())
		{
			setHealth(getMaxHealth());
		}
		else
		{
			setHealth(getHealth() + amount);
		}
	}
	
	public void move(double direction, double speed)
	{
		if (direction == 0 && !blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()] && !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosY((int) (getPosY() - ((1 * speed))));
			
		}
		else if (direction == 0)
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed / i))) / theMap.getMap().getTileHeight()] && !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosY((int) (getPosY() - ((1 * speed / i))));
					
				}
			}
		}
		if (direction == 90 && !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - 1) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() + 1) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() + ((1 * speed))));
		}
		else if (direction == 90)
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX2() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + 1) / theMap.getMap().getTileHeight()] && !blocked[(int) (getPosX2() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() - 1) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() + ((1 * speed / i))));
				}
			}
		}
		if (direction == 180 && !blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()] && !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosY((int) (getPosY() + ((1 * speed))));
		}
		else if (direction == 180)
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()] && !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosY((int) (getPosY() + ((1 * speed / i))));
				}
			}
		}
		if (direction == 270 && !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() + 1) / theMap.getMap().getTileHeight()] && !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - 1) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() - ((1 * speed))));
		}
		else if (direction == 270)
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() + 1) / theMap.getMap().getTileHeight()] && !blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - 1) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() - ((1 * speed / i))));
					System.out.println((int) getPosX() - ((1 * speed / i)));
				}
			}
		}
		if (direction > 270 && !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() - ((1 * speed))));
			setPosY((int) (getPosY() - ((1 * speed))));
		}
		else if (direction > 270)
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX2() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() - ((1 * speed / i))));
					setPosY((int) (getPosY() - ((1 * speed / i))));
				}
			}
		}
		if ((direction > 180) && (direction < 270) && !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() - (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() - ((1 * speed))));
			setPosY((int) (getPosY() + ((1 * speed))));
		}
		else if ((direction > 180) && (direction < 270))
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX2() - (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() - ((1 * speed / i))));
					setPosY((int) (getPosY() + ((1 * speed / i))));
				}
			}
		}
		if ((direction > 90) && (direction < 180) && !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() + ((1 * speed))));
			setPosY((int) (getPosY() + ((1 * speed))));
		}
		else if ((direction > 90) && (direction < 180))
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX2() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() + ((1 * speed / i))));
					setPosY((int) (getPosY() + ((1 * speed / i))));
				}
			}
		}
		if ((direction > 0) && (direction < 90) && !blocked[(int) (getPosX() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * speed)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * speed))) / theMap.getMap().getTileHeight()])
		{
			setPosX((int) (getPosX() + ((1 * speed))));
			setPosY((int) (getPosY() - ((1 * speed))));
		}
		else if ((direction > 0) && (direction < 90))
		{
			for (int i = 1; i < 10; i++)
			{
				if (!blocked[(int) (getPosX() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * speed / i))) / theMap.getMap().getTileHeight()]
						&& !blocked[(int) (getPosX2() + (1 * speed / i)) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * speed / i))) / theMap.getMap().getTileHeight()])
				{
					setPosX((int) (getPosX() + ((1 * speed / i))));
					setPosY((int) (getPosY() - ((1 * speed / i))));
				}
			}
		}
	}
	
	public boolean canMove(double direction)
	{
		if (direction == 0 && !blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if ((direction > 0) && (direction < 90) && !blocked[(int) (getPosX() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if (direction == 90 && !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() - 1) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() + 1) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if ((direction > 90) && (direction < 180) && !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() + (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if (direction == 180 && !blocked[(getPosX() + 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(getPosX2() - 1) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if ((direction > 180) && (direction < 270) && !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() + ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if (direction == 270 && !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() + 1) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() - 1) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else if (direction > 270 && !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX2() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()]
				&& !blocked[(int) (getPosX() - (1 * getMoveSpeed())) / theMap.getMap().getTileWidth()][(int) (getPosY2() - ((1 * getMoveSpeed()))) / theMap.getMap().getTileHeight()])
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int getTilePosX()
	{
		if ((getPosX() / theMap.getMap().getTileWidth()) > theMap.getMap().getWidth() / 2)
		{
			return (getPosX() / theMap.getMap().getTileWidth());
		}
		else
		{
			return (getPosX() / theMap.getMap().getTileWidth());
		}
	}
	
	public int getTilePosY()
	{
		if ((getPosY() / theMap.getMap().getTileHeight()) > theMap.getMap().getWidth() / 2)
		{
			return (getPosY() / theMap.getMap().getTileHeight());
		}
		else
		{
			return (getPosY() / theMap.getMap().getTileHeight());
		}
	}
	
	public int getTilePosX2()
	{
		if ((getPosX2() / theMap.getMap().getTileWidth()) > theMap.getMap().getWidth() / 2)
		{
			return (getPosX2() / theMap.getMap().getTileWidth());
		}
		else
		{
			return (getPosX2() / theMap.getMap().getTileWidth());
		}
	}
	
	public int getTilePosY2()
	{
		if ((getPosY2() / theMap.getMap().getTileHeight()) > theMap.getMap().getWidth() / 2)
		{
			return (getPosY2() / theMap.getMap().getTileHeight());
		}
		else
		{
			return (getPosY2() / theMap.getMap().getTileHeight());
		}
	}
	
	public boolean isOppositeDirection(double lastMoved, double proposed)
	{
		if ((lastMoved == 180) && (proposed == 0))
		{
			return true;
		}
		else if ((lastMoved == 0) && (proposed == 180))
		{
			return true;
		}
		else if ((lastMoved == 90) && (proposed == 270))
		{
			return true;
		}
		else if ((lastMoved == 270) && (proposed == 90))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
