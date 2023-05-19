package productOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyProduct {
	
	static Connection con=null;
	static Statement stmt=null;
    ResultSet res=null;
	
	static 
	{
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void addProduct(int pid,String pname,double pprice)
	{
		
		String query="insert into productinfo values("+pid+",'"+pname+"',"+pprice+")";
		String query1="insert into productinfo values("+pid+",'"+pname+"',"+pprice+")";
		try 
		{
			stmt=con.createStatement();
			 int count=stmt.executeUpdate(query1);
			System.out.println("RECORD INSERTED"+count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void deleteProduct(int productid)
	{
		String query2="delete from productdemo1 where productid="+productid+"";
		try {
			stmt=con.createStatement();
			int count=stmt.executeUpdate(query2);
			System.out.println("RECORD DELETED"+count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void displayProduct()
	{
		String query="select * from productinfo";
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			System.out.println("productid"+"\t"+"productname"+"\t"+"productprice");
			System.out.println("==========================================");
			while(res.next())
			{
				int id=res.getInt(1);
				String name=res.getString(2);
				double price=res.getDouble(3);
				
				System.out.println(id+"\t\t"+name+"\t\t"+price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
