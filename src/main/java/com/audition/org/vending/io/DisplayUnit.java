package com.audition.org.vending.io;

import com.audition.org.vending.state.MachineState;
import com.audition.org.vending.subscriber.Subscriber;



public class DisplayUnit implements Subscriber{
	
	/**
	 * For testing purpose I have added return type
	 * 
	 * @param message
	 * @return
	 */
	public String showMessage(final String message){
		System.out.println(">>>> " + message);
		return message;
	}
	
	/**
	 * 
	 */
	public void udpate(MachineState machineState) {
		this.showMessage(machineState.getMessage());
	}

}
