package com.traineemgt.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.traineemgt.model.dao.user.User;
import com.traineemgt.model.dao.user.UserDao;
import com.traineemgt.model.dao.user.UserDaoImpl;
import com.traineemgt.model.exceptions.UserNotFoundException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDaoImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = userDao.getUser(username, password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("TraineeController.do?action=showall");

		} catch (UserNotFoundException ex) {
			response.sendRedirect("login.jsp?message=login failed");
		}
	}

}
