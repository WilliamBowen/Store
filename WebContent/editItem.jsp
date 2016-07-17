<%@ page import="java.util.*, wb.store.model.Item" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<% Item item = (Item)request.getAttribute("item"); %>
<form action="editItem" method="POST">
Edit information about item.<br/>
Name: <input type="text" name="item_name" value="<%=item.getName()%>"/><br/>
Price:<input type="text" name="item_price" value="<%=item.getPrice() %>"/><br/>
<textarea name="item_description"><%= item.getDescription() %></textarea><br/>
<input type="submit" value="Edit Item"/>
</form>
</body>
</html>