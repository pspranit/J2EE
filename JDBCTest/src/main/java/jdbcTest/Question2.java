package jdbcTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

class CountAndAscOrder{

	static Connection con=null;
	static CallableStatement cstmt=null;
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
	
	public void displayCount(String city) {
		
		try {
			cstmt=con.prepareCall("{call empdemo(?,?)}");
			cstmt.setString(1, city);
			
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			
			System.out.println("TOTAL NO OF CITYS ARE :"+cstmt.getInt(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void diplayAsc() {
		
		String query="select username,age from employeeinfo order by username and age asc";
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			System.out.println("username\tage");
			while(res.next())
			{
				String username=res.getString(1);
				int age=res.getInt(2);
				System.out.println(username+"\t\t"+age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

public class Question2 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		CountAndAscOrder ca=new CountAndAscOrder();
		
		System.out.println("SELECT OPTION");
		System.out.println("1:GET CITY WISE COUNT OF USERS");
		System.out.println("2:DISPLAY ALL USERNAME ASCENDING ORDER ACCORDING TO THIER AGE");
		
		System.out.println("ENTER CHOICE");
		int choice=sc.nextInt();
		
		if(choice==1)
		{
			System.out.println("ENTER CITY NAME");
			String city=sc.next();
		ca.displayCount(city);	
		}
		else if(choice==2)
		{
			ca.diplayAsc();
		}
		else {
			System.out.println("INVALID CHOICE");
		}
	}

}
