package jdbcTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class Count {
	static Connection con=null;
	static PreparedStatement pstmt=null;
	static Statement stmt=null;
	ResultSet res=null;
	
	
	static {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayCount(String cityName) {
		
		String query="select city,count(*) from employeeinfo where city='"+cityName+"'";
		try {
			pstmt=con.prepareStatement(query);
			res=pstmt.executeQuery();
			
			while(res.next());
			{
				String city=res.getString(1);
				int count=res.getInt(2);
				System.out.println(city+"\t\t"+count);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		Count c=new Count();
		Scanner sc=new Scanner(System.in);
		String city=sc.next();
		c.displayCount(city);

	}

}
