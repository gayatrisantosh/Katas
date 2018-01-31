package com.audition.org.vending.io;

import java.util.ArrayList;
import java.util.List;

import com.audition.org.vending.model.Coin;

public class CoinOutputter {
	
	private Double amount = new Double(0.0);
	
	public Double eject(final List<Coin> coins){
		for(final Coin coin : coins){
			amount += coin.getType().value();
			System.out.println(">>>>> Ejecting "+coin.getType());
		}
		
		return amount;
	}
	public Double eject(final Double change){
					
			System.out.println(">>>>> Ejecting "+change.floatValue());
	
		
		return change;
	}
	
	public Double eject(final Coin coin){
		final List<Coin> coins = new ArrayList<Coin>();
		coins.add(coin);
		return eject(coins);
	}
}
