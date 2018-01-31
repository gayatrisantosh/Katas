package com.audition.org.vending.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import com.audition.org.vending.enums.State;


public class TestMachineState {
	
	private MachineState machineState;
	
	@Before
	public void setUp(){
		this.machineState = new MachineState();
	}
	
	@Test
	public void shouldShowDefaultMessage(){
		assertEquals(State.DEFAULT.getMessage(), machineState.getMessage());
	}
	
	@Test
	public void shouldInitProperly(){
	assertEquals(State.DEFAULT.getMessage(), machineState.getMessage());
System.out.println(machineState.getSelectedProduct());
		System.out.println(machineState.getAmount());
		assertNull(machineState.getSelectedProduct().getCode());
	   assertEquals("0.0", machineState.getAmount().toString());
	}
}
