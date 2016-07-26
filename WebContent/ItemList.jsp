<%@ page import="java.util.*, wb.store.model.Item" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Item List</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
 
<body>
<p>Item List</p>
<a href="ShoppingCart.jsp">View Cart</a>
<p/>
<table width="75%" border="1">
<% 
ArrayList al = (ArrayList)request.getAttribute("items");
Iterator it = al.iterator();

while(it.hasNext()) {
  Item item = (Item)it.next();
%>
  <tr>
    <td><form  method="POST" action="servlet/CartController">
   	  <input type="hidden" name="itemId" value="<%= item.getId() %>">	
 	  <p> Name: <%= item.getName() %><input type="hidden" name="name" value="<%= item.getName() %>"></p>
      <p>Description:  <%= item.getDescription() %> <input type="hidden" name="description" value="<%= item.getDescription() %>"></p>
      <p>Quantity:<input type="text" size="2" value="1" name="quantity"></p>
      <p>Price: <%= item.getPrice() %><input type="hidden" name="price" value="<%= item.getPrice() %>"></p>
      <input type="hidden" name="action" value="add">
      <input type="submit" name="addToCart" value="Add To Cart">
      </form></td>
  </tr>
  <% } %> 
</table>

<p> </p>
</body>
</html>