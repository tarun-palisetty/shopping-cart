package com.test.shop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.test.shop.exception.ProductNotFoundException;
import com.test.shop.model.Product;

public class DefaultShoppingCartTest {
	
	private ShoppingCart shoppingCart;
	
	@Before
	public void setUp(){
		shoppingCart = new DefaultShoppingCart();
	}
	
	@After
	public void tearDown(){
		
	}

	@Test
	public void testAddProduct() {
		assertFalse(shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d)));
	}
	
	@Test
	public void testAddMultipleProducts(){
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d));
		assertTrue(shoppingCart.addProduct(new Product("001", "Apples", 4, 2.40d)));
	}
	
	@Test
	public void testRemoveProduct() throws ProductNotFoundException{
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d));
		shoppingCart.addProduct(new Product("002", "Oranges", 3, 1.80d));
		assertTrue(shoppingCart.removeProduct("001"));
	}
	
	@Test
	public void testGetProductFromCart() throws ProductNotFoundException{
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d));
		shoppingCart.addProduct(new Product("002", "Oranges", 3, 1.80d));
		Product product = shoppingCart.getProductFromCart("002");
		assertEquals("002", product.getProductId());
	}
	
	@Test(expected=ProductNotFoundException.class)
	public void testProductNotFoundException() throws ProductNotFoundException{
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d));
		shoppingCart.addProduct(new Product("002", "Oranges", 3, 1.80d));
		assertTrue(shoppingCart.removeProduct("003"));
	}
	
	@Test
	public void testTotalProducts(){
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d));
		shoppingCart.addProduct(new Product("002", "Oranges", 3, 1.80d));
		assertEquals(2, shoppingCart.getProductsCount());
	}
	
	@Test
	public void testgetCartPrice(){
		shoppingCart.addProduct(new Product("001", "Apples", 3, 1.80d)); 
		shoppingCart.addProduct(new Product("002", "Oranges", 3, 0.75d)); 
		shoppingCart.addProduct(new Product("001", "Apples", 2, 1.20d));
		assertEquals(2.30d, shoppingCart.getCartPrice(), 1);
	}
	
	@Test
	public void testgetCart2Price(){
		shoppingCart.addProduct(new Product("001", "Apples", 1, 0.60d)); 
		shoppingCart.addProduct(new Product("001", "Apples", 1, 0.60d)); 
		shoppingCart.addProduct(new Product("002", "Oranges", 1, 0.25d)); 
		shoppingCart.addProduct(new Product("001", "Apples", 1, 0.60d));
		assertEquals(1.45d, shoppingCart.getCartPrice(), 1);
	}
	
	
}
