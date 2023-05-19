package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CustomerType {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER CREDIT LIMIT");
		int limit=sc.nextInt();
		
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		cstmt=con.prepareCall("{?=call cType(?)}");
		
		cstmt.setInt(2,limit);

		
		cstmt.registerOutParameter(1, Types.VARCHAR);
		cstmt.execute();
		System.out.println("CUSTOMER TYPE IS :"+cstmt.getString(1));
		
		
		
		

	}

}

