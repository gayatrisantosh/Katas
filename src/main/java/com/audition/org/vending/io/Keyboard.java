package com.audition.org.vending.io;

import com.audition.org.vending.Machine.Machine;
import com.audition.org.vending.exception.ProductOutOfStockException;

public class Keyboard {
	
	public static final Integer cancelCode = -999;
	
	private Machine machine;
	
	public Keyboard(Machine machine){
		this.machine = machine;
	}
	
	

	public void one() throws ProductOutOfStockException{
		machine.selectProduct(1);
	}
	
	public void two() throws ProductOutOfStockException{
		machine.selectProduct(2);
	}
	
	public void three() throws ProductOutOfStockException{
		machine.selectProduct(3);
	}
	
	/**
	 * cancel the selection, return the money.
	 * @throws ProductOutOfStockException 
	 */
	public void cancel() throws ProductOutOfStockException{
		machine.selectProduct(cancelCode);
	}
}
