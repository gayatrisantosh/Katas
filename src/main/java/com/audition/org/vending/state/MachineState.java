package com.audition.org.vending.state;

import java.util.ArrayList;
import java.util.List;

import com.audition.org.vending.enums.State;
import com.audition.org.vending.io.CoinOutputter;
import com.audition.org.vending.model.Product;
import com.audition.org.vending.subscriber.Subscriber;


public class MachineState {
	
	private List<Subscriber> subscribers = new ArrayList<Subscriber>();
	
	private State state = State.DEFAULT;
	
	private Product product = new Product();
	
	private Double amount = 0.0;
	
	private CoinOutputter coinOutputter = new CoinOutputter();
	
	public void register(final Subscriber subscriber){
		subscribers.add(subscriber);
	}

	public String getMessage() {
		if(state.getMessage().length() == 0){
			return constructMessage();
		}
		return state.getMessage();
	}
	
	private String constructMessage(){
		final StringBuilder builder = new StringBuilder();
		builder.append("Selected product : "+product.getName());
		builder.append("\n");
		builder.append("Current balance : "+ amount);
		builder.append("\n");
		if(product.getPrice()>amount)
		builder.append("Insert "+ (product.getPrice() - amount.doubleValue()) +" more");
		return builder.toString();
	}
	
	public void setSelectedProduct(final Product product){
		this.product = product;
		state = State.PRODUCT_SELECTED;
		updateSubscribers();
	}
	
	public Product getSelectedProduct(){
		return product;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
		updateSubscribers();
	}
	
	private void updateSubscribers(){
		for(final Subscriber subscriber : subscribers){
			subscriber.udpate(this);
		}
	}
	
	public Boolean readyToDisposeProduct(){
		if(product.getPrice().doubleValue() == amount.doubleValue()){
			state = State.PRODUCT_READEY_TO_BE_DISPOSED;
			return true;
		}
		if(product.getPrice().doubleValue() < amount.doubleValue()){
			state = State.PRODUCT_READEY_TO_BE_DISPOSED;
			Double change=(amount.doubleValue())-(product.getPrice().doubleValue());
			
			coinOutputter.eject(change);
			return true;
		}
		return false;
	}
	
	public void productDisposed() throws InterruptedException{
		state = State.PRODUCT_DISPOSED;
		amount = 0.0;
		updateSubscribers();
		Thread.sleep(3000);
		state = State.DEFAULT;
		updateSubscribers();
	}
}
