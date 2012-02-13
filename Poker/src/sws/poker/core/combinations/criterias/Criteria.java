package sws.poker.core.combinations.criterias;

import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;

public interface Criteria {

	public abstract List<Card> find(CardMatrix matrix, Card card);
	public abstract void setFetchEager(boolean fetch);
}