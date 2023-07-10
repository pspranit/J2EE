package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.RegisterService;

@WebServlet("/registerlink")
public class Register extends HttpServlet{

	static Connection con;
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
		String userName=req.getParameter("username");
		
		String contact=req.getParameter("contact");
		long newCont=Long.parseLong(contact);
		
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
		RegisterService registerService=new RegisterService();
		boolean status=registerService.addUserAccount(userName,newCont,address,email,password,gender,con);
		
		HttpSession session=req.getSession();
		if(status)
		{
			 session.setAttribute("register", "true");
			 RequestDispatcher dispatcher=req.getRequestDispatcher("resultregister.jsp");
				dispatcher.include(req, resp);
		}
		else {
			 session.setAttribute("register", "false");
			 RequestDispatcher dispatcher=req.getRequestDispatcher("resultregister.jsp");
				dispatcher.include(req, resp);
		}
	}

}
