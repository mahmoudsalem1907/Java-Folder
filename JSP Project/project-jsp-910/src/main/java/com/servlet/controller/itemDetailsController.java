package com.servlet.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.servlet.model.ItemDetails;
import com.servlet.service.impl.ItemDetailsService;
import com.servlet.service.impl.ItemDetailsServiceImpl;

/**
 * Servlet implementation class itemDetailsController
 */
@WebServlet("/itemDetailsController")
public class itemDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name = "jdbc/item")
	private DataSource dataSource;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public itemDetailsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (Objects.isNull(action)) {
			action = "main-page";

		}
//		System.out.print(action);
//		if(action.equals("logout")) {
//	        logout(request, response);
//	        return;
//	    }

		switch (action) {
		case "add-details-page": {
			addItemDetails(request, response);
			break;
		}
		case "update-item-details": {
			updateItemDetails(request, response);
			break;
		}
		case "save-item-details": {
			saveItemDetailsForm(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + action);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private void updateItemDetails(HttpServletRequest request, HttpServletResponse response) 
		// TODO Auto-generated method stub
		throws IOException, ServletException {

			if (!checkAccountInSession(request, response)) {
				return;
			}
			
			try {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				ItemDetails itemDetails = new ItemDetails();

				itemDetails.setItemId(Integer.parseInt(request.getParameter("itemId")));

				itemDetails.setDescription(request.getParameter("description"));

				itemDetails.setCategory(request.getParameter("category"));

				itemDetails.setBrand(request.getParameter("brand"));

				itemDetails.setColor(request.getParameter("color"));

				itemDetails.setWeight(Double.parseDouble(request.getParameter("weight")));

				itemDetails.setImagePath(request.getParameter("imagePath"));
	//
//				itemDetails.setManufactureDate(sdf.parse(request.getParameter("manufactureDate")));
	//
//				itemDetails.setExpiryDate(sdf.parse(request.getParameter("expiryDate")));
				
				itemDetails.setManufactureDate(
					    java.sql.Date.valueOf(
					        request.getParameter("manufactureDate")
					    )
					);

					itemDetails.setExpiryDate(
					    java.sql.Date.valueOf(
					        request.getParameter("expiryDate")
					    )
					);

				itemDetails.setStatus(request.getParameter("status"));

				ItemDetailsService itemDetailsService = new ItemDetailsServiceImpl(dataSource);

				boolean checkAdded = itemDetailsService.updateItemDetails(itemDetails);

				if (checkAdded) {

					response.sendRedirect(
							"/project-jsp-910/itemController?action=item-details&id=" + itemDetails.getItemId());

					return;
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

			request.getRequestDispatcher("/errorPage.html").forward(request, response);
		
	}

	private void saveItemDetailsForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (!checkAccountInSession(request, response)) {
			return;
		}

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			ItemDetails itemDetails = new ItemDetails();

			itemDetails.setItemId(Integer.parseInt(request.getParameter("itemId")));

			itemDetails.setDescription(request.getParameter("description"));

			itemDetails.setCategory(request.getParameter("category"));

			itemDetails.setBrand(request.getParameter("brand"));

			itemDetails.setColor(request.getParameter("color"));

			itemDetails.setWeight(Double.parseDouble(request.getParameter("weight")));

			itemDetails.setImagePath(request.getParameter("imagePath"));
//
//			itemDetails.setManufactureDate(sdf.parse(request.getParameter("manufactureDate")));
//
//			itemDetails.setExpiryDate(sdf.parse(request.getParameter("expiryDate")));
			
			itemDetails.setManufactureDate(
				    java.sql.Date.valueOf(
				        request.getParameter("manufactureDate")
				    )
				);

				itemDetails.setExpiryDate(
				    java.sql.Date.valueOf(
				        request.getParameter("expiryDate")
				    )
				);

			itemDetails.setStatus(request.getParameter("status"));

			ItemDetailsService itemDetailsService = new ItemDetailsServiceImpl(dataSource);

			boolean checkAdded = itemDetailsService.saveItemDetails(itemDetails);

			if (checkAdded) {

				response.sendRedirect(
						"/project-jsp-910/itemController?action=item-details&id=" + itemDetails.getItemId());

				return;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		request.getRequestDispatcher("/errorPage.html").forward(request, response);
	}

	private boolean checkAccountInSession(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession(false);

		if (session == null) {
			response.sendRedirect("accountController?action=login-page");
			return false;
		}

		Object user = session.getAttribute("loggedUser");

		if (user == null) {

			session.invalidate();

			response.sendRedirect("accountController?action=login-page");

			return false;
		}

		return true;
	}

	private void addItemDetails(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (!checkAccountInSession(request, response)) {
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		ItemDetailsService itemDeatils = new ItemDetailsServiceImpl(dataSource);
		System.out.println(itemDeatils);
		request.setAttribute("itemDetails", itemDeatils.getItemDetailsByItemId(id));
		request.getRequestDispatcher("/add-details-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
