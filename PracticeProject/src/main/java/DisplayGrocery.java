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

@WebServlet("/displaylink")
public class DisplayGrocery extends HttpServlet {
	

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
		
		String query="select * from grocery_item";
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
					
					pw.print("<table border='2' >");
					pw.print("<tr>"+
							"<th>ID</th>"+
							"<th>NAME</th>"+
							"<th>PRICE</th>"+
							"</tr>");
					
					while(res.next())
					{
						int id=res.getInt(1);
						String name=res.getString(2);
						double price=res.getDouble(3);
						
						pw.print("<tr>"+
								"<td>"+id+"</td>"+
								"<td>"+name+"</td>"+
								"<td>"+price+"</td>"+
								"</tr>");
					}
					pw.print("</table>");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}

}
