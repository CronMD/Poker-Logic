package sws.poker.core;

public class Card  implements Comparable<Card>{
	private CardSuit suit;
	private CardValue value;
	private CardOwner owner = null;
	
	public Card(CardSuit suit, CardValue value) {
		init(suit, value);
	}
	
	public Card(CardSuit suit, CardValue value, CardOwner owner) {
		this.owner = owner;
		init(suit, value);
	}
	
	private void init(CardSuit suit, CardValue value) {
		this.suit = suit;
		this.value = value;
	}
	
	public CardSuit getSuit() {
		return suit;
	}
	
	public CardValue getValue() {
		return value;
	}
	
	public CardOwner getOwner() {
		return owner;
	}

	@Override
	public int compareTo(Card other) {
		MatrixCardWeight weight = new MatrixCardWeight();
		int myWeight = weight.getValueWeight(this);
		int otherWeight = weight.getValueWeight(other);
		return myWeight - otherWeight;
	}
}
