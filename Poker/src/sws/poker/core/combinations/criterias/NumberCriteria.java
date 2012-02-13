package sws.poker.core.combinations.criterias;

import java.util.ArrayList;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;

public class NumberCriteria extends FetchCriteria {

	protected int cardNumber;

	public NumberCriteria() {
		super();
	}
	
	public NumberCriteria(int cardNumber) {
		super();
		this.cardNumber = cardNumber;
	}

	/* (non-Javadoc)
	 * @see sws.poker.core.combinations.CardCombination#find(sws.poker.core.CardMatrix, sws.poker.core.Card)
	 */
	@Override
	public List<Card> find(CardMatrix matrix, Card card) {
		if(matrix.getValuesCount(card) < cardNumber) {
			return null;
		}
		List<Card> cards = matrix.getSameValues(card);
		List<Card> combination = new ArrayList<Card>();
		combination.add(card);
		for(Card buf : cards) {
			if(buf != card) {
				combination.add(buf);
				if(combination.size() == cardNumber && !fetch) {
					break;
				}
			}
		}
		
		return combination;
	}

}