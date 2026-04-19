<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form Data</title>
<style>
body {
    font-family: Arial;
    background-color: #f4f4f4;
}

.container {
    width: 90%;
    max-width: 500px;
    margin: 50px auto;
    background: white;
    padding: 20px 25px;
    border-radius: 10px;
    box-shadow: 0 0 10px #ccc;
}


.data:hover {
    background-color: #007BFF;  /* dark blue */
    color: white;              /* عشان الكلام يبان */
    cursor: pointer;
}

h2 {
    text-align: center;
    margin-bottom: 20px;
}

.data {
    margin: 10px 0;
    padding: 10px;
    background: #f9f9f9;
    border-radius: 5px;
    border-left: 5px solid #007BFF;
}

.label {
    font-weight: bold;
}
</style>

</head>
<body>

<div class="container">

<h2>Form Data</h2>

<%
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String password = request.getParameter("password");
    String age = request.getParameter("age");
    String addressRadio = request.getParameter("addressRadio");
    String addressSelect = request.getParameter("addressSelect");
%>

<div class="data">
    <span class="label">First Name:</span> <%= fname %>
</div>

<div class="data">
    <span class="label">Last Name:</span> <%= lname %>
</div>

<div class="data">
    <span class="label">Age:</span> <%= age %>
</div>

<div class="data">
    <span class="label">Radio Address:</span> <%= addressRadio %>
</div>

<div class="data">
    <span class="label">Select Address:</span> <%= addressSelect %>
</div>

</div>

</body>
</html>