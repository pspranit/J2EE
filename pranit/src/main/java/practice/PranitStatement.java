package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class UsingStatement{
	
	static Connection con=null;
	static Statement stmt;
	static ResultSet res;
	
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertData(String name, int age) throws SQLException
	{
	

		String query="insert into pranit(name,age) values('"+name+"',"+age+")";
		
		
		stmt=con.createStatement();
		int count=stmt.executeUpdate(query);
		
		System.out.println("RECORD INSERTED :"+count);
		
	}
	
	static void displayData() throws SQLException
	{
		String query="select * from pranit";
		stmt=con.createStatement();
		res=stmt.executeQuery(query);
		
		System.out.println("ID\tNAME\tAGE");
		System.out.println("----------------------");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
		}
	}
	
	static void deleteData(int id) throws SQLException
	{
		String query="delete from pranit where id="+id+"";
		stmt=con.createStatement();
		int count=stmt.executeUpdate(query);
		System.out.println(count+" :RECORD DELETED");
	}
	
	static void updateData(int id, String name, int age) throws SQLException
	{
		String query="update pranit set name='"+name+"',age="+age+" where id="+id+"";
		stmt=con.createStatement();
		
		int count=stmt.executeUpdate(query);
		System.out.println(count+": RECORD UPDATED");
	}
}


public class PranitStatement {

	private static Scanner sc;

	public static void main(String[] args) throws SQLException {
		
		
		sc = new Scanner(System.in);
		
		while(true)
		{
			
			System.out.println("ENTER CHOICE\n 1:INSERT DATA\n 2:DISPLAY DATA\n 3:DELETE DATA\n 4:UPDATE DATA");
			int choice=sc.nextInt();	
			
			if (choice==1) {
				
				System.out.println("ENTER NAME");
				String name=sc.next();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				UsingStatement.insertData(name,age);
			}
			else if (choice==2) {
				
				UsingStatement.displayData();
			}
			else if(choice==3)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				UsingStatement.deleteData(id);
			}
			else if(choice==4)
			{
				
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER NAME");
				String name=sc.next();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				UsingStatement.updateData(id,name,age);
			}
			else {
				System.out.println("PLZ ENTER VALID CHOICE");
			}
		}	
		
	}
}
