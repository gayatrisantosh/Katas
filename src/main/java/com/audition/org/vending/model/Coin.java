package com.audition.org.vending.model;

import com.audition.org.vending.enums.CoinType;

public class Coin {
	
	private CoinType type;
	
	public Coin(final CoinType coinType){
		this.type = coinType;
	}

	public CoinType getType() {
		return type;
	}

}
