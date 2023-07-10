package Controller;

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

import Service.BookAddService;

@WebServlet("/addbook")
public class AddBook extends HttpServlet{
	Connection con;
	PrintWriter pw;
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
		resp.setContentType("text/html");
		String authorName=req.getParameter("authorname");
		String bookName=req.getParameter("bookname");
		String price=req.getParameter("bookprice");
		double bookPrice=Double.parseDouble(price);
		String rating=req.getParameter("bookrating");
		double bookRating=Double.parseDouble(rating);
		String pDate=req.getParameter("publisheddate");
		
		try {
			pw = resp.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}		
		int userId=(int)req.getSession().getAttribute("userid");
		
		BookAddService bookAddService=new BookAddService();
		boolean status=bookAddService.addBook(authorName,bookName,bookPrice,bookRating,pDate,con,userId);
		
		if(status)
		{
			req.setAttribute("yes", status);
			RequestDispatcher rd=req.getRequestDispatcher("bookaddsuccess.jsp");
			rd.include(req, resp);

		}
		else {
			
			req.setAttribute("yes", status);
			
			RequestDispatcher rd=req.getRequestDispatcher("afterlogin.jsp");
			rd.include(req, resp);

		}
		
	}

}
