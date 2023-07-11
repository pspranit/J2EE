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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("username");
		String contact=req.getParameter("contact");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String password=req.getParameter("password");
		
		Users user=new Users(name, contact, address, email, gender, password);
		
		UserDAO dao=new UserDAO(DBConnect.getConn());
		
		boolean status=dao.getRegister(user);
		
		HttpSession session=req.getSession();
		
		if(status)
		{
			session.setAttribute("successMsg", "REGISTRATION SUCCESS !!");
			resp.sendRedirect("register.jsp");
		}
		else {
			session.setAttribute("errorMsg", "SOMETHING ERROR ON SERVER !!");
			resp.sendRedirect("register.jsp");
		}
		
		
	}

}
