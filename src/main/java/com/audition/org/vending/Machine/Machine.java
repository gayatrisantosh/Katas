package com.audition.org.vending.Machine;

import java.util.List;

import com.audition.org.vending.exception.InvalidCoinException;
import com.audition.org.vending.exception.ProductOutOfStockException;
import com.audition.org.vending.external.CoinDetector;
import com.audition.org.vending.inventory.CoinInventoryManager;
import com.audition.org.vending.inventory.ProductInventoryManager;
import com.audition.org.vending.io.CoinInputter;
import com.audition.org.vending.io.CoinOutputter;
import com.audition.org.vending.io.DisplayUnit;
import com.audition.org.vending.io.Keyboard;
import com.audition.org.vending.io.ProductOutputter;
import com.audition.org.vending.model.Coin;
import com.audition.org.vending.model.Product;
import com.audition.org.vending.state.MachineState;
import com.audition.org.vending.validator.CoinValidator;

public class Machine {
	
	private MachineState machineState = new MachineState();
	private CoinInputter coinInputter = new CoinInputter(new CoinValidator(), new CoinDetector());
	private CoinOutputter coinOutputter = new CoinOutputter();
	private DisplayUnit displayUnit = new DisplayUnit();
	private Keyboard keyboard = new Keyboard(this);
	private ProductInventoryManager productInventoryManager = new ProductInventoryManager();
	private CoinInventoryManager coinInventoryManager = new CoinInventoryManager();
	private ProductOutputter productOutputter = new ProductOutputter();
	
	
	public Machine(){
		machineState.register(displayUnit);
		machineState.register(productOutputter);
		displayUnit.showMessage(machineState.getMessage());
	}
	
	/**
	 * This method is for 
	 * 
	 * @return
	 */
	/*public void acceptCoin(final Coin coin) throws InvalidCoinException{
		coinInputter.accept(coin);
		machineState.setAmount(coinInputter.getAmount());
		//eject.. we are now taking only exact change, coinInventoryManager needs to be implemented
		if(coinInputter.getAmount().doubleValue() > machineState.getSelectedProduct().getPrice().doubleValue() && coinInventoryManager.totalAmountInMachine()<0){
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}
	}*/
	
	public void acceptCoin(final Coin coin) throws InvalidCoinException{
		coinInputter.accept(coin);
		machineState.setAmount(coinInputter.getAmount());
		//eject.. we are now taking only exact change, coinInventoryManager needs to be implemented
		if(coinInputter.getAmount().doubleValue() > machineState.getSelectedProduct().getPrice().doubleValue() && coinInventoryManager.totalAmountInMachine()>new Double(0.0)){
			
			//coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
			}
		
		if(coinInputter.getAmount().doubleValue() > machineState.getSelectedProduct().getPrice().doubleValue() && coinInventoryManager.totalAmountInMachine()<=new Double(0.0)){
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}
	}
	
	/**
	 * This method is only for testing.
	 * 
	 * @return
	 */
	public Keyboard getKeyboard(){
		return this.keyboard;
	}
	
	/**
	 * 
	 * @param code
	 * @throws ProductOutOfStockException
	 */
	public void selectProduct(final Integer code) throws ProductOutOfStockException{
		if(Keyboard.cancelCode.intValue() == code.intValue()){
			coinOutputter.eject(coinInputter.returnMoney());
			machineState = new MachineState();
			machineState.register(displayUnit);
			machineState.register(productOutputter);
			displayUnit.showMessage(machineState.getMessage());
		}else{
			final Product product = productInventoryManager.getProduct(code);
			machineState.setSelectedProduct(product);
		}
	}
	
	public void loadProducts(final List<Product> products){
		productInventoryManager.load(products);
	}
	
	
}
