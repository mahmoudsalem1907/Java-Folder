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
String places = "No Places";
Cookie[] cookies = request.getCookies();


if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("fav_place".equals(cookie.getName())) {
            out.print("<h2>Place from Cookie: " + cookie.getValue() + "</h2>");
        }
    }
} else {
    out.print("<h2>No Cookies Found</h2>");
}

%>
</body>
</html>