package crudOperation;

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

import com.mysql.cj.xdevapi.Result;

@WebServlet("/displaylink")
public class DisplayStudent extends HttpServlet {

	Connection con=null;
@Override
public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );

	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Statement stmt=null;
	ResultSet res=null;
	
	PrintWriter pw=resp.getWriter();
	
	String query="select * from student_info";
	
	try {
		stmt=con.createStatement();
		res=stmt.executeQuery(query);
		
		pw.print("<table border='2' >");
		pw.print("<tr bgcolor='yellow'>"+
		"<th>STUDENT_ID</th>"+
		"<th>STUDENT_NAME</th>"+
		"<th>STUDENT_STREAM</th>"+
		"<th>ADDMISION DATE</th>"+
		"</tr>");
		while(res.next())
		{
			int id=res.getInt(1);
			String name=res.getString(2);
			String stream=res.getString(3);
			String date=res.getString(4);
			
			pw.print("<tr>"+
			"<td>"+id+"</td>"+
			"<td>"+name+"</td>"+
			"<td>"+stream+"</td>"+
			"<td>"+date+"</td>"+
			"</tr>");
		}
		pw.print("</table>");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	pw.print("<br>"+"<button>"+"<a href=\"index.html\">HOME"+"</a>"+"</button>");
	
}
}
//avi.mahajan3719@gmail.com
