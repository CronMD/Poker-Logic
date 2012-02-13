package sws.tests.poker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.combinations.criterias.Criteria;
import sws.poker.core.combinations.criterias.FourCriteria;

public class FourCriteriaTest {
	private Criteria getCriteria() {
		return new FourCriteria();
	}
	
	@Test
	public void four() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.TWO));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.TWO));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 4);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}
	
	@Test
	public void noFour() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.TWO));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.ACE));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
	
	@Test
	public void noFourButHasNotOwnerd() {
		final Card card = new Card(CardSuit.SPADES, CardValue.ACE);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.TWO));
					add(new Card(CardSuit.HEARTS, CardValue.TWO));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.TWO));
					add(card);
				}};
		Criteria criteria = getCriteria();	
		List<Card> combination = criteria.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
}
