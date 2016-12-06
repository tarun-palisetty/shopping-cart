package com.test.shop;

import com.test.shop.exception.ProductNotFoundException;
import com.test.shop.model.Product;

/**
 * @author tarun
 *
 * Shopping cart interface
 *
 */
public interface ShoppingCart {

	boolean addProduct(Product p);

	boolean removeProduct(String productId) throws ProductNotFoundException;

	int getProductsCount();

	double getCartPrice();

}
