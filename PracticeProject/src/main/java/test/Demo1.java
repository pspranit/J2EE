package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/pranitlink")

public class Demo1 extends HttpServlet {

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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		
		PreparedStatement pstmt;
		String query="insert into login_info values(?,?,?)";
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(1, 4);
			pstmt.setString(2, username);
			pstmt.setString(3, password);
			
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();

			pw.print("<h1>RECORD INSERTED SUCCESSFULLY :"+count+"</h1>");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
//		PrintWriter pw=resp.getWriter();
//		pw.print("<h1 style='color:red'>"+username+"</h1>");
//		pw.print("<h1>"+password+"</h1>");
	}
}
