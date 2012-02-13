package sws.poker.core.combinations;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardOwner;
import sws.poker.core.combinations.criterias.Criteria;

public class FirstCombination implements Combination {
	private Criteria criteria;
	private CardCombination name;
	
	public FirstCombination(Criteria criteria, CardCombination name) {
		this.criteria = criteria;
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see sws.poker.core.combinations.Combination#find(sws.poker.core.CardMatrix, java.util.List, sws.poker.core.CardOwner)
	 */
	@Override
	public UserCardCombination find(CardMatrix matrix, List<Card> userCards, CardOwner user) {
		UserCardCombination combination = null;
		matrix.putCards(userCards);
		for(Card card : userCards) {
			List<Card> cards = criteria.find(matrix, card);
			matrix.removeCard(card);
			if(cards != null) {
				combination = new UserCardCombination(user, cards, name);
				break;
			}
		}
		matrix.removeCards(userCards);
		return combination;
	}
}
