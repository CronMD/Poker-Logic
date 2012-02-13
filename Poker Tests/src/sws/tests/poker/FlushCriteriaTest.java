package sws.tests.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.combinations.criterias.Criteria;
import sws.poker.core.combinations.criterias.FlushCriteria;

public class FlushCriteriaTest {
	private Criteria getCriteria() {
		return new FlushCriteria();
	}

	@Test
	public void flush() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.THREE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.ACE));
					add(new Card(CardSuit.SPADES, CardValue.KING));
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
	public void noFlush() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.THREE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.ACE));
					add(new Card(CardSuit.CLUBS, CardValue.KING));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
	
	@Test
	public void noFlushButHasNotOwnedCards() {
		final Card card = new Card(CardSuit.HEARTS, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.THREE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.SPADES,  CardValue.ACE));
					add(new Card(CardSuit.SPADES, CardValue.KING));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
}
