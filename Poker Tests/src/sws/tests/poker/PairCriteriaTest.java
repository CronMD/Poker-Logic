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
import sws.poker.core.combinations.criterias.PairCriteria;

public class PairCriteriaTest {
	
	@Test
	public void pair() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.ACE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
					add(card);
				}};
		Criteria pair = new PairCriteria();		
		List<Card> combination = pair.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 2);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}

	@Test
	public void noPair() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.ACE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.SPADES, CardValue.EIGHT));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
					add(card);
				}};
		Criteria pair = new PairCriteria();		
		List<Card> combination = pair.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
	
	@Test
	public void pairForThreeSame() {
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
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
					add(card);
				}};
		Criteria pair = new PairCriteria();		
		List<Card> combination = pair.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 2);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}
	
	@Test
	public void noPairButHaveNotOwnedPair() {
		final Card card = new Card(CardSuit.SPADES, CardValue.THREE);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.TWO));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
					add(card);
				}};
		Criteria pair = new PairCriteria();		
		List<Card> combination = pair.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}

}
