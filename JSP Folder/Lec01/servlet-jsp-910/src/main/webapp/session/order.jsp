<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");
	String order = request.getParameter("order");
	List<String> orderFromSession = (List<String>)session.getAttribute("myOrders");
	if(orderFromSession == null){
		orderFromSession = new ArrayList<String>();
		session.setAttribute("myOrders", orderFromSession);
	}
	if (order != null && !order.isEmpty()){
		orderFromSession.add(order);
	}
	
	
	if(orderFromSession == null || orderFromSession.isEmpty()){
		out.print("<h2>NO ORDER HERE</h2>");
	}else {
	
	
	for(String o : orderFromSession){
%> 		<h1>ORDER IS <%= o %></h1>
<%
	}}
%>

</body>
</html>