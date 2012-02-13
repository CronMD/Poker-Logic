package sws.poker.core.combinations;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardOwner;

public interface Combination {

	public abstract UserCardCombination find(CardMatrix matrix,
			List<Card> userCards, CardOwner user);

}