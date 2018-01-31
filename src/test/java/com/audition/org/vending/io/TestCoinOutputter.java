package com.audition.org.vending.io;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.model.Coin;

public class TestCoinOutputter {
	
	private CoinOutputter coinOutputter;
	
	@Before
	public void setUp(){
		coinOutputter = new CoinOutputter();
	}
	
	@Test
	public void shouldEjectCoins(){
		final List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(CoinType.NICKEL));
		coins.add(new Coin(CoinType.DIME));
		coins.add(new Coin(CoinType.QUARTER));
		assertEquals(new Double(40.0), coinOutputter.eject(coins));
	}
	
	@Test
	public void shouldEjectCoin(){
		assertEquals(new Double(5.0), coinOutputter.eject(new Coin(CoinType.NICKEL)));
	}

}
