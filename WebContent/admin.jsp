<%@ page import="java.util.*, wb.store.model.Item" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin page</title>
</head>
<body>
<% 
String item_id = "";
String item_price = "";
String item_name = "";
String item_description = "";
String action = "addItem";

if(request.getAttribute("item") != null){
	Item item = (Item)request.getAttribute("item");
	item_id = String.valueOf(item.getId());
	item_price = String.valueOf(item.getPrice());
	item_name = item.getName();
	item_description = item.getDescription();
	action = (String)request.getAttribute("action");
}

%>
<form action="<%= action %>" method="POST">
Enter information about the item.<br/>
<input type="hidden" name="item_id" value="<%= item_id %>"/>
Name: <input type="text" name="item_name" value="<%= item_name %>"/><br/>
Price:<input type="text" name="item_price" value="<%= item_price %>"><br/>
<textarea name="item_description"><%= item_description %></textarea><br/>
<input type="submit" value="Add item to database"/>
</form>
</body>
</html>