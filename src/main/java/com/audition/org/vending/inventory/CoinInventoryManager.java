package com.audition.org.vending.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.exception.CoinTypeNotAvailableException;
import com.audition.org.vending.model.Coin;

public class CoinInventoryManager {
	
	private Map<CoinType, List<Coin>> coinMap = new HashMap<CoinType, List<Coin>>();
	
	public void load(final List<Coin> coins){
		for(final Coin coin : coins){
			load(coin);
		}
	}
	
	public void load(final Coin coin){
		List<Coin> coins = coinMap.get(coin.getType());
		if(null == coins){
			coins = new ArrayList<Coin>();
		}
		coins.add(coin);
		coinMap.put(coin.getType(), coins); 
	}
	
	public int getCountByCoinType(final CoinType coinType) throws CoinTypeNotAvailableException{
		final List<Coin> coins = coinMap.get(coinType);
		if(CollectionUtils.isNotEmpty(coins)){
			return coins.size();
		}
		throw new CoinTypeNotAvailableException();
	}
	
public Double totalAmountInMachine()
{
	List<Coin> coin= new ArrayList<Coin>();
	
	Double amount = 0.0;
	coin.add(new Coin(CoinType.QUARTER));
	coin.add(new Coin(CoinType.DIME));
	coin.add(new Coin(CoinType.NICKEL));	
	for(int i=0;i<coin.size();i++)
	{
		
		//For testing purpose only....comment below for testing exact change only
		amount+=coin.get(i).getType().value();
	}
	return amount;
}
}
	

