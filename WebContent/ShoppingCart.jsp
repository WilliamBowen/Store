<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Shopping Cart</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
 
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<p>Shopping Cart</p>
<p><a href="shop">Item List</a> </p>
<table width="75%" border="1">
  <tr >
    <td>Item Description</td>
    <td>Quantity</td>
    <td>Unit Price</td>
    <td>Total</td>
  </tr>
  <jsp:useBean id="cart" scope="session" class="wb.store.cart.Cart" />
  <c:if test="${cart.lineItemCount==0}">
  <tr>
  <td colspan="4">- Cart is currently empty -<br/>
  </tr>
  </c:if>
  <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
  <form name="item" method="POST" action="servlet/CartController">
  <tr>
    <td><c:out value="${cartItem.itemName}"/><br/>
      <c:out value="${cartItem.itemDescription}"/></td>
    <td><input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/>'>
    <input type='text' name="quantity" value='<c:out value="${cartItem.quantity}"/>' size='2'> 
    <input type="submit" name="action" value="Update">
 <br/>         <input type="submit" name="action" value="Delete"></td>
    <td>$<fmt:formatNumber type="number" maxFractionDigits="2" value="${cartItem.itemPrice}"/></td>
    <td>$<fmt:formatNumber type="number" maxFractionDigits="2" value="${cartItem.totalCost}"/></td>
  </tr>
  </form>
  </c:forEach>
  <tr>
    <td colspan="2"> </td>
    <td> </td>
    <td>Subtotal: $<fmt:formatNumber type="number" maxFractionDigits="2" value="${cart.orderTotal}"/></td>
  </tr>
</table>
</body>
</html>