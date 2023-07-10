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

import com.mysql.cj.Session;

import Service.BookDeleteService;
import Service.BookUpdateService;

@WebServlet("/deletelink")
public class DeleteBook extends HttpServlet{
	
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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		BookDeleteService bookDeleteService=new BookDeleteService();
		boolean status=bookDeleteService.getDeleteBook(id,con);
		
		HttpSession session=req.getSession();	
		
		
		if(status)
		{
			session.setAttribute("delete", "yes");
			RequestDispatcher dispatcher=req.getRequestDispatcher("resultdelete.jsp");
			dispatcher.include(req, resp);
		}
		else {
			session.setAttribute("delete", "no");
			RequestDispatcher dispatcher=req.getRequestDispatcher("resultdelete.jsp");
			dispatcher.include(req, resp);

		}

	}

}
