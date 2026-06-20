<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.servlet.model.Item" %>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if(session.getAttribute("loggedUser") == null){
    response.sendRedirect("accountController?action=login-page");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Product Dashboard</title>

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

/* Main Container */
.container{
    width:95%;
    max-width:1200px;
    background:#2F354B;
    padding:35px;
    border-radius:20px;
    box-shadow:0 15px 40px rgba(0,0,0,0.45);
    animation:fadeIn 0.7s ease;
}

/* Top Bar */
.top-bar{
    display:flex;
    justify-content:flex-end;
    margin-bottom:20px;
}

/* Logout Button */
.logout-btn{
    text-decoration:none;
    background:#2F354B;
    border:1px solid #6F8598;
    color:#D6DCE5;
    padding:12px 24px;
    border-radius:40px;
    font-weight:bold;
    transition:0.3s ease;
    letter-spacing:1px;
    display:inline-block;
}

.logout-btn:hover{
    background:#ef4444;
    color:white;
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(239,68,68,0.35);
}

/* Title */
.title{
    text-align:center;
    font-size:38px;
    margin-bottom:30px;
    color:#D6DCE5;
    letter-spacing:1px;
}

/* Table */
table{
    width:100%;
    border-collapse:collapse;
    overflow:hidden;
    border-radius:14px;
}

/* Table Header */
thead{
    background:#4A6072;
}

thead th{
    padding:18px;
    font-size:14px;
    text-transform:uppercase;
    color:white;
    letter-spacing:1px;
}

/* Table Rows */
tbody tr{
    transition:0.3s ease;
    border-bottom:1px solid rgba(255,255,255,0.05);
}

tbody tr:nth-child(even){
    background:#283041;
}

tbody tr:hover{
    background:#364459;
    transform:scale(1.01);
}

/* Table Cells */
tbody td{
    padding:18px;
    text-align:center;
    color:#D6DCE5;
}

/* Price */
.price{
    color:#9FC3E0;
    font-weight:bold;
    font-size:15px;
}

/* Actions */
.actions{
    display:flex;
    justify-content:center;
    gap:12px;
}

/* Buttons */
.actions a{
    width:40px;
    height:40px;
    display:flex;
    justify-content:center;
    align-items:center;
    border-radius:12px;
    text-decoration:none;
    font-size:17px;
    transition:0.3s ease;
}

/* Update Button */
.update-btn{
    background:#4A6072;
    color:white;
}

.update-btn:hover{
    background:#6F8598;
    transform:translateY(-3px);
    box-shadow:0 8px 20px rgba(111,133,152,0.4);
}

/* Delete Button */
.delete-btn{
    background:#2F354B;
    border:1px solid #6F8598;
    color:#D6DCE5;
}

.delete-btn:hover{
    background:#ef4444;
    color:white;
    transform:translateY(-3px);
}

/* Add Button */
.add-btn{
    text-align:center;
    margin-top:30px;
}

.add-btn a{
    text-decoration:none;
    background:#4A6072;
    color:white;
    padding:14px 35px;
    border-radius:40px;
    font-weight:bold;
    display:inline-block;
    transition:0.3s;
    letter-spacing:1px;
}

.add-btn a:hover{
    background:#6F8598;
    transform:translateY(-4px);
    box-shadow:0 10px 25px rgba(111,133,152,0.4);
}

/* TITLE spacing */
.title{
    text-align:center;
    font-size:38px;
    margin-bottom:25px;
    color:#D6DCE5;
}

/* SEARCH SECTION (full width under title) */
.search-section{
    width:100%;
    display:flex;
    justify-content:center;
    margin-bottom:25px;
}

/* FULL WIDTH SEARCH */
.search-box{
    width:100%;
    max-width:1200px; /* نفس عرض الكونتينر */
}

/* SEARCH WRAPPER FULL WIDTH */
.search-wrapper {
    display: flex;
    align-items: center;
    width: 100%;
    background: #1E2533;
    border: 1px solid #6F8598;
    border-radius: 50px;
    overflow: hidden;
    transition: 0.3s ease;
}

/* focus effect */
.search-wrapper:focus-within {
    border-color: #4A6072;
    box-shadow: 0 0 0 3px rgba(74, 96, 114, 0.3);
}

/* INPUT */
.search-input{
    flex: 1;
    padding: 14px 18px;
    border: none;
    outline: none;
    background: transparent;
    color: #ffffff;   /* 👈 typed text WHITE */
    font-size: 15px;
}

/* placeholder color */
.search-input::placeholder{
    color:#9aa7b2;
}

/* BUTTON */
.search-btn{
    text-decoration:none;
    background:#2F354B;
    border:1px solid #6F8598;
    color:#D6DCE5;
    padding:12px 24px;
    border-radius:40px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s ease;
    letter-spacing:1px;
    white-space:nowrap;
}

.search-btn:hover{
    background:#4A6072;
    color:white;
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(111,133,152,0.35);
}

/* when typing inside search */
.search-wrapper:focus-within{
    background:#ffffff;
    border-color:#4A6072;
    box-shadow:0 0 0 3px rgba(74,96,114,0.3);
}

/* input text color when active */
.search-wrapper:focus-within .search-input{
    color:#1E2533;   /* dark text on white bg */
}

/* placeholder when active */
.search-wrapper:focus-within .search-input::placeholder{
    color:#6b7280;
}

/* keep button visible on white background */
.search-wrapper:focus-within .search-btn{
    background:#4A6072;
    color:white;
}

/* Empty Data */
.no-data{
    text-align:center;
    padding:30px;
    font-size:18px;
    color:#9CA3AF;
}

/* SEARCH BAR */
.search-bar{
    width:100%;
    margin-bottom:30px;
}

/* FORM */
.search-bar form{
    display:flex;
    align-items:center;
    gap:12px;
}

/* INPUT */
.search-bar input{
    flex:1;
    padding:14px 18px;
    border:none;
    border-radius:40px;
    background:#1E2533;
    color:white;
    outline:none;
    border:1px solid #4A6072;
    transition:0.3s ease;
    font-size:15px;
}

/* PLACEHOLDER */
.search-bar input::placeholder{
    color:#9CA3AF;
}

/* INPUT FOCUS */
.search-bar input:focus{
    border-color:#6F8598;
    box-shadow:0 0 10px rgba(111,133,152,0.3);
    background:white;
    color:#1E2533;
}

/* SEARCH BUTTON */
.search-btn{
    padding:14px 24px;
    border:none;
    border-radius:40px;
    background:#4A6072;
    color:white;
    font-size:15px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s ease;
    white-space:nowrap;
}

/* BUTTON HOVER */
.search-btn:hover{
    background:#6F8598;
    transform:translateY(-3px);
    box-shadow:0 10px 25px rgba(111,133,152,0.4);
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
        padding:20px;
    }

    .title{
        font-size:28px;
    }

    table{
        display:block;
        overflow-x:auto;
    }

    thead th,
    tbody td{
        padding:12px;
        font-size:13px;
    }

    .actions{
        flex-direction:column;
        align-items:center;
    }
    
    
    
}

</style>

</head>

<body>

<div class="container">

    <!-- Logout -->
    <div class="top-bar">

        <a href="/project-jsp-910/itemController?action=logout"
           class="logout-btn">

            Logout

        </a>

    </div>

   <!-- TITLE -->
	<h1 class="title">Product Dashboard</h1>

<!-- SEARCH FULL WIDTH -->
		<!-- Search Bar -->
	<div class="search-bar">
	
	    <form action="itemController" method="get">
	
	        <input type="hidden"
	               name="action"
	               value="search-item"/>
	
	        <input type="text"
	               name="keyword"
	               placeholder="Search item by name..."
	               class="search-input"/>
	
	        <button type="submit"
	                class="search-btn">
	
	            🔍 Search
	
	        </button>
	
	    </form>
	
	</div>

    <table>

        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Total Items</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>

        <%
            List<Item> items =
                (List<Item>) request.getAttribute("allData");

            if(items != null && !items.isEmpty()){

                for(Item item : items){
        %>

            <tr>

                <td>
                    <%= item.getId() %>
                </td>

                <td>
                    <%= item.getName() %>
                </td>

                <td class="price">
                    $ <%= item.getPrice() %>
                </td>

                <td>
                    <%= item.getTotalNumberOfItems() %>
                </td>

                <td>

                    <div class="actions">
                    	<!-- details -->
                        <a href="/project-jsp-910/itemController?action=item_details&id=<%= item.getId() %>"
                           class="update-btn"
                           title="Details">

                            👁️

                        </a>

                        <!-- Update -->
                        <a href="/project-jsp-910/itemController?action=update-item&id=<%= item.getId() %>"
                           class="update-btn"
                           title="Update">

                            ✏️

                        </a>

                        <!-- Delete -->
                        <a href="/project-jsp-910/itemController?action=delete-item&id=<%= item.getId() %>"
                           class="delete-btn"
                           title="Delete">

                            🗑️

                        </a>

                    </div>

                </td>

            </tr>

        <%
                }

            } else {
        %>

            <tr>

                <td colspan="5" class="no-data">

                    No Items Available

                </td>

            </tr>

        <%
            }
        %>

        </tbody>

    </table>

    <div class="add-btn">

        <a href="/project-jsp-910/itemController?action=add-item">

            + Add Item

        </a>

    </div>

</div>

</body>
</html>