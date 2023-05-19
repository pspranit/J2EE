package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculateAreaOfCircle {
	
	static double pi=3.14;

	public static void main(String[] args) throws SQLException {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER RADIUS");
		int radius=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		
		cstmt=con.prepareCall("{?=call calculateAreaOfCircle(?,?)}");
		
		cstmt.setDouble(2, pi);
		cstmt.setInt(3, radius);
		
		
		cstmt.registerOutParameter(1, Types.DOUBLE);
		cstmt.execute();
		
		System.out.println("AREA OF CIRCLE IS :"+cstmt.getDouble(1));
		

		
		

	}

}
