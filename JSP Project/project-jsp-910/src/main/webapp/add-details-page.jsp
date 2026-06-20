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

String itemId = request.getParameter("id");
boolean isUpdate = "true".equals(request.getParameter("update"));

Item item = (Item) request.getAttribute("itemDetails");

ItemDetails details = null;

if (item != null) {
    ItemDetails tmp = item.getItemDetails();

    if (tmp != null && tmp.getDetailId() > 0) {
        details = tmp;
    }
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
    <%= isUpdate ? "Update Item Details" : "Add Item Details" %>
</title>

<style>

/* RESET */
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:Arial, sans-serif;
}

/* BODY (OLD STYLE RESTORED) */
body{
    background:#1E2533;
    min-height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    padding:30px;
    color:white;
}

/* CONTAINER (OLD CARD STYLE) */
.container{
    width:100%;
    max-width:900px;
    background:#2F354B;
    border-radius:22px;
    overflow:hidden;
    box-shadow:0 15px 40px rgba(0,0,0,0.45);
    animation:fadeIn 0.7s ease;
}

/* TOP BAR */
.top-bar{
    position:relative;
    display:flex;
    align-items:center;
    padding:20px 30px;
    background:#283041;
}

/* CENTER TITLE */
.page-title{
    position:absolute;
    left:50%;
    transform:translateX(-50%);
    font-size:28px;
    color:#D6DCE5;
}

/* BACK BUTTON */
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

/* FORM */
.form-container{
    padding:40px;
}

.form-grid{
    display:grid;
    grid-template-columns:1fr 1fr;
    gap:22px;
}

.full-width{
    grid-column:1 / 3;
}

/* INPUTS */
.input-group{
    display:flex;
    flex-direction:column;
}

.input-group label{
    margin-bottom:10px;
    color:#D6DCE5;
    font-weight:bold;
}

.input-group input,
.input-group textarea,
.input-group select{
    width:100%;
    padding:14px;
    border:none;
    outline:none;
    border-radius:14px;
    background:#283041;
    color:white;
    font-size:15px;
}

textarea{
    min-height:120px;
    resize:none;
}

/* BUTTON */
.submit-btn{
    width:100%;
    margin-top:30px;
    padding:16px;
    border:none;
    border-radius:40px;
    background:#4CAF50;
    color:white;
    font-size:17px;
    font-weight:bold;
    cursor:pointer;
    transition:0.3s ease;
}

.submit-btn:hover{
    background:#5FD16B;
    transform:translateY(-3px);
}

/* ANIMATION */
@keyframes fadeIn{
    from{opacity:0; transform:translateY(20px);}
    to{opacity:1; transform:translateY(0);}
}

/* RESPONSIVE */
@media(max-width:768px){
    .form-grid{grid-template-columns:1fr;}
    .full-width{grid-column:auto;}
    .page-title{font-size:22px;}
}

</style>

</head>

<body>

<div class="container">

    <!-- TOP BAR -->
    <div class="top-bar">

        <a class="back-btn"
           href="/project-jsp-910/itemController?action=item_details&id=<%= itemId %>">
            ← Back
        </a>

        <h1 class="page-title">
            <%= isUpdate ? "Update Item Details" : "Add Item Details" %>
        </h1>

    </div>

    <!-- FORM -->
    <div class="form-container">

        <form action="/project-jsp-910/itemDetailsController"
              method="post">

            <input type="hidden"
                   name="action"
                   value="<%= isUpdate ? "update-item-details" : "save-item-details" %>"/>

            <input type="hidden"
                   name="itemId"
                   value="<%= itemId %>"/>

            <div class="form-grid">

                <div class="input-group">
                    <label>Category</label>
                    <input type="text" name="category"
                        value="<%= details != null ? details.getCategory() : "" %>" required>
                </div>

                <div class="input-group">
                    <label>Brand</label>
                    <input type="text" name="brand"
                        value="<%= details != null ? details.getBrand() : "" %>" required>
                </div>

                <div class="input-group">
                    <label>Color</label>
                    <input type="text" name="color"
                        value="<%= details != null ? details.getColor() : "" %>" required>
                </div>

                <div class="input-group">
                    <label>Weight (KG)</label>
                    <input type="number" step="0.1" name="weight"
                        value="<%= details != null ? details.getWeight() : "" %>" required>
                </div>

                <div class="input-group">
                    <label>Manufacture Date</label>
                    <input type="date" name="manufactureDate"
                        value="<%= details != null ? details.getManufactureDate() : "" %>" required>
                </div>

                <div class="input-group">
                    <label>Expiry Date</label>
                    <input type="date" name="expiryDate"
                        value="<%= details != null ? details.getExpiryDate() : "" %>" required>
                </div>

                <div class="input-group full-width">
                    <label>Image Path</label>
                    <input type="text" name="imagePath"
                        value="<%= details != null ? details.getImagePath() : "" %>" required>
                </div>

                <div class="input-group full-width">
                    <label>Status</label>

                    <select name="status">
                        <option value="Available"
                            <%= (details != null && "Available".equals(details.getStatus())) ? "selected" : "" %>>
                            Available
                        </option>

                        <option value="Out Of Stock"
                            <%= (details != null && "Out Of Stock".equals(details.getStatus())) ? "selected" : "" %>>
                            Out Of Stock
                        </option>
                    </select>

                </div>

                <div class="input-group full-width">
                    <label>Description</label>
                    <textarea name="description" required><%= details != null ? details.getDescription() : "" %></textarea>
                </div>

            </div>

            <button type="submit" class="submit-btn">
                <%= isUpdate ? "Update Details" : "Save Details" %>
            </button>

        </form>

    </div>

</div>

</body>
</html>