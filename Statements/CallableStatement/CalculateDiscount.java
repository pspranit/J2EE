package CallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CalculateDiscount {

	public static void main(String[] args) throws SQLException {

		Scanner sc=new Scanner(System.in);
		System.out.println("ENTER BILL AMMOUNT");
		int billAmt=sc.nextInt();
		
		System.out.println("SELECT CUSTOMER TYPE");
		System.out.println("1:PREMIUM 20%\n2:REGULAR 10%");
		
		System.out.println("ENTER CUSTOMER TYPE");
		String cusType=sc.next();
		
		Connection con=null;
		CallableStatement cstmt=null;
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		
		cstmt=con.prepareCall("{?=call calDiscount(?,?)}");
		
		cstmt.setInt(2, billAmt);
		cstmt.setString(3, cusType);
		
		cstmt.registerOutParameter(1, Types.DOUBLE);
		cstmt.execute();
		
//		System.out.println("TOTAL AMMOUNT AFTER DISCOUNT 10% AND 20% :"+cstmt.getDouble(1));
		
		if(billAmt>cstmt.getDouble(1))
		{
			System.out.println("TOTAL AMMOUNT AFTER DISCOUNT 10% :"+cstmt.getDouble(1));
		}
		else if(billAmt<cstmt.getDouble(1))
		{
			System.out.println("TOTAL AMMOUNT AFTER DISCOUNT 20% :"+cstmt.getDouble(1));

		}
		else 
		{
			System.out.println("BILL AMMOUNT IS LESS THAN 5000");
		}
			
	}

}
