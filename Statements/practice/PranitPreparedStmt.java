package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class PraparedStmt{
	
	static Connection con=null;
	static PreparedStatement pstmt;
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
	
		String query="insert into pranit (name,age) values(?,?)";
		
		pstmt=con.prepareStatement(query);
		
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		
		int count=pstmt.executeUpdate();
		System.out.println(count+" : RECORD INSERTED");
		
	}
	
	static void displayData() throws SQLException
	{
		
		String query="select * from pranit";
		pstmt=con.prepareStatement(query);
		
		res=pstmt.executeQuery();
		
		System.out.println("ID\tNAME\tAGE");
		System.out.println("----------------------");
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
		}
	}
	
	static void deleteData(int id) throws SQLException
	{
		String query="delete from pranit where id=(?)";
		pstmt=con.prepareStatement(query);
		pstmt.setInt(1, id);
		int count=pstmt.executeUpdate();
		System.out.println(count+" :RECORD DELETED");
	}
	
	static void updateData(int id,int age) throws SQLException
	{
		String query2="select * from pranit";
		String query="update pranit set age=(?) where id=(?)";
		
		boolean status=false;
		int count=0;
		pstmt=con.prepareStatement(query);

		Statement stmt=con.createStatement();
		res=stmt.executeQuery(query2);
		
		while(res.next()) {
			
			int id1=res.getInt(1);
			if(id1==id)
			{
				pstmt.setInt(2, id);
				pstmt.setInt(1, age);
			
				 count=pstmt.executeUpdate();
				
				status=true;
				break;
			}
			else {
				status=false;
			}	
			
		}
		if(status) {
			System.out.println(count+": RECORD UPDATED");		
		}
		else {
			System.out.println("INVALID DATA");
		}
		
	}
}


public class PranitPreparedStmt {


	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc= new Scanner(System.in);
		
		while(true)
		{
			
			System.out.println("ENTER CHOICE\n 1:INSERT DATA\n 2:DISPLAY DATA\n 3:DELETE DATA\n 4:UPDATE DATA");
			int choice=sc.nextInt();	
			
			if (choice==1) {
				
				System.out.println("ENTER NAME");
				String name=sc.next();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				PraparedStmt.insertData(name,age);
			}
			else if (choice==2) {
				
				PraparedStmt.displayData();
			}
			else if(choice==3)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				PraparedStmt.deleteData(id);
			}
			else if(choice==4)
			{
				
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				PraparedStmt.updateData(id,age);
			}
			else {
				System.out.println("PLZ ENTER VALID CHOICE");
			}
		}	
		
	}
}
