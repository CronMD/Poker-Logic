package sws.tests.poker;

import sws.poker.core.CardOwner;

public class TestUser implements CardOwner {
	private long id;
	
	public TestUser(long id) {
		this.id = id;
	}

	@Override
	public long getId() {
		return id;
	}

}
