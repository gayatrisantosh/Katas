package com.audition.org.vending.enums;

import java.util.ArrayList;
import java.util.List;


public enum CoinType {
	
	 PENNY(0.01),
     NICKEL(0.05),
     DIME(0.10),
     QUARTER(0.25);

     private Double coinValue;

     public Double value() {
    	 return coinValue;
     }

     CoinType(final Double value){
       coinValue = value;
     }
     
     private static List<CoinType> validCoinTypes = new ArrayList<CoinType>();
     
     static{
    	 validCoinTypes.add(NICKEL);
    	 validCoinTypes.add(DIME);
    	 validCoinTypes.add(QUARTER);
     }
     
     public static List<CoinType> getValidCoinTypes(){
    	 return validCoinTypes;
     }
     
}