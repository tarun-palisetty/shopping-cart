package com.test.shop;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultShoppingCartTest {
	
	private ShoppingCart shoppingCart;
	
	@Before
	public void setUp(){
		shoppingCart = Mockito.mock(DefaultShoppingCart.class);
	}
	
	@After
	public void tearDown(){
		
	}

	@Test
	public void testAddProduct() {
		assertFalse(shoppingCart.addProduct());
	}

}
