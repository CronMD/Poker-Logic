package sws.poker.core;

import java.util.ArrayList;
import java.util.List;

public class CardMatrix {
	private static int CARDS_COUNT = 13;
	private static int SUITS_COUNT = 4;
	
	private MatrixCardWeight cardWeight = new MatrixCardWeight();
	Card[][] matrix = new Card[CARDS_COUNT][SUITS_COUNT];
	int[] valuesCount = new int[CARDS_COUNT];
	int[] suitsCount = new int[SUITS_COUNT];
	
	public CardMatrix() {	
	}
	
	public CardMatrix(List<Card> cards) {	
		fill(cards);
	}
	
	public void fill(List<Card> cards) {
		for(Card card : cards) {
			putCard(card);
		}
	}
	
	public void putCard(Card card) {
		setCard(card, card, 1, 1);
	}
	
	public void putCards(List<Card> cards) {
		for(Card card : cards) {
			putCard(card);
		}
	}
	
	public void removeCard(Card card) {
		setCard(card, null, -1, -1);
	}
	
	public void removeCards(List<Card> cards) {
		for(Card card : cards) {
			removeCard(card);
		}
	}
	
	public int getValuesCount(int value) {
		if(value < 0 || value >= CARDS_COUNT) {
			return 0;
		}
		return valuesCount[value];
	}
	
	public int getSuitsCount(int suit) {
		if(suit < 0 || suit >= SUITS_COUNT) {
			return 0;
		}
		return suitsCount[suit];
	}
	
	public int getValuesCount(CardValue value) {
		return getValuesCount(cardWeight.getValueWeight(value));
	}
	
	public int getSuitsCount(CardSuit suit) {
		return getSuitsCount(cardWeight.getSuitWeight(suit));
	}
	
	public int getValuesCount(Card card) {
		return getValuesCount(cardWeight.getValueWeight(card));
	}
	
	public int getSuitsCount(Card card) {
		return getSuitsCount(cardWeight.getSuitWeight(card));
	}
	
	public List<Card> getSameSuits(Card card) {
		int suit = cardWeight.getSuitWeight(card);
		return getSameSuits(suit);
	}
	
	public List<Card> getSameValues(Card card) {
		int value = cardWeight.getValueWeight(card);
		return getSameValues(value);
	}
	
	public List<Card> getSameSuits(int suit) {
		List<Card> matched = new ArrayList<Card>();
		for(int value = 0; value< CARDS_COUNT; value++) {
			if(matrix[value][suit] != null) {
				matched.add(matrix[value][suit]);
			}
		}
		return matched;
	}
	
	public List<Card> getSameValues(int value) {
		List<Card> matched = new ArrayList<Card>();
		for(int suit = 0; suit < SUITS_COUNT; suit++) {
			if(matrix[value][suit] != null) {
				matched.add(matrix[value][suit]);
			}
		}
		return matched;
	}
	
	public int getCardValueWeight(Card card) {
		return cardWeight.getValueWeight(card);
	}
	
	public int getCardSuitWeight(Card card) {
		return cardWeight.getSuitWeight(card);
	}
	
	public List<Card> getAllCards() {
		List<Card> cards = new ArrayList<Card>();
		for(int value = 0; value < CARDS_COUNT; value++) {
			for(int suit = 0; suit < SUITS_COUNT; suit++) {
				if(matrix[value][suit] != null) {
					cards.add(matrix[value][suit]);
				}
			}
		}
		return cards;
	}
	
	public CardMatrix clone() {
		return new CardMatrix(getAllCards());
	}
	
	private void setCard(Card card, Card storedCard, int valuesInc, int suitsInc) {
		int value = cardWeight.getValueWeight(card);
		int suit = cardWeight.getSuitWeight(card);
		
		if(matrix[value][suit] == storedCard) {
			return;
		}
		
		valuesCount[value] += valuesInc;
		suitsCount[suit] += suitsInc;
		matrix[value][suit] = storedCard;
	}
}
