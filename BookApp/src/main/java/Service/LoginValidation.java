package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginValidation {

	static Statement stmt;
	static PreparedStatement pstmt;
	ResultSet res;

	public void validation1(String userName, String password, Connection con, HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		PrintWriter pw = resp.getWriter();
		String query = "select username,password from user_info";
		boolean status = false;

		try {
			stmt = con.createStatement();
			res = stmt.executeQuery(query);

			while (res.next())
			{


				if (res.getString(1).equals(userName) && res.getString(2).equals(password)) {

					status = true;
					break;
				} 
				else {
					status = false;
				}
			}
			
			if (status) {
				String query1 = "select * from user_info where username=?";

				pstmt = con.prepareStatement(query1);
				pstmt.setString(1, userName);

				res = pstmt.executeQuery();

				while (res.next()) {

					int dbId = res.getInt(1);
					String dbName = res.getString(2);
					long dbContact = res.getLong(3);
					String dbAddress = res.getString(4);
					String dbEmail = res.getString(5);
					String dbGender = res.getString(6);
					String dbPassword = res.getString(7);
					
					

					session.setAttribute("id", dbId);
					session.setAttribute("name", dbName);
					session.setAttribute("contact", dbContact);
					session.setAttribute("address", dbAddress);
					session.setAttribute("email", dbEmail);
					session.setAttribute("gender", dbGender);
					session.setAttribute("password", dbPassword);

					RequestDispatcher rd = req.getRequestDispatcher("afterlogin.jsp");
					rd.include(req, resp);
				}

			} else {
				pw.print("<h1 style='color:red'>INVALID USERNAME AND PASSWORD</h1>");
				RequestDispatcher rd = req.getRequestDispatcher("login.html");
				rd.include(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

//
//package Service;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginValidation {
//
//	 
//	ResultSet res;
//	
//	public void validation1(String userName, String password, Connection con, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException,IOException  {
//		Statement stmt;
//		 PreparedStatement pstmt;
//		PrintWriter pw=resp.getWriter();
//		String query="select username,password from user_info where username='"+userName+"'";
//
//		try {
//			stmt=con.createStatement();
//			res=stmt.executeQuery(query);
//			
//			
//			 while(res.next())
//			 {
//				 String uName=res.getString(1);
//				 String uPass=res.getString(2);
//				 
//				 if(uName.equals(userName) && uPass.equals(password))
//				 {
//					 
//					 String query1="select * from user_info where username=?";
//					 
//					 pstmt=con.prepareStatement(query1);
//					 pstmt.setString(1, userName);
//					 
//					 res=pstmt.executeQuery();
//					 
//					 while(res.next())
//					 {
//
//						 int dbId=res.getInt(1);
//						 String dbName=res.getString(2);
//						 long dbContact=res.getLong(3);
//						 String dbAddress=res.getString(4);
//						 String dbEmail=res.getString(5);
//						 String dbGender=res.getString(6);
//						 String dbPassword=res.getString(7);
//						 
//						 
//						 
//						 session.setAttribute("id", dbId);
//						 session.setAttribute("name", dbName);
//						 session.setAttribute("contact", dbContact);
//						 session.setAttribute("address", dbAddress);
//						 session.setAttribute("email", dbEmail);
//						 session.setAttribute("gender", dbGender);
//						 session.setAttribute("password", dbPassword);
//							
//						RequestDispatcher rd=req.getRequestDispatcher("afterlogin.jsp");
//						rd.forward(req, resp);
//					 }
//				 }
//				else 
//					{
//					pw.print("<h1 style='color:red'>INVALID USERNAME AND PASSWORD</h1>");
//					RequestDispatcher rd=req.getRequestDispatcher("login.html");
//					rd.include(req, resp);
//				}
//				 
//			 }
//			 	
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
//
//}
//
//
