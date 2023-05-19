package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureProductOperations {

	public static void main(String[] args) throws SQLException {

		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER PRODUCT_ID");
		int pid=sc.nextInt();
		
		System.out.println("ENTER PRODUCT_NAME");
		String name=sc.next();
		
		System.out.println("ENTER PRICE");
		double pprice=sc.nextDouble();
		
		System.out.println("ENTER DELETE ID");
		int delId=sc.nextInt();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		
		cstmt=con.prepareCall("{call productoperations(?,?,?,?)}");
		
		cstmt.setInt(1, pid);
		cstmt.setString(2, name);
		cstmt.setDouble(3, pprice);
		cstmt.setInt(4, delId);
		
		cstmt.execute();
	
		System.out.println("OPERATION SUCCESS");
		
	}

}
