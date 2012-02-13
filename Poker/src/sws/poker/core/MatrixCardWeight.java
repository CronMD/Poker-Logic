package sws.poker.core;

import java.util.HashMap;

public class MatrixCardWeight {
	private final HashMap<CardValue, Integer> valueWeightMap = new HashMap<CardValue, Integer>() 
			{
				private static final long serialVersionUID = 1L;
			{
				put(CardValue.TWO, 0);
				put(CardValue.THREE, 1);
				put(CardValue.FOUR, 2);
				put(CardValue.FIVE, 3);
				put(CardValue.SIX, 4);
				put(CardValue.SEVEN, 5);
				put(CardValue.EIGHT, 6);
				put(CardValue.NINE, 7);
				put(CardValue.TEN, 8);
				put(CardValue.JACK, 9);
				put(CardValue.QUEEN, 10);
				put(CardValue.KING, 11);
				put(CardValue.ACE, 12);
			}}; 
			
	private final HashMap<CardSuit, Integer> suitWeightMap = new HashMap<CardSuit, Integer>() 
			{
				private static final long serialVersionUID = 1L;
			{
				put(CardSuit.CLUBS, 0);
				put(CardSuit.DIAMONDS, 1);
				put(CardSuit.SPADES, 2);
				put(CardSuit.HEARTS, 3);
			}}; 
	
	public int getValueWeight(CardValue value) {
		return valueWeightMap.get(value);
	}
		
	public int getValueWeight(Card card) {
		return getValueWeight(card.getValue());
	}
	
	public int getSuitWeight(CardSuit suit) {
		return suitWeightMap.get(suit);
	}
	
	public int getSuitWeight(Card card) {
		return getSuitWeight(card.getSuit());
	}
}
