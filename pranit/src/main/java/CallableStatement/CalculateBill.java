package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculateBill {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER QTY");
		int qty=sc.nextInt();
		
		System.out.println("ENTER PRICE");
		double price=sc.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		cstmt=con.prepareCall("{?=call calculateBill(?,?)}");
		
		cstmt.setInt(2,qty);
		cstmt.setDouble(3, price);
		
		cstmt.registerOutParameter(1, Types.DOUBLE);
		cstmt.execute();
		System.out.println("CALCULATE BILL IS :"+cstmt.getDouble(1));
		
		

		
		
	}

}
