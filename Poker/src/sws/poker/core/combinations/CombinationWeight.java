package sws.poker.core.combinations;

import java.util.HashMap;
import java.util.Map;

public class CombinationWeight {
	private Map<CardCombination, Integer> weightMap = new HashMap<CardCombination, Integer>()
		{
			private static final long serialVersionUID = 1L;
		{
			put(CardCombination.BIGGER, 1);
			put(CardCombination.PAIR, 2);
			put(CardCombination.TWO_PAIRS, 3);
			put(CardCombination.THREE, 4);
			put(CardCombination.STRAIGHT, 5);
			put(CardCombination.FLUSH, 6);
			put(CardCombination.FULL_HOUSE, 7);
			put(CardCombination.FOUR, 8);
			put(CardCombination.STRAIGHT_FLUSH, 9);
			put(CardCombination.FLUSH_ROYAL, 10);
		}};
	
	public int getWeight(CardCombination combination) {
		return weightMap.get(combination);
	}
}
