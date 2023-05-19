package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class InputOutputParameter {
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter company name");
		String name=sc.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
		
		cstmt=con.prepareCall("{call parameterdemo(?,?)}");
		cstmt.setString(1, name);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.execute();
		
		System.out.println("TOTAL NO OF MODELS ARE :"+cstmt.getInt(2));
	}

}
