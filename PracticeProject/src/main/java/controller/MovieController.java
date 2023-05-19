package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MovieService;

@WebServlet("/movielink")
public class MovieController extends HttpServlet {

	Connection con=null;
@Override
public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
	String movieName=req.getParameter("movie");
	String tickets=req.getParameter("ticket");
	int ticket=Integer.parseInt(tickets);
	
	MovieService ms=new MovieService();
	

		
		try {
			double totalAmt = ms.calculateBill(movieName,ticket,con);
			
			
			req.setAttribute("count", totalAmt);
			
			RequestDispatcher rd=req.getRequestDispatcher("movie.jsp");
			rd.include(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
}



