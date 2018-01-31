package com.audition.org.vending.io;

import com.audition.org.vending.model.Product;
import com.audition.org.vending.state.MachineState;
import com.audition.org.vending.subscriber.Subscriber;

public class ProductOutputter implements Subscriber{
	
	public Product eject(final Product product){
		System.out.println(">>>>>>>>>>> ejecting" + product);
		return product;
	}

	public void udpate(MachineState machineState) {
		if(machineState.readyToDisposeProduct()){
			eject(machineState.getSelectedProduct());
			try {
				machineState.productDisposed();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
