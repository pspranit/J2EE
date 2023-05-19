package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DMLOperations {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER BIKE ID");;
		int bike_id=sc.nextInt();
		
		System.out.println("ENTER BIKE MODEL");
		String model=sc.next();
		
		System.out.println("ENTER BIKE COMPANY");
		String company=sc.next();
		
		System.out.println("ENTER BIKE PRICE");
		double price=sc.nextDouble();
		
		System.out.println("ENTER ID TO CHANGE PRICE");
		int uId=sc.nextInt();
		
		System.out.println("ENTER UPDATE PRICE");
		double uPrice=sc.nextDouble();
		
		System.out.println("ENTER DELETE ID");
		int dId=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		
		cstmt=con.prepareCall("{call DMLOperations(?,?,?,?,?,?,?)}");
		
		cstmt.setInt(1, bike_id);
		cstmt.setString(2, model);
		cstmt.setString(3, company);
		cstmt.setDouble(4, price);
		
		cstmt.setInt(5, uId);
		
		cstmt.setDouble(6, uPrice);
		
		cstmt.setInt(7, dId);
		
		cstmt.execute();
		System.out.println("DML OPERATIONS SUCCESSFULLY INSERT,UPDATE,DELETE ");
		

	}

}
