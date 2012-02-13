package sws.poker.core.combinations;

import java.util.ArrayList;

import sws.poker.core.combinations.criterias.ChainCriteria;
import sws.poker.core.combinations.criterias.Criteria;
import sws.poker.core.combinations.criterias.FlushCriteria;
import sws.poker.core.combinations.criterias.NumberCriteria;
import sws.poker.core.combinations.criterias.RoyalCriteria;
import sws.poker.core.combinations.criterias.StraightCriteria;

public class CombinationFactory {
	public Combination getCombination(CardCombination name) {
		Combination combination = null;
		switch(name) {
			case PAIR:
				combination = new FirstCombination(new NumberCriteria(2), name);
				break;	
			case THREE:
				combination = new FirstCombination(new NumberCriteria(3), name);
				break;
			case FOUR:
				combination = new FirstCombination(new NumberCriteria(4), name);
				break;
			case STRAIGHT:
				combination = new FirstCombination(new StraightCriteria(), name);
				break;
			case FLUSH:
				combination = new FirstCombination(new FlushCriteria(), name);
				break;
			case STRAIGHT_FLUSH:
				combination = new FirstCombination(new ChainCriteria(new ArrayList<Criteria>() {
					private static final long serialVersionUID = 1L;
					{
						add(new StraightCriteria());
						add(new FlushCriteria());
					}}), name);
				break;
			case FLUSH_ROYAL:
				combination = new FirstCombination(new ChainCriteria(new ArrayList<Criteria>() {
					private static final long serialVersionUID = 1L;
					{
						add(new StraightCriteria());
						add(new FlushCriteria());
						add(new RoyalCriteria());
					}}), name);
				break;
			case FULL_HOUSE:
				combination = new ChainCombination(new ArrayList<Combination>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(getCombination(CardCombination.THREE));
					add(getCombination(CardCombination.PAIR));
				}}, name);
				break;				
			case TWO_PAIRS:
				combination = new ChainCombination(new ArrayList<Combination>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(getCombination(CardCombination.PAIR));
					add(getCombination(CardCombination.PAIR));
				}}, name);
				break;
			case BIGGER:
				combination = new FirstCardCombination(name);
				break;
			default:
				throw new NotSupportedCombination();
		}
		return combination;
	}
}
