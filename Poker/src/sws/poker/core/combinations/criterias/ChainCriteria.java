package sws.poker.core.combinations.criterias;

import java.util.ArrayList;
import java.util.List;

import sws.poker.core.Card;
import sws.poker.core.CardMatrix;

public class ChainCriteria extends FetchCriteria  {
	private List<Criteria> criterias;
	
	public ChainCriteria() {
		criterias = new ArrayList<Criteria>();
	}
	
	public ChainCriteria(List<Criteria> criterias) {
		this.criterias = criterias;
	}
	
	public void addCriteria(Criteria criteria) {
		criterias.add(criteria);
	}

	@Override
	public List<Card> find(CardMatrix matrix, Card card) {
		CardMatrix result = matrix;
		int count = criterias.size();
		for(Criteria criteria : criterias) {
			count--;
			if(count > 0) {
				criteria.setFetchEager(true);
			}
			List<Card> resultCards = criteria.find(result, card);
			if(resultCards == null) {
				return null;
			}
			result = new CardMatrix(resultCards);
		}
		return result.getAllCards();
	}

}
