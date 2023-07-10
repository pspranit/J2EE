package Controller;

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
import javax.servlet.http.HttpSession;

import Service.BookUpdateService;

@WebServlet("/updatelink")
public class UpdateBook extends HttpServlet{
	
	Connection con;
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pranit","root","sql@123" );
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("bookid"));
		String authorName=req.getParameter("authorname");
		String bookName=req.getParameter("bookname");
		double bookPrice=Double.parseDouble(req.getParameter("bookprice"));
		double bookRating=Double.parseDouble(req.getParameter("bookrating"));
		
		BookUpdateService bookUpdateService=new BookUpdateService();

		String update=bookUpdateService.getUpdateBook(id, authorName, bookName, bookPrice, bookRating, con);
		HttpSession session=req.getSession();
		session.setAttribute("update",update);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("resultupdate.jsp");
		dispatcher.include(req, resp);
		
	}

}
