package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.Validation;
@WebServlet("/loginlink")
public class LoginController extends HttpServlet{
	Connection con=null;
@Override
public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {

		e.printStackTrace();
	}
	
}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException  {
		
		String user =req.getParameter("username");
		String pass=req.getParameter("password");
		
		
		Validation v1=new Validation();
		
		 
		try {
			boolean status2 = v1.validate(user, pass,con);
			 
			if(status2)
			{
				
				resp.sendRedirect("welcome.jsp");
			}
			else {
				PrintWriter pw=resp.getWriter();
				pw.print("<h1  style='color:red'>INVALID USERNAME AND PASSWORD</h1>");
				RequestDispatcher rd=req.getRequestDispatcher("compare.html");
				rd.include(req, resp);
//				resp.sendRedirect("error.jsp");
				
			}	
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		
	}
}
