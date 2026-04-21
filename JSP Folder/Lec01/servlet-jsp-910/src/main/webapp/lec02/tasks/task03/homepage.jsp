<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>Fav Places</h2>
<%
String place = request.getParameter("place");
Cookie cookies = new Cookie("fav_place", place );

cookies.setMaxAge(60*60*24);
response.addCookie(cookies);


%>
<h1>language saved</h1>
<a href="main-page.jsp">main page</a>

</body>
</html>