package sws.poker.core.combinations;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardOwner;

public class UserCardCombination implements Comparable<UserCardCombination> {
	private CardOwner user;
	private List<Card> cards;
	private CardCombination name;
	
	public UserCardCombination(CardOwner user, List<Card> cards, CardCombination name) {
		this.user = user;
		this.cards = cards;
		this.name = name;
	}
	
	public CardOwner getUser() {
		return user;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public CardCombination getName() {
		return name;
	}
	
	public void setName(CardCombination name) {
		this.name = name;
	}

	@Override
	public int compareTo(UserCardCombination other) {
		CombinationWeight weight = new CombinationWeight();
		int myWeight = weight.getWeight(name);
		int otherWeight = weight.getWeight(other.getName());
		return myWeight - otherWeight;
	}
}
