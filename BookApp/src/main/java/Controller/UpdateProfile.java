package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Service.UpdateProfileService;

@WebServlet("/updateprofilelink")
public class UpdateProfile extends HttpServlet{
	
	static Connection con;
	ResultSet res;
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
			
		String userName=req.getParameter("username");
		
		String contact=req.getParameter("contact");
		long newCont=Long.parseLong(contact);
		
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String gender=req.getParameter("gender");
		
		int userId=(int)req.getSession().getAttribute("userid");
		
		UpdateProfileService profileService=new UpdateProfileService();
		
		boolean status=profileService.getUpdateProfile(userId,userName,newCont,address,email,password,gender,con,resp);
		
		HttpSession session=req.getSession();
		if(status)
		{
			 String query1="select * from user_info where id=?";
			 PreparedStatement pstmt;
			 
			 try {
				pstmt=con.prepareStatement(query1);
				pstmt.setInt(1, userId);
				 
				 res=pstmt.executeQuery();
				 
				 while(res.next())
				 {

					 int dbId=res.getInt(1);
					 String dbName=res.getString(2);
					 long dbContact=res.getLong(3);
					 String dbAddress=res.getString(4);
					 String dbEmail=res.getString(5);
					 String dbGender=res.getString(6);
					 String dbPassword=res.getString(7);
					 
					 
					 
					 session.setAttribute("id", dbId);
					 session.setAttribute("name", dbName);
					 session.setAttribute("contact", dbContact);
					 session.setAttribute("address", dbAddress);
					 session.setAttribute("email", dbEmail);
					 session.setAttribute("gender", dbGender);
					 session.setAttribute("password", dbPassword);
						
					 session.setAttribute("profile", "true");
					 RequestDispatcher dispatcher=req.getRequestDispatcher("updateprofileresult.jsp");
						dispatcher.include(req, resp);
				 }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			 
		}
		else {
			session.setAttribute("profile","false");
			RequestDispatcher dispatcher=req.getRequestDispatcher("updateprofileresult.jsp");
			dispatcher.include(req, resp);
		}
		
	}

}
