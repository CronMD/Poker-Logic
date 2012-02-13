package sws.tests.poker;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import sws.poker.core.Card;
import sws.poker.core.CardSuit;
import sws.poker.core.CardValue;
import sws.poker.core.WinnerFinder;
import sws.poker.core.combinations.CardCombination;
import sws.poker.core.combinations.UserCardCombination;

public class PairWinnerTest {
	
	@Test
	public void pairWinner(){
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.CLUBS, CardValue.TEN));
					add(new Card(CardSuit.CLUBS, CardValue.ACE));
					add(new Card(CardSuit.HEARTS, CardValue.NINE));
					add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
					add(new Card(CardSuit.SPADES, CardValue.SIX));
				}};
				
		WinnerFinder finder = new WinnerFinder(cards);
		
		finder.addUserCombination(new TestUser(1), new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TEN));
				}});
		finder.addUserCombination(new TestUser(2), new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.HEARTS, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.TWO));
				}});
		
		List<UserCardCombination> winners = finder.getWinners();
		assertEquals(winners.size(), 1);
		assertEquals(winners.get(0).getUser().getId(), 1L);
		assertEquals(winners.get(0).getName(), CardCombination.PAIR);
	}
	
	@Test
	public void pairWinnerSeveralPairsInNotOwnedCards(){
		List<Card> cards = new ArrayList<Card>()
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.CLUBS, CardValue.TEN));
					add(new Card(CardSuit.DIAMONDS, CardValue.EIGHT));
					add(new Card(CardSuit.HEARTS, CardValue.SIX));
					add(new Card(CardSuit.CLUBS, CardValue.EIGHT));
					add(new Card(CardSuit.SPADES, CardValue.SIX));
				}};
				
		WinnerFinder finder = new WinnerFinder(cards);
		
		finder.addUserCombination(new TestUser(1), new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.DIAMONDS, CardValue.FIVE));
					add(new Card(CardSuit.DIAMONDS, CardValue.TEN));
				}});
		finder.addUserCombination(new TestUser(2), new ArrayList<Card>() 
				{
					private static final long serialVersionUID = 1L;
				{
					add(new Card(CardSuit.HEARTS, CardValue.FOUR));
					add(new Card(CardSuit.SPADES, CardValue.TWO));
				}});
		
		List<UserCardCombination> winners = finder.getWinners();
		assertEquals(winners.size(), 1);
		assertEquals(winners.get(0).getUser().getId(), 1L);
		assertEquals(winners.get(0).getName(), CardCombination.PAIR);
	}
}
