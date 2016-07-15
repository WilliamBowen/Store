<%@ page import="java.util.*, wb.store.model.Item" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Items</title>
</head>
<body>
A list of all Items in the items table.<br/><br/>
<% 
ArrayList al = (ArrayList)request.getAttribute("items");
Iterator it = al.iterator();

while(it.hasNext()) {
  Item item = (Item)it.next();
%>
<%= item.getName() %><br/>
<%= item.getDescription() %><br/>
<%= item.getPrice() %><br/>
<br/>

<% } %>
</body>
</html>