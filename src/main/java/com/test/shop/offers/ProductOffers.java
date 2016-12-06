package com.test.shop.offers;

/**
 * @author tarun
 * 
 * Product offers class to calculate the final price after discount
 *
 */
public class ProductOffers {

	/**
	 * buyOneGetOneOffer price calculation
	 * 
	 * */
	public double buyOneGetOneOffer(int noOfItems, double unitPrice){
		return ((noOfItems/2) + (noOfItems%2)) * unitPrice;
	}
	
	/**
	 * Three for two price calculation
	 * */
	public double threeForTwoOffer(int noOfItems, double unitPrice){
		return (2 * (noOfItems/3) + (noOfItems%3)) * unitPrice;
	}
}