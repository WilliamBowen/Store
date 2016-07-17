<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Item Result</title>
</head>
<body>
<% if (request.getAttribute("id") != null) {%>
	Item was added to database.
<% } else {%>
	Something went wrong!
<% } %>
<br/><a href="display">Click here to see all items in the database</a>
</body>
</html>