package sws.poker.core.combinations.criterias;

public abstract class FetchCriteria implements Criteria {
	protected boolean fetch = false;
	
	public void setFetchEager(boolean fetch) {
		this.fetch = fetch;
	}
}
