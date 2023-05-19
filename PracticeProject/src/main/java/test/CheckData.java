package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hellolink")
public class CheckData extends HttpServlet {
	
	Connection con=null;
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{


		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		
		Statement stmt;
		ResultSet res;
		
		boolean status=false;

		PrintWriter pw=resp.getWriter();
		String query="select username,password from login_info";
		try {
			stmt=con.createStatement();

			res=stmt.executeQuery(query);
			
			while(res.next())
			{
				String dbUser=res.getString(1);
				String dbPass=res.getString(2);
				
				if(dbUser.equals(user) && dbPass.equals(pass))
				{
					status=true;
				}
				else {
					status=false;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	if(status)
	{
		pw.print("<h1>LOGIN SUCCESSFULLY..!!"+"</h1>");

	}
	else {
		pw.print("<h1>INCORRECT PASSWORD..!!</h1>");

	}
}
}
