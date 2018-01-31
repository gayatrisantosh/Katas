package com.audition.org.vending.subscriber;

import com.audition.org.vending.state.MachineState;


public interface Subscriber {
	
	public void udpate(final MachineState machineState);

}
