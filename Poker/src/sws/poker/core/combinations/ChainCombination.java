package sws.poker.core.combinations;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardOwner;

public class ChainCombination implements Combination {
	private List<Combination> combinations;
	private CardCombination name;
	
	public ChainCombination(List<Combination> combinations, CardCombination name) {
		this.name = name;
		this.combinations = combinations;
	}
	
	public UserCardCombination find(CardMatrix cardMatrix, List<Card> userCards, CardOwner user) {
		UserCardCombination cards = null;
		CardMatrix matrix = cardMatrix.clone();
		for(Combination combination : combinations) {
			cards = combination.find(matrix, userCards, user);
			if(cards == null) {
				break;
			}
			cards.setName(name);
			matrix.removeCards(cards.getCards());
		}
		return cards;
	}	
}
