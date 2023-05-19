package MaxandMinProductprice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BetweenMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENTER LOWER PRICE");
		int lower =sc.nextInt();
		
		System.out.println("ENTER HIGHER PRICE");
		int higher=sc.nextInt();
		

		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		Statement stmt=con.createStatement();
		
		String query="select * from productdemo1 where pprice between "+lower+" and "+higher+"";
		ResultSet res=stmt.executeQuery(query);
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
}
