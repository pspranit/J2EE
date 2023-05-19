package pranit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program 
{
	public static void main(String[] args) throws SQLException
	{
		Connection con;
		Statement stmt;
		ResultSet res;
//		String query="insert into productinfo values(10,'REMOTE',3000.00)";
		String query="delete from productinfo where productid=10";
//		String query2="update productinfo set productname='LED' where productid=2";
//		String query3="delete from productinfo where productid=1";
//		String query4="select * from productinfo";
		
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query);
			
			System.out.println("record inserted : "+count);
		
		
		
		}
}
