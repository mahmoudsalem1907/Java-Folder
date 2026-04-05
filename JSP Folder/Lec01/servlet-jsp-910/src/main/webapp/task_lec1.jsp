<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Task Lec 1</h1>


<%!

String name = "Salem";
Integer id =0; 

public String combineFun(Integer id , String name){
	String res = "ID : " + id + " And His Name : "+ name;
	return res;
}

%>

<h2>Result is <%= combineFun(id,name) %></h2>
<h2>Result_2 is <%= combineFun(10,"Mahmoud") %></h2>

</body>
</html>