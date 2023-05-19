package MaxandMinProductprice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginOperation {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER USERNAME");
		String username=sc.next();
		
		System.out.println("ENTER PASSWORD");
		String password=sc.next();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet res=null;
		
		String query="select username,password from Login_Info";
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			boolean status=false;
			
			while(res.next())
			{
				String user=res.getString(1);
				String pass=res.getString(2);
				
				if(user.equals(username) && pass.equals(password))
				{
					status=true;
				}
			}
			
			if(status)
			{
				System.out.println("LOGIN SUCCESSFULLY");
				
			}
			else {
				System.out.println("INVALID LOGIN DETAILS");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
