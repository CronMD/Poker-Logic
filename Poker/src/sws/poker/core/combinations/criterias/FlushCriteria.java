package sws.poker.core.combinations.criterias;

import java.util.ArrayList;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;

public class FlushCriteria extends FetchCriteria  {
	private static int FLUSH_COUNT = 5; 
	
	@Override
	public List<Card> find(CardMatrix matrix, Card card) {
		List<Card> cards = matrix.getSameSuits(card);
		if(cards.size() < FLUSH_COUNT) {
			return null;
		}
		List<Card> flush = new ArrayList<Card>();
		flush.add(card);
		for(Card buf : cards) {
			if(buf != card) {
				flush.add(buf);
				if(flush.size() == FLUSH_COUNT && !fetch) {
					break;
				}
			}
		}
		return flush;
	}

}
