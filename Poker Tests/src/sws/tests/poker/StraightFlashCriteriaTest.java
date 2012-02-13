package sws.tests.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.combinations.criterias.ChainCriteria;
import sws.poker.core.combinations.criterias.Criteria;
import sws.poker.core.combinations.criterias.FlushCriteria;
import sws.poker.core.combinations.criterias.StraightCriteria;

public class StraightFlashCriteriaTest {
	private Criteria getCriteria() {
		return new ChainCriteria(new ArrayList<Criteria>() {
			private static final long serialVersionUID = 1L;
			{
				add(new StraightCriteria());
				add(new FlushCriteria());
			}});
	}

	@Test
	public void straightFlush() {
		final Card card = new Card(CardSuit.SPADES, CardValue.JACK);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.EIGHT));
					add(new Card(CardSuit.SPADES, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.QUEEN));
					add(new Card(CardSuit.SPADES, CardValue.TEN));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 5);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}
	
	@Test
	public void noStraightFlush() {
		final Card card = new Card(CardSuit.SPADES, CardValue.JACK);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.EIGHT));
					add(new Card(CardSuit.SPADES, CardValue.NINE));
					add(new Card(CardSuit.DIAMONDS, CardValue.QUEEN));
					add(new Card(CardSuit.SPADES, CardValue.TEN));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
}
