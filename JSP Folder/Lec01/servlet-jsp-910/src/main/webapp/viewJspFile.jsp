<%@page import="com.servlet.model.Item"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>
Salem</h3>


<%

out.print("Current Time: " + new java.util.Date());

%>
<%! String namse = "mahmoud"; %>

<% String name = "mahmoud" ;%>

<p>
My name is <%= name %>
My namse is <%= namse%>
</p>




<h1>Items List</h1>

<table>
    <tr>
        <th>#</th>
        <th>ID</th>
        <th>Name</th>
        <th>Grade</th>
    </tr>

<%!
	public String toUpperCase(String value){
		return value.toUpperCase();
	}
	List<Item> items2 = Item.getItems();
%>
<%
    for(int i = 0; i < items2.size(); i++){
%>
    <tr>
        <td><%= (i + 1) %></td>
        <td><%= items2.get(i).getId() %></td>
        <td><%= toUpperCase(items2.get(i).getName()) %></td>
        <td><%= items2.get(i).getPrice() %></td>
    </tr>
<%
    }
%>

</table>
</body>
</html>