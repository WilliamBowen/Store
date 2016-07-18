<%@ page import="java.util.*, wb.store.model.Item" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
Item item = (Item)request.getAttribute("item");
String item_id = String.valueOf(item.getId());
String item_price = String.valueOf(item.getPrice());
String item_name = item.getName();
String item_description = item.getDescription();


%>
<form action="deleteItem" method="POST">
Are you sure you want to delete this item?<br/>
<input type="hidden" name="item_id" value="<%= item_id %>"/>
<input type="hidden" name="item_name" value="<%= item_name %>"/>
<input type="hidden" name="item_price" value="<%= item_price %>"/>
<input type="hidden" name="item_description" value="<%= item_description %>"/>
Name: <%= item_name %><br/>
Price: <%= item_price %><br/>
<%= item_description %><br/>
<input type="submit" value="Confirm delete"/>
</form>
</body>
</html>
