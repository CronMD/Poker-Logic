package sws.poker.core.combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardOwner;

public class CombinationFinder  implements Combination{
	private List<Combination> combinations = new ArrayList<Combination>();
	
	public CombinationFinder() {
		CombinationFactory factory = new CombinationFactory();
		combinations.add(factory.getCombination(CardCombination.FLUSH_ROYAL));
		combinations.add(factory.getCombination(CardCombination.STRAIGHT_FLUSH));
		combinations.add(factory.getCombination(CardCombination.FOUR));
		combinations.add(factory.getCombination(CardCombination.FULL_HOUSE));
		combinations.add(factory.getCombination(CardCombination.FLUSH));
		combinations.add(factory.getCombination(CardCombination.STRAIGHT));
		combinations.add(factory.getCombination(CardCombination.THREE));
		combinations.add(factory.getCombination(CardCombination.TWO_PAIRS));
		combinations.add(factory.getCombination(CardCombination.PAIR));
		combinations.add(factory.getCombination(CardCombination.BIGGER));
	}

	@Override
	public UserCardCombination find(CardMatrix matrix, List<Card> userCards,
			CardOwner user) {
		UserCardCombination cards = null;
		
		Collections.sort(userCards);
		Collections.reverse(userCards);
		
		for(Combination combination : combinations) {
			cards = combination.find(matrix, userCards, user);
			if(cards != null) {
				break;
			}
		}
		return cards;
	}
}
