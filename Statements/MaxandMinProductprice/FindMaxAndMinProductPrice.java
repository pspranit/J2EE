package MaxandMinProductprice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class MaxMinOperation{
	

	static Connection con=null;
	static Statement stmt=null;
	static ResultSet res=null;
	
	static 
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			stmt=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	static void maxProductPrice()
	{
		String query="SELECT * FROM productdemo1 WHERE pprice=(SELECT MAX(pprice) FROM productdemo1)";
		
		try {
			res=stmt.executeQuery(query);
			while(res.next())
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				double price=res.getDouble(3);
				
				System.out.println(id+"\t"+name+"\t"+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void minProductPrice() throws SQLException
	{
		
		String query="SELECT * FROM PRODUCTDEMO1 WHERE PPRICE=(SELECT MIN(PPRICE) FROM PRODUCTDEMO1)";
		
		res=stmt.executeQuery(query);
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getDouble(3));
		}
		
	}
	
}

public class FindMaxAndMinProductPrice {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc= new Scanner(System.in);
			
		while(true)
		{
			
			System.out.println("ENTER CHOICE\n 1:FIND MAX PRODUCT PRICE\n 2:FIND MIN PRODUCT PRICE ");
			int choice=sc.nextInt();	
			
			if (choice==1) {
				MaxMinOperation.maxProductPrice();

			}
			else if (choice==2) {
				MaxMinOperation.minProductPrice();

			}
			else {
				System.out.println("PLZ ENTER VALID CHOICE");
			}
		}
		
	}
	
	
}
