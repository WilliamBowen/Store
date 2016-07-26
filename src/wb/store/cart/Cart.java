package wb.store.cart;

import java.util.ArrayList;

public class Cart {
	private ArrayList alCartItems = new ArrayList();
	 private double dblOrderTotal ;
	  
	 public int getLineItemCount() {
	  return alCartItems.size();
	 }
	  
	 public void deleteCartItem(String strItemIndex) {
	  int iItemIndex = 0;
	  try {
	   iItemIndex = Integer.parseInt(strItemIndex);
	   alCartItems.remove(iItemIndex - 1);
	   calculateOrderTotal();
	  } catch(NumberFormatException nfe) {
	   System.out.println("Error while deleting cart item: "+nfe.getMessage());
	   nfe.printStackTrace();
	  }
	 }
	  
	 public void updateCartItem(String strItemIndex, String strQuantity) {
	  double totalCost = 0.0;
	  double itemCost = 0.0;
	  int quantity = 0;
	  int iItemIndex = 0;
	  CartItem cartItem = null;
	  try {
	   iItemIndex = Integer.parseInt(strItemIndex);
	   quantity = Integer.parseInt(strQuantity);
	   if(quantity>0) {
	    cartItem = (CartItem)alCartItems.get(iItemIndex-1);
	    itemCost = cartItem.getItemPrice();
	    totalCost = itemCost*quantity;
	    cartItem.setQuantity(quantity);
	    cartItem.setTotalCost(totalCost);
	    calculateOrderTotal();
	   }
	  } catch (NumberFormatException nfe) {
	   System.out.println("Error while updating cart: "+nfe.getMessage());
	   nfe.printStackTrace();
	  }
	   
	 }
	  
	 public void addCartItem(Integer itemId, String itemName, String itemDescription,
	String strUnitCost, String strQuantity) {
	  double totalCost = 0.0;
	  double itemPrice = 0.0;
	  int quantity = 0;
	  CartItem cartItem = new CartItem();
	  try {
	   itemPrice = Double.parseDouble(strUnitCost);
	   quantity = Integer.parseInt(strQuantity);
	   if(quantity>0) {
	    totalCost = itemPrice*quantity;
	    cartItem.setItemId(itemId);
	    cartItem.setItemName(itemName);
	    cartItem.setItemDescription(itemDescription);
	    cartItem.setItemPrice(itemPrice);
	    cartItem.setQuantity(quantity);
	    cartItem.setTotalCost(totalCost);
	    alCartItems.add(cartItem);
	    calculateOrderTotal();
	   }
	    
	  } catch (NumberFormatException nfe) {
	   System.out.println("Error while parsing from String to primitive types: "+nfe.getMessage());
	   nfe.printStackTrace();
	  }
	 }
	  
	 public void addCartItem(CartItem cartItem) {
	  alCartItems.add(cartItem);
	 }
	  
	 public CartItem getCartItem(int iItemIndex) {
	  CartItem cartItem = null;
	  if(alCartItems.size()>iItemIndex) {
	   cartItem = (CartItem) alCartItems.get(iItemIndex);
	  }
	  return cartItem;
	 }
	  
	 public ArrayList getCartItems() {
	  return alCartItems;
	 }
	 public void setCartItems(ArrayList alCartItems) {
	  this.alCartItems = alCartItems;
	 }
	 public double getOrderTotal() {
	  return dblOrderTotal;
	 }
	 public void setOrderTotal(double dblOrderTotal) {
	  this.dblOrderTotal = dblOrderTotal;
	 }
	  
	 protected void calculateOrderTotal() {
	  double dblTotal = 0;
	  for(int counter=0;counter<alCartItems.size();counter++) {
	   CartItem cartItem = (CartItem) alCartItems.get(counter);
	   dblTotal+=cartItem.getTotalCost();
	    
	  }
	  setOrderTotal(dblTotal);
	 }
	 
}
