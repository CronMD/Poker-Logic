package sws.poker.core.combinations.criterias;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardValue;

public class RoyalCriteria  extends FetchCriteria {

	@Override
	public List<Card> find(CardMatrix matrix, Card card) {
		if(matrix.getValuesCount(CardValue.TEN) == 1 && matrix.getValuesCount(CardValue.ACE) == 1) {
			return matrix.getAllCards();
		}
		return null;
	}

}
