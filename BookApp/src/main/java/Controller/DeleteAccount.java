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
import javax.servlet.http.HttpSession;

import Service.AccountDeleteService;

@WebServlet("/deleteaccountlink")
public class DeleteAccount extends HttpServlet{
	
	Connection con;
	@Override
	public void init() throws ServletException {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pranit","root","sql@123" );
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName=req.getParameter("user");
		String password=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		
		HttpSession session=req.getSession();

		int userId=(int)req.getSession().getAttribute("userid");
		String name=(String)req.getSession().getAttribute("username");
		String pass=(String)req.getSession().getAttribute("password");
		
		AccountDeleteService accountDeleteService=new AccountDeleteService();
		
		boolean status=accountDeleteService.deleteAccount(userName,password,userId,name,pass,con);
		
		if(status)
		{
			pw.print("<h1>ACCOUNT DELETED SUCCESSFULLY !!</h1>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, resp);
		}
		else {
			session.setAttribute("deleteaccount", "false");
			RequestDispatcher dispatcher=req.getRequestDispatcher("deleteaccountresult.jsp");
			dispatcher.include(req, resp);

		}
	}

}
