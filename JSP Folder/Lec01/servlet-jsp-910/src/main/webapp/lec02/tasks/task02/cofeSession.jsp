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


List<String> cofeOrderSession = (List<String>)session.getAttribute("cofeOrderSession") ;
if(cofeOrderSession == null){
	cofeOrderSession = new ArrayList<>();
	session.setAttribute("cofeOrderSession", cofeOrderSession);
}


String order = request.getParameter("order");
cofeOrderSession.add(order);

for(String cofeOder : cofeOrderSession){

%>
<h2>Order is <%= cofeOder %></h2>
<%
}
%>

</body>
</html>