package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.Users;

@WebServlet("/userlogin")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAO(DBConnect.getConn());

		Users user = dao.getLogin(userName, password);
		HttpSession session = req.getSession();
		if (user != null) {

			session.setAttribute("user", user);
			resp.sendRedirect("index.jsp");
		} else {
			session.setAttribute("invalidMsg", "Invalid Email And Password");
			resp.sendRedirect("login.jsp");
		}

	}

}
