package sws.tests.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.combinations.CardCombination;
import sws.poker.core.combinations.ChainCombination;
import sws.poker.core.combinations.Combination;
import sws.poker.core.combinations.FirstCombination;
import sws.poker.core.combinations.UserCardCombination;
import sws.poker.core.combinations.criterias.NumberCriteria;

public class FullHouseCombinationTest {

	private Combination getCombination() {
		return new ChainCombination(new ArrayList<Combination>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(new FirstCombination(new NumberCriteria(3), CardCombination.THREE));
					add(new FirstCombination(new NumberCriteria(2), CardCombination.PAIR));
				}}, CardCombination.FULL_HOUSE);
	}

	@Test
	public void fullHouse() {
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TWO));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
				}};
				
		List<Card> userCards = new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.SPADES, CardValue.TWO));
					add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
				}};
				
		Combination combination = getCombination();
		UserCardCombination cardCombination = combination.find(new CardMatrix(cards), userCards, new TestUser(1));
		assertTrue(cardCombination != null);
	}
	
	@Test
	public void noFullHouse() {
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.ACE));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
				}};
				
		List<Card> userCards = new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.SPADES, CardValue.TWO));
					add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
				}};
				
		Combination combination = getCombination();
		UserCardCombination cardCombination = combination.find(new CardMatrix(cards), userCards, new TestUser(1));
		assertTrue(cardCombination == null);
	}
	
	@Test
	public void noFullHouseButHasNotOwned() {
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;

				{
					add(new Card(CardSuit.DIAMONDS, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.NINE));
					add(new Card(CardSuit.SPADES, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
					add(new Card(CardSuit.CLUBS, CardValue.FIVE));
				}};
				
		List<Card> userCards = new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.SPADES, CardValue.TWO));
					add(new Card(CardSuit.DIAMONDS, CardValue.JACK));
				}};
				
		Combination combination = getCombination();
		UserCardCombination cardCombination = combination.find(new CardMatrix(cards), userCards, new TestUser(1));
		assertTrue(cardCombination == null);
	}
}
