package CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import java.sql.CallableStatement;


public class CallableDemo1 
{
	public static void main(String[] args) throws SQLException 
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER FIRST NUMBER");
		int no1=sc.nextInt();
		
		System.out.println("ENTER SECOND NUMBER");
		int no2=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		cstmt=con.prepareCall("{?=call addnumber(?,?)}");
		
		cstmt.setInt(2, no1);
		cstmt.setInt(3, no2);
		
		cstmt.registerOutParameter(1, Types.INTEGER);
		cstmt.execute();
		System.out.println("ADDITION IS :"+cstmt.getInt(1));
		
		
	}

}
