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
  <tr>
    <td><form  method="POST" action="servlet/CartController">
 <input type="hidden" name="modelNo" value="TF-MODEL1">
      <p>Description: Tech-Freaks imaginary model 1. <input type="hidden" name="description" value="Tech-Freaks imaginary model 1."></p>
      <p>Quantity:<input type="text" size="2" value="1" name="quantity"></p>
      <p>Price: $10.00<input type="hidden" name="price" value="10"></p><input type="hidden" name="action" value="add"><input type="submit" name="addToCart" value="Add To Cart">
      </form></td>
  </tr>
  <tr>
    <td><form name="modelDetail3" method="POST" action="servlet/CartController"><p>Model: TF-Model3<input type="hidden" name="modelNo" value="TF-MODEL3"></p>
      <p>Description: Tech-Freaks imaginary model 3.<input type="hidden" name="description" value="Tech-Freaks imaginary model 3."></p>
      <p>Quantity:<input type="text" size="2" value="1" name="quantity"></p>
      <p>Price: $30.00<input type="hidden" name="price" value="30"></p>        
      <input type="hidden" name="action" value="add">
        <input type="submit" name="addToCart" value="Add To Cart">
</form></td>
  </tr>
</table>
<p> </p>
</body>
</html>