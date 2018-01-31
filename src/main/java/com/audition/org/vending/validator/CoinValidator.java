package com.audition.org.vending.validator;

import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.model.Coin;

public class CoinValidator {
	
	/**
	 * 
	 * @param coin
	 * @return
	 */
	public Boolean validate(final Coin coin){
		
		return CoinType.getValidCoinTypes().contains(coin.getType());
	}

}
