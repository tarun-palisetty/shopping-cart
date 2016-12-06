package com.test.shop;

import java.util.HashMap;
import java.util.Map;

import com.test.shop.model.Product;

/**
 * @author tarun
 *
 * Shopping cart implementation
 */
public class DefaultShoppingCart implements ShoppingCart{
	
	public Map<String, Product> productMap;
	
	public DefaultShoppingCart(){
		productMap = new HashMap<String, Product>();
	}
	

	public boolean addProduct(Product p) {
		if(productMap.containsKey(p.getProductId())){
			Product p1 = productMap.get(p.getProductId());
			p1.setQuantity(p1.getQuantity() + p.getQuantity());
			p1.setPrice(p1.getPrice() + p.getPrice());
			
			return true;
		} // adding to existing product
		
		productMap.put(p.getProductId(), p);
		return false;
	}

}
