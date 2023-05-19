package jdbcTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER QTY");
		int qty=sc.nextInt();
		
		System.out.println("ENTER PRICE");
		double price=sc.nextDouble();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			cstmt=con.prepareCall("{?=call booking(?,?)}");
			
			cstmt.setInt(2,qty);
			cstmt.setDouble(3, price);
			
			cstmt.registerOutParameter(1, Types.DOUBLE);
			cstmt.execute();
			System.out.println("TOTAL AMMOUNT IS :"+cstmt.getDouble(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}

}
