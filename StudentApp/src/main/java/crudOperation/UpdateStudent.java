package crudOperation;

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

@WebServlet("/updatelink")
public class UpdateStudent extends HttpServlet {

	
 Connection con=null;

@Override
	public void init() throws ServletException {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	try {

		String sId=req.getParameter("studentid");
		int id=Integer.parseInt(sId);
		String sName=req.getParameter("studentname");
		String sStream=req.getParameter("studentstream");
		
		PrintWriter pw=resp.getWriter();
		
		PreparedStatement pstmt=null;
		
		String query="update student_info set s_name=(?),s_stream=(?) where s_id=(?)";
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setInt(3, id);
		pstmt.setString(1, sName);
		pstmt.setString(2, sStream);
		
		int count=pstmt.executeUpdate();
		
		pw.print("<h1>RECORD UPDATED SUCCESSFULLY :"+count+"</h1>");
		
		pw.print("<br>"+"<button>"+"<a href=\"index.html\">HOME"+"</a>"+"</button>");

		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
		}
}
