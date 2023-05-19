package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class ProcedureBike_info {
	
public static void main(String[] args) throws SQLException {
	

	Scanner sc=new Scanner(System.in);
	
	System.out.println("ENTER ID");
	int id=sc.nextInt();
	
	System.out.println("ENTER MODEL");
	String model=sc.next();
	
	System.out.println("ENTER COMPANY");
	String company=sc.next();
	
	System.out.println("ENTER PRICE");
	double price=sc.nextDouble();
	
	Connection con=null;
	CallableStatement cstmt=null;
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");	
	
	cstmt=con.prepareCall("{call bikeoperations(?,?,?,?)}");
	
	cstmt.setInt(1, id);
	cstmt.setString(2, model);
	cstmt.setString(3, company);
	cstmt.setDouble(4, price);
	
//	cstmt.registerOutParameter(1, Types.INTEGER);
	cstmt.execute();
	System.out.println("RECORD INSERTED");
	
}
}
