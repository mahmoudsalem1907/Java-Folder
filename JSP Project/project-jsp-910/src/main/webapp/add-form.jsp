<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.servlet.model.Item"%>

<%
// ✅ Security check FIRST before anything else
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if(session.getAttribute("loggedUser") == null){
    response.sendRedirect("accountController?action=login-page");
    return;
}

// ✅ Then read attributes safely
Boolean toUpdate = (Boolean) request.getAttribute("ToUpdate");
Item item = (Item) request.getAttribute("item");
boolean isUpdate = (toUpdate != null && toUpdate);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=isUpdate ? "Update Item" : "Add Item"%></title>

<style> 
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, sans-serif;
}

body {
	background: #1E2533;
	min-height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 30px;
	color: white;
} /* Card Container */
.container {
	width: 100%;
	max-width: 500px;
	background: #2F354B;
	padding: 35px;
	border-radius: 20px;
	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.45);
	animation: fadeIn 0.7s ease;
} /* Title */
.title {
	text-align: center;
	font-size: 30px;
	margin-bottom: 25px;
	color: #D6DCE5;
} /* Input fields */
input {
	width: 100%;
	padding: 14px;
	margin: 10px 0;
	border: none;
	border-radius: 12px;
	background: #1E2533;
	color: white;
	outline: none;
	border: 1px solid #4A6072;
	transition: 0.3s;
}

input:focus {
	border-color: #6F8598;
	box-shadow: 0 0 10px rgba(111, 133, 152, 0.3);
} /* Label */
label {
	font-size: 14px;
	color: #D6DCE5;
	margin-top: 10px;
	display: block;
} /* Button */
button {
	width: 100%;
	padding: 14px;
	margin-top: 20px;
	border: none;
	border-radius: 40px;
	background: #4A6072;
	color: white;
	font-weight: bold;
	font-size: 16px;
	cursor: pointer;
	transition: 0.3s;
	letter-spacing: 1px;
}

button:hover {
	background: #6F8598;
	transform: translateY(-3px);
	box-shadow: 0 10px 25px rgba(111, 133, 152, 0.4);
} /* Back button */
.back {
	text-align: center;
	margin-top: 20px;
}

.back a {
	color: #9FC3E0;
	text-decoration: none;
}

.back a:hover {
	color: white;
} /* Animation */
@
keyframes fadeIn {from { opacity:0;
	transform: translateY(20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>

</head>

<body>

	<div class="container">

		<h2 class="title">
			<%=isUpdate ? "Update Item" : "Add New Item"%>
		</h2>

		<form action="itemController" method="post">

			<input type="hidden" name="action"
				value="<%=isUpdate ? "update-item-form" : "add-item-form"%>" />

			<%
			if (isUpdate) {
			%>
			<input type="hidden" name="id" value="<%=item.getId()%>" />
			<%
			}
			%>

			<label>Name</label> <input type="text" name="name"
				value="<%=isUpdate ? item.getName() : ""%>" required /> <label>Price</label>
			<input type="number" step="0.01" name="price"
				value="<%=isUpdate ? item.getPrice() : ""%>" required /> <label>Total
				Number</label> <input type="number" name="totalNumber"
				value="<%=isUpdate ? item.getTotalNumberOfItems() : ""%>" required />

			<button type="submit">
				<%=isUpdate ? "Update Item" : "Add Item"%>
			</button>

		</form>

		<div class="back">
			<a href="itemController?action=main-page">← Back to Dashboard</a>
		</div>

	</div>

</body>
</html>