package com.audition.org.vending.external;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.external.CoinDetector;
import com.audition.org.vending.model.Coin;


public class TestCoinDetector {
	
	private CoinDetector coinDetector;
	
	@Before
	public void setUp(){
		coinDetector = new CoinDetector();
	}
	
	@Test
	public void shouldDetectNickel(){
		final Coin coin = new Coin(CoinType.NICKEL);
		assertEquals(CoinType.NICKEL, coinDetector.detect(coin));
	}
	
	@Test
	public void shouldDetectDime(){
		final Coin coin = new Coin(CoinType.DIME);
		assertEquals(CoinType.DIME, coinDetector.detect(coin));
	}
	
	@Test
	public void shouldDetectQuarter(){
		final Coin coin = new Coin(CoinType.QUARTER);
		assertEquals(CoinType.QUARTER, coinDetector.detect(coin));
	}
	
	@Test
	public void shouldDetectPenny(){
		final Coin coin = new Coin(CoinType.PENNY);
		assertEquals(CoinType.PENNY, coinDetector.detect(coin));
	}
	
}
