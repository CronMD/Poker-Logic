package sws.poker.core.combinations.criterias;

import java.util.ArrayList;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;

public class StraightCriteria extends FetchCriteria {
	private static int STRAIGHT_COUNT = 5;

	@Override
	public List<Card> find(CardMatrix matrix, Card card) {
		List<Card> head = new ArrayList<Card>();
		List<Card> tail = new ArrayList<Card>();
		
		int inc, dec, left, right;
		int value = matrix.getCardValueWeight(card);
		for(inc = 1, dec = 1, left = value - dec, right = value + inc;
				/*(right - left) <= STRAIGHT_COUNT &&*/ (dec + inc) > 0;
				left -= dec, right += inc) {
			dec = checkCardByValue(matrix, left, tail);
			inc = checkCardByValue(matrix, right, head);
		}
		if((right - left) < STRAIGHT_COUNT) {
			return null;
		}
		
		head.add(card);
		return mergeHeadWithTail(head, tail);
	}
	
	private List<Card> mergeHeadWithTail(List<Card> head, List<Card> tail) {
		List<Card> buf = new ArrayList<Card>();
		buf.addAll(head);
		
		int i = 0;
		while((head.size() < STRAIGHT_COUNT || fetch) && i < tail.size()) {
			buf.add(tail.get(i++));
		}
		return buf;
	}
	
	private int checkCardByValue(CardMatrix matrix, int value, List<Card> straight) {
		if(matrix.getValuesCount(value) == 0) {
			return 0;
		} else {
			for(Card buf : matrix.getSameValues(value)){
				straight.add(buf);
				if(!fetch) {
					break;
				}
			}
		}
		return 1;
	}

}
