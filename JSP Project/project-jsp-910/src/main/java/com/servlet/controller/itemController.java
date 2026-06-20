package com.servlet.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.websocket.Session;

import com.servlet.model.Item;
import com.servlet.service.impl.ItemDetailsService;
import com.servlet.service.impl.ItemDetailsServiceImpl;
import com.servlet.service.impl.ItemService;
import com.servlet.service.impl.ItemServiceImpl;


@WebServlet("/itemController")
public class itemController extends HttpServlet {

	
	@Resource(name = "jdbc/item")
	private DataSource dataSource; 
	private ItemService itemService;
	private static final long serialVersionUID = 1L;
	public void init() {
	    itemService = new ItemServiceImpl(dataSource);
	}
 
    public itemController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if(!checkAccountInSession(request, response)){
//		    return;
//		}
//		System.out.println("------------------>" + dataSource);
//		Connection con;
//		try {
//			con = dataSource.getConnection();
//			System.out.println("-----------------con ------->"+con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String action = request.getParameter("action");
		if(Objects.isNull(action)) {
			action = "main-page";
			
		}
		System.out.print(action);
		if(action.equals("logout")) {
	        logout(request, response);
	        return;
	    }

	    if(!checkAccountInSession(request, response)){
	        return;
	    }
		switch (action) {
		
			case "delete-item":{
				deleteItem(request, response);
				break;
			}
			case "item_details":{
				ItemDetails(request, response);
				break;
			}
			case "search-item":{
				searchItem(request, response);
				break;
			}
			case "update-item":{
				updateItem(request, response);
				break;
			}
			case "add-item-form":{
				addItemform(request, response);
				break;
			}
			case "update-item-form":{
				updateItemform(request, response);
				break;
			}
			case "add-item":{
				addItem(request, response);
				break;
			}
			case "main-page": {
				mainPageAllItem(request, response);
				break;
				
			}
			default:
		        mainPageAllItem(request, response);
		}
		
	}

	private void ItemDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!checkAccountInSession(request, response)){
	        return;
	    }
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDetailsService itemDeatils = new ItemDetailsServiceImpl(dataSource);
		request.setAttribute("itemDetails", itemDeatils.getItemDetailsByItemId(id));
		request.getRequestDispatcher("/item-details.jsp").forward(request, response);
		
		
	}

	private void searchItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!checkAccountInSession(request, response)){
	        return;
	    }
		List<Item> item = itemService.searchItem(request.getParameter("keyword"));
		request.setAttribute("allData", item);
		request.getRequestDispatcher("/main-page-all-items.jsp").forward(request, response);
		
	}

	private void logout(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

			HttpSession session = request.getSession(false);
			
			if(session != null){
			session.invalidate();
			}
			
			response.sendRedirect(
			"accountController?action=login-page"
			);
		}
	private boolean checkAccountInSession(
	        HttpServletRequest request,
	        HttpServletResponse response) throws IOException {

	    HttpSession session = request.getSession(false);

	    if(session == null){
	        response.sendRedirect(
	            "accountController?action=login-page"
	        );
	        return false;
	    }

	    Object user = session.getAttribute("loggedUser");

	    if(user == null){

	        session.invalidate();

	        response.sendRedirect(
	            "accountController?action=login-page"
	        );

	        return false;
	    }

	    return true;
	}
	
	
	
	private void updateItem(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if(!checkAccountInSession(request, response)){
		    return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("-------------------------------------->"+id);

		request.setAttribute("ToUpdate", true);
//		ItemService itemService = new ItemServiceImpl(dataSource);
		Item item = itemService.getItemByID(id);
		request.setAttribute("item", item);
		request.getRequestDispatcher("/add-form.jsp").forward(request, response);

		
	}
	
	private void updateItemform(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		ItemService itemService = new ItemServiceImpl(dataSource);
//		checkAccountInSession(request, response);
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
		Item item= new Item(id,name,price,totalNumber,null);
		boolean checkupdated = itemService.updateItem(item);
		if(checkupdated) {

	        response.sendRedirect("itemController?action=main-page");
	        return;
	    }

	    request.getRequestDispatcher("/errorPage.html")
	           .forward(request, response);
		

		
	}
	
	
	
	private void addItemform(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
//		ItemService itemService = new ItemServiceImpl(dataSource);
//		checkAccountInSession(request, response);
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		int totalNumber = Integer.parseInt(request.getParameter("totalNumber"));
		Item item= new Item(name,price,totalNumber);
		boolean checkAdded = itemService.addItem(item);
		if(checkAdded) {

	        response.sendRedirect("itemController?action=main-page");
	        return;
	    }

	    request.getRequestDispatcher("/errorPage.html")
	           .forward(request, response);
		

		
	}
	
	private void addItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!checkAccountInSession(request, response)){
		    return;
		}
		request.getRequestDispatcher("/add-form.jsp").forward(request, response);
	}
	
	
	
	private void mainPageAllItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ItemService itemService = new ItemServiceImpl(dataSource);
		HttpSession session = request.getSession(false);
//	    if(session == null ||
//	       session.getAttribute("loggedUser") == null){
//	        response.sendRedirect(
//	            "accountController?action=login-page"
//	        );
//	        return;
//	    }
		System.out.print("session");
		System.out.println(session.getAttribute("loggedUser"));
		
		request.setAttribute("allData", itemService.allItem());
		request.getRequestDispatcher("/main-page-all-items.jsp").forward(request, response);
	}
	
	private void deleteItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ItemService itemService = new ItemServiceImpl(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.print(id);
		boolean check = itemService.deleteItem(id);
		if(check) {

	        response.sendRedirect("itemController?action=main-page");
	        return;
	    }

	    request.getRequestDispatcher("/errorPage.html")
	           .forward(request, response);
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
