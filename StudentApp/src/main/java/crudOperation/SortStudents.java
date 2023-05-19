package crudOperation;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sortlink")
public class SortStudents extends HttpServlet {
	
	static Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet res;
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw=resp.getWriter();
		String query="select * from student_info order by s_name";
		try {
			pstmt=con.prepareStatement(query);
			res=pstmt.executeQuery();
			
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
			
			e.printStackTrace();
		}	
		
	}
}
