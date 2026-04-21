<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String fullName = request.getParameter("fullName");
Integer age = Integer.parseInt(request.getParameter("age"));

%>


<h2>My Name is <%= fullName%> ,  and My Age <%= age %></h2>
</body>
</html>