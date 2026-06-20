package com.servlet.controller;

import java.io.IOException;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.servlet.model.Account;
import com.servlet.service.impl.AccountService;
import com.servlet.service.impl.AccountServiceImpl;

@WebServlet("/accountController")
public class accountController extends HttpServlet {

	@Resource(name = "jdbc/item")
	private DataSource dataSource;
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public accountController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if (Objects.isNull(action)) {
			action = "login-page";

		}
		System.out.print(action);
		switch (action) {
		case "login-page": {
			mainLoginPage(request, response);
			break;
		}
		case "register": {
			registerPage(request, response);
			break;
		}
		case "login": {
			checkLogin(request, response);
			break;
		}
		default:
			mainLoginPage(request, response);
		}

	}

	private void registerPage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String email = request.getParameter("email");
		String passWord = request.getParameter("password");

		AccountService accountService = new AccountServiceImpl(dataSource);
		Account account = new Account(userName, email, passWord);
		boolean checkAccountCreated = accountService.register(account);
		if (checkAccountCreated) {
			
			Account accountData = accountService.getAccountByUsername(userName, passWord);
			
			if (accountData != null) {

				HttpSession session = request.getSession();

				session.setAttribute("loggedUser", accountData);

				response.sendRedirect("itemController?action=main-page");

				return;
			}
		}
		request.getRequestDispatcher("/errorPage.html").forward(request, response);

	}

	private void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");

		String passWord = request.getParameter("password");

		AccountService accountService = new AccountServiceImpl(dataSource);

		Account account = accountService.login(userName, passWord);

		if (account != null) {

			HttpSession session = request.getSession();

			session.setAttribute("loggedUser", account);

			response.sendRedirect("itemController?action=main-page");

			return;
		}

		request.setAttribute("error", "Invalid Username Or Password");

		request.getRequestDispatcher("/login-page.jsp").forward(request, response);
	}

	private void mainLoginPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/login-page.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
