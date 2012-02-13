package sws.poker.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sws.poker.core.combinations.CardCombination;
import sws.poker.core.combinations.Combination;
import sws.poker.core.combinations.CombinationFinder;
import sws.poker.core.combinations.UserCardCombination;

public class WinnerFinder {
	private CardMatrix matrix;
	private Combination combinationFinder;
	private List<UserCardCombination> combinations = new ArrayList<UserCardCombination>();
	
	public WinnerFinder(List<Card> cards) {
		matrix = new CardMatrix(cards);
		combinationFinder = new CombinationFinder();
	}
	
	public void addUserCombination(CardOwner user, List<Card> userCards) {
		combinations.add(combinationFinder.find(matrix, userCards, user));
	}
	
	public List<UserCardCombination> getWinners() {
		List<UserCardCombination> winners = new ArrayList<UserCardCombination>();
		CardCombination name = null;
		
		Collections.sort(combinations);
		Collections.reverse(combinations);
		
		for(UserCardCombination combination : combinations) {
			if(name != null && name != combination.getName()) {
				break;
			}
			winners.add(combination);
			name = combination.getName();
		}
		return winners;
	}
}
