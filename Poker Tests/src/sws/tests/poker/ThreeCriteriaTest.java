package sws.tests.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.combinations.criterias.ThreeCriteria;

public class ThreeCriteriaTest {
	
	@Test
	public void three() {
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
		ThreeCriteria three = new ThreeCriteria();		
		List<Card> combination = three.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 3);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}

	@Test
	public void noThree() {
		final Card card = new Card(CardSuit.SPADES, CardValue.TWO);
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.HEARTS, CardValue.ACE));
					add(new Card(CardSuit.SPADES, CardValue.TWO));
					add(new Card(CardSuit.SPADES, CardValue.EIGHT));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
					add(card);
				}};
		ThreeCriteria three = new ThreeCriteria();		
		List<Card> combination = three.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}
	
	@Test
	public void threeForFourSame() {
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
		ThreeCriteria three = new ThreeCriteria();		
		List<Card> combination = three.find(new CardMatrix(cards), card);
		assertTrue(combination != null);
		assertEquals(combination.size(), 3);
		for(Card buf : combination) {
			if(buf == card) {
				return;
			}
		}
		fail("Not found owned card");
	}
	
	@Test
	public void noThreeButHaveNotOwnedPair() {
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
					add(new Card(CardSuit.CLUBS, CardValue.TWO));
					add(card);
				}};
		ThreeCriteria three = new ThreeCriteria();		
		List<Card> combination = three.find(new CardMatrix(cards), card);
		assertTrue(combination == null);
	}

}
