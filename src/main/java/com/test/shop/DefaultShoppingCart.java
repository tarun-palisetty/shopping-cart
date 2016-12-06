package com.test.shop;

import java.util.HashMap;
import java.util.Map;

import com.test.shop.exception.ProductNotFoundException;
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


	public boolean removeProduct(String productId) throws ProductNotFoundException {
		if(productMap.containsKey(productId)){
			productMap.remove(productId);
			return true;
		} // remove the product if Id is present
		else{
			throw new ProductNotFoundException("Product with id: "+productId+" is not found!");
		}
	}


	public int getProductsCount() {
		return productMap.size();
	}


	public double getCartPrice() {
		return 0;
	}

}
