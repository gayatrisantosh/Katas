package com.audition.org.vending.io;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.audition.org.vending.enums.CoinType;
import com.audition.org.vending.exception.InvalidCoinException;
import com.audition.org.vending.external.CoinDetector;
import com.audition.org.vending.model.Coin;
import com.audition.org.vending.validator.CoinValidator;


public class TestCoinInputter {

	private CoinInputter coinInputter;
	
	private CoinValidator coinValidator;
	
	private CoinDetector coinDetector;
	
	@Before
	public void setUp(){
		coinValidator = new CoinValidator();
		coinDetector = new CoinDetector();
		coinInputter = new CoinInputter(coinValidator, coinDetector);
	}
	
	@Test
	public void shouldAcceptDime() throws InvalidCoinException{
		final Coin coin = new Coin(CoinType.DIME);
		coinInputter.accept(coin);
	}
	
	@Test
	public void shouldAcceptNickel() throws InvalidCoinException{
		final Coin coin = new Coin(CoinType.NICKEL);
		coinInputter.accept(coin);
	}
	
	@Test
	public void shouldAcceptQuarter() throws InvalidCoinException{
		final Coin coin = new Coin(CoinType.QUARTER);
		coinInputter.accept(coin);
	}
	
	@Test(expected = InvalidCoinException.class)
	public void shouldNotAcceptPenny() throws InvalidCoinException{
		final Coin coin = new Coin(CoinType.PENNY);
		coinInputter.accept(coin);
	}
	
	@Test
	public void shouldIcreamentBalance() throws InvalidCoinException{
		coinInputter.accept(new Coin(CoinType.NICKEL));
		coinInputter.accept(new Coin(CoinType.DIME));
	    coinInputter.accept(new Coin(CoinType.QUARTER));
		
		System.out.println(coinInputter.getAmount());
		assertEquals(new Double(0.4), coinInputter.getAmount());
	}
}
