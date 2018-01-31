package com.audition.org.vending.external;

import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.model.Coin;


public class CoinDetector {
	
	/**
	 * In real case the coin would be measured based on it's weight and shape.
	 * 
	 * @param coin
	 * @return
	 */
	public CoinType detect(final Coin coin){
		return coin.getType();
	}
	
	public Double getCoinValue(final Coin coin){
		return detect(coin).value();
	}

}
