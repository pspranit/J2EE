package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/displaylink")
public class DisplayBook extends HttpServlet{
	
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pranit","root","sql@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw=resp.getWriter();


		int userId=(int)req.getSession().getAttribute("userid");
		
		BookDisplayService bookDisplayService=new BookDisplayService();
		ArrayList bookList=bookDisplayService.displayBooks(con,resp,req,userId);
		
		int count=bookDisplayService.getCount();		
		
		req.setAttribute("bookList", bookList);
		req.setAttribute("count", count);

		

		RequestDispatcher dispatcher=req.getRequestDispatcher("displaybook.jsp");
		dispatcher.include(req, resp);
	}

}
