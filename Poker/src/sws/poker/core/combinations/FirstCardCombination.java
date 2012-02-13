package sws.poker.core.combinations;

import java.util.ArrayList;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardOwner;

public class FirstCardCombination implements Combination {
	private CardCombination name;

	public FirstCardCombination(CardCombination name) {
		this.name = name;
	}
	
	@Override
	public UserCardCombination find(CardMatrix matrix, List<Card> userCards, CardOwner user) {
		List<Card> biggestCard = new ArrayList<Card>();
		biggestCard.add(userCards.get(0));
		return new UserCardCombination(user, biggestCard, name);
	}

}
