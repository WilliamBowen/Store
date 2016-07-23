package wb.store.model;

import java.util.HashMap;

public class Cart {
	HashMap<Integer, Integer> cartItems;	
	
	public Cart(){
		cartItems = new HashMap<>();
		
	}
	public HashMap getCartItems(){
		return cartItems;
	}
	
	public void addToCart(int id, int quantity){
		cartItems.put(id, quantity);
	}
	
	public void deleteFromCart(int id){
		cartItems.remove(id);
	}
}
