<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.servlet.model.Item" %>
<%@ page import="com.servlet.model.ItemDetails" %>

<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);

if(session.getAttribute("loggedUser") == null){
    response.sendRedirect("accountController?action=login-page");
    return;
}

Item item = (Item) request.getAttribute("itemDetails");
ItemDetails details = (item != null) ? item.getItemDetails() : null;

boolean hasDetails = (details != null && details.getDetailId() > 0);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Details</title>

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

/* Container */
.container{
    width:100%;
    max-width:1000px;
    background:#2F354B;
    border-radius:22px;
    overflow:hidden;
    box-shadow:0 15px 40px rgba(0,0,0,0.45);
    animation:fadeIn 0.7s ease;
}

/* Top Bar */
.top-bar{
    position:relative;
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:20px 30px;
    background:#283041;
}

/* Center Title */
.page-title{
    position:absolute;
    left:50%;
    transform:translateX(-50%);
    font-size:28px;
    color:#D6DCE5;
}

/* Back Button */
.back-btn{
    text-decoration:none;
    background:#4A6072;
    color:white;
    padding:12px 24px;
    border-radius:40px;
    font-weight:bold;
    transition:0.3s ease;
}

.back-btn:hover{
    background:#6F8598;
    transform:translateY(-3px);
}

/* Content */
.content{
    display:flex;
    gap:40px;
    padding:35px;
}

/* Image */
.image-section{
    flex:1;
    display:flex;
    justify-content:center;
}

.image-section img{
    width:100%;
    max-width:350px;
    border-radius:18px;
    object-fit:cover;
    border:2px solid #4A6072;
}

/* Details */
.details-section{
    flex:1.4;
}

.item-name{
    font-size:34px;
    margin-bottom:10px;
}

.price{
    font-size:24px;
    color:#9FC3E0;
    margin-bottom:25px;
}

.description{
    color:#D6DCE5;
    margin-bottom:25px;
    line-height:1.7;
}

/* Info Grid */
.info-grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:18px;
}

.info-card{
    background:#283041;
    padding:18px;
    border-radius:16px;
}

.label{
    color:#9CA3AF;
    font-size:13px;
}

.value{
    color:white;
    font-weight:bold;
    margin-top:6px;
}

/* Status */
.status{
    margin-top:25px;
    background:#4A6072;
    padding:12px 22px;
    border-radius:40px;
    display:inline-block;
}

/* Add / Update Button */
.add-details-btn{
    display:block;
    width:100%;
    text-align:center;
    text-decoration:none;
    color:white;
    padding:16px 28px;
    border-radius:40px;
    font-weight:bold;
    transition:0.3s ease;
    box-shadow:0 8px 18px rgba(0,0,0,0.25);
    margin-top:30px;
}

.add-details-btn:hover{
    transform:translateY(-3px);
}

.add{
    background:#4CAF50;
}

.add:hover{
    background:#5FD16B;
}

.update{
    background:#ff9800;
}

.update:hover{
    background:#ffb74d;
}

/* Empty */
.empty-state{
    text-align:center;
    padding:80px 20px;
}

/* Animation */
@keyframes fadeIn{
    from{opacity:0; transform:translateY(20px);}
    to{opacity:1; transform:translateY(0);}
}

/* Responsive */
@media(max-width:768px){
    .content{
        flex-direction:column;
    }

    .page-title{
        font-size:22px;
    }
}

</style>

</head>

<body>

<div class="container">

    <!-- TOP BAR -->
    <div class="top-bar">

        <a href="/project-jsp-910/itemController?action=main-page"
           class="back-btn">
            ← Back
        </a>

        <h1 class="page-title">Product Details</h1>

        <div style="width:120px;"></div>

    </div>

    <!-- CONTENT -->
    <div class="content">

    <%
    if(item != null && item.getItemDetails() != null && hasDetails){
    %>

        <!-- FULL DETAILS -->
        <div class="image-section">
            <img src="<%= details.getImagePath() %>">
        </div>

        <div class="details-section">

            <h2 class="item-name"><%= item.getName() %></h2>

            <div class="price">$ <%= item.getPrice() %></div>

            <div class="description">
                <%= details.getDescription() %>
            </div>

            <div class="info-grid">

                <div class="info-card">
                    <div class="label">Category</div>
                    <div class="value"><%= details.getCategory() %></div>
                </div>

                <div class="info-card">
                    <div class="label">Brand</div>
                    <div class="value"><%= details.getBrand() %></div>
                </div>

                <div class="info-card">
                    <div class="label">Color</div>
                    <div class="value"><%= details.getColor() %></div>
                </div>

                <div class="info-card">
                    <div class="label">Weight</div>
                    <div class="value"><%= details.getWeight() %> KG</div>
                </div>

                <div class="info-card">
                    <div class="label">Manufacture Date</div>
                    <div class="value"><%= details.getManufactureDate() %></div>
                </div>

                <div class="info-card">
                    <div class="label">Expiry Date</div>
                    <div class="value"><%= details.getExpiryDate() %></div>
                </div>

            </div>

            <div class="status">
                Status: <%= details.getStatus() %>
            </div>

            <!-- UPDATE BUTTON -->
            <a class="add-details-btn update"
               href="/project-jsp-910/itemDetailsController?action=add-details-page&id=<%= item.getId() %>&update=true">

                ✏ Update Details

            </a>

        </div>

    <%
    } else if(item != null){
    %>

        <!-- BASIC VIEW -->
        <div class="details-section" style="width:100%">

            <h2 class="item-name"><%= item.getName() %></h2>

            <div class="price">$ <%= item.getPrice() %></div>

            <div class="description">
                No extra details available for this item.
            </div>

            <div class="info-grid">

                <div class="info-card">
                    <div class="label">Total Items</div>
                    <div class="value"><%= item.getTotalNumberOfItems() %></div>
                </div>

            </div>

            <!-- ADD BUTTON -->
            <a class="add-details-btn add"
               href="/project-jsp-910/itemDetailsController?action=add-details-page&id=<%= item.getId() %>">

                + Add Details

            </a>

        </div>

    <%
    } else {
    %>

        <div class="empty-state">
            <h2>No Item Found</h2>
        </div>

    <%
    }
    %>

    </div>

</div>

</body>
</html>