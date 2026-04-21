<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>
<style>
body {
    font-family: Arial;
    background-color: #f4f4f4;
}

.container {
    margin: 50px auto;
    background: white;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 10px #ccc;
    width: 40%;
}

h2 {
    text-align: center;
}

label {
    font-weight: bold;
}

input, select {
    width: 100%;
    padding: 8px;
    margin: 5px 0 15px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

.radio-group {
    margin-bottom: 15px;
}

.radio-group input {
    width: auto;
}

button {
    width: 100%;
    padding: 10px;
    background-color: #007BFF;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 16px;
}

button:hover {
    background-color: #0056b3;
}
</style>

</head>
<body>

<div class="container">

<h2>Form</h2>

<form action="formResult.jsp" method="get">

    <label>First name:</label>
    <input type="text" name="fname">

    <label>Last name:</label>
    <input type="text" name="lname">

    <label>Password:</label>
    <input type="password" name="password">

    <label>Age:</label>
    <input type="number" name="age">

    <label>Address (Radio):</label>
    <div class="radio-group">
        <input type="radio" name="addressRadio" value="cairo"> Cairo
        <input type="radio" name="addressRadio" value="alexds"> Alex
        <input type="radio" name="addressRadio" value="menofia"> Menofia
    </div>

    <label>Address (Select):</label>
    <select name="addressSelect">
        <option value="cairo">Cairo</option>
        <option value="alex">Alex</option>
        <option value="menofia">Menofia</option>
    </select>

    <button type="submit">Submit</button>

</form>

</div>

</body>
</html>