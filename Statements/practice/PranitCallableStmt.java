package practice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

class CallableStmt{

	static Connection con=null;
	static CallableStatement cstmt=null;
	static ResultSet res;
	
	static
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertData(int id,String name, int age) throws SQLException
	{
		cstmt=con.prepareCall("{call pranitDML(?,?,?)}");
		
		cstmt.setInt(1, id);
		cstmt.setString(2,name);
		cstmt.setInt(3, age);
		
		int count=cstmt.executeUpdate();
		System.out.println(count+" :RECORD INSERTED");
		
	}
	
	static void displayData() throws SQLException
	{
		cstmt=con.prepareCall("{call pranitDMLSel(?,?,?)}");
		
		res=cstmt.executeQuery();
		System.out.println("ID\tNAME\tAGE");
		System.out.println("----------------------");
		
		while(res.next())
		{
			System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getInt(3));
		}
		
	}
	
	static void deleteData(int id) throws SQLException
	{
		cstmt=con.prepareCall("{call pranitDMLDel(?)}");
		
		cstmt.setInt(1,id);
		int count=cstmt.executeUpdate();
		System.out.println(count+" :RECORD DELETED");

		
	}
	
	static void updateData(int id,int age) throws SQLException
	{
		
		cstmt=con.prepareCall("{call pranitDMLUpd(?,?)}");
		cstmt.setInt(1, id);
		cstmt.setInt(2, age);
		
		int count=cstmt.executeUpdate();
		System.out.println(count+" :RECORD UPDATED");
	
	}
	
	static void getCount() throws SQLException
	{
		
//		cstmt=con.prepareCall("{call getCount(?)}");
//		cstmt.registerOutParameter(1, Types.INTEGER);
//		
//		cstmt.execute();
//		
//		System.out.println("TOTAL NO OF MODELS ARE :"+cstmt.getInt(1));
		
		cstmt=con.prepareCall("{call getCount(?)}");
		cstmt.registerOutParameter(1, Types.INTEGER);
		
		cstmt.execute();
		
		System.out.println("NO OF ROWS COUNT : "+cstmt.getInt(1));
		
	
	}

	public static void totalBalance() throws SQLException {
		
		cstmt=con.prepareCall("{call totalBal(?)}");
		
		cstmt.registerOutParameter(1, Types.DOUBLE);
		cstmt.execute();
		System.out.println("TOATAL BALANCE ARE : "+cstmt.getDouble(1));
	}
	
}

public class PranitCallableStmt {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc= new Scanner(System.in);
		
		while(true)
		{
			
			System.out.println("ENTER CHOICE\n 1:INSERT DATA\n 2:DISPLAY DATA\n 3:DELETE DATA\n 4:UPDATE DATA\n 5:ROW COUNT\n 6:TOTAL BALANCE");
			int choice=sc.nextInt();	
			
			if (choice==1) {
				
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER NAME");
				String name=sc.next();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				CallableStmt.insertData(id,name,age);
			}
			else if (choice==2) {
				
				CallableStmt.displayData();
			}
			else if(choice==3)
			{
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				CallableStmt.deleteData(id);
			}
			else if(choice==4)
			{
				
				System.out.println("ENTER ID");
				int id=sc.nextInt();
				
				System.out.println("ENTER AGE");
				int age=sc.nextInt();
				
				CallableStmt.updateData(id,age);
			}
			
			else if(choice==5)
			{
				CallableStmt.getCount();
			}
			
			else if(choice==6)
			{
				CallableStmt.totalBalance();
			}
			else
			{
				System.out.println("PLZ ENTER VALID CHOICE");
			}
		}	
	}
}
