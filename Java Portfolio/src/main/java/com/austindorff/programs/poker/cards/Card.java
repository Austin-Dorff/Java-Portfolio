package com.austindorff.programs.poker.cards;


public class Card
{
	public static String[] types = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	public static String[] suits = {"Spades", "Diamonds", "Clubs",  "Hearts"};
	
	public String cardType = "";
	public String cardSuit = "";
	
	public Card(int type, int suit)
	{
		setType(type);
		setSuit(suit);
	}

	public String getType()
	{
		return cardType;
	}
	
	public String getSuit()
	{
		return cardSuit;
	}
	
	public static String[] getSuits()
	{
		return suits;
	}
	
	public static String[] getTypes()
	{
		return types;
	}
	
	private void setSuit(int suit)
	{
		cardSuit = suits[suit];
	}
	
	private void setType(int type)
	{
		cardType = types[type];
	}
	
	public static String printCard(Card c)
	{
		return c.getType() + " of " + c.getSuit();
	}
	
	public static boolean areCardTypesTheSame(Card card1, Card card2)
	{
		String cardOneType = card1.getType();
		String cardTwoType = card2.getType();
		
		if (cardOneType.equals(cardTwoType))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean areCardSuitsTheSame(Card card1, Card card2)
	{
		String cardOneSuit = card1.getSuit();
		String cardTwoSuit = card2.getSuit();
		if (cardOneSuit.equals(cardTwoSuit))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
