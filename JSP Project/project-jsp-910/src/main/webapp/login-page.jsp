<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Login</title>

<style>

/* Reset */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

/* Body */
body{
    background:#1E2533;
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:30px;
    color:white;
}

/* Login Card */
.container{
    width:100%;
    max-width:450px;
    background:#2F354B;
    padding:40px;
    border-radius:20px;
    box-shadow:0 15px 40px rgba(0,0,0,0.45);
    animation:fadeIn 0.7s ease;
}

/* Title */
.title{
    text-align:center;
    font-size:34px;
    margin-bottom:10px;
    color:#D6DCE5;
    letter-spacing:1px;
}

/* Subtitle */
.subtitle{
    text-align:center;
    color:#9CA3AF;
    margin-bottom:30px;
    font-size:14px;
}

/* Label */
label{
    display:block;
    margin-bottom:8px;
    margin-top:15px;
    color:#D6DCE5;
    font-size:14px;
}

/* Inputs */
input{
    width:100%;
    padding:14px;
    border:none;
    border-radius:12px;
    background:#1E2533;
    color:white;
    outline:none;
    border:1px solid #4A6072;
    transition:0.3s ease;
}

input:focus{
    border-color:#6F8598;
    box-shadow:0 0 10px rgba(111,133,152,0.3);
}

/* Button */
button{
    width:100%;
    padding:14px;
    margin-top:30px;
    border:none;
    border-radius:40px;
    background:#4A6072;
    color:white;
    font-size:16px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s ease;
    letter-spacing:1px;
}

button:hover{
    background:#6F8598;
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(111,133,152,0.4);
}

/* Error Message */
.error-message{
    background:#ef4444;
    color:white;
    padding:12px;
    border-radius:10px;
    margin-bottom:20px;
    text-align:center;
    font-size:14px;
}

/* Footer */
.footer{
    margin-top:25px;
    text-align:center;
    color:#9CA3AF;
    font-size:14px;
}

.footer a{
    color:#9FC3E0;
    text-decoration:none;
}

.footer a:hover{
    color:white;
}

/* Animation */
@keyframes fadeIn{
    from{
        opacity:0;
        transform:translateY(20px);
    }

    to{
        opacity:1;
        transform:translateY(0);
    }
}

/* Responsive */
@media(max-width:768px){

    .container{
        padding:25px;
    }

    .title{
        font-size:28px;
    }
}

</style>

</head>

<body>

<div class="container">

    <h1 class="title">
        Login
    </h1>

    <p class="subtitle">
        Welcome Back
    </p>

    <%
        if(error != null){
    %>

        <div class="error-message">
            <%= error %>
        </div>

    <%
        }
    %>

    <form action="accountController" method="post">

        <input type="hidden"
               name="action"
               value="login"/>

        <label>
            Username
        </label>

        <input type="text"
               name="username"
               placeholder="Enter username"
               required/>

        <label>
            Password
        </label>

        <input type="password"
               name="password"
               placeholder="Enter password"
               required/>

        <button type="submit">
            Login
        </button>

    </form>

    <div class="footer">

        Don't have an account?

        <a href="register-page.jsp">
            Register
        </a>

    </div>

</div>

</body>
</html>