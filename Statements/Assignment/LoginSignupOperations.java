package Assignment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginSignupOperations {

	public void displayProduct(Statement stmt,Connection con,ResultSet res)
	{
			
			String query="select * from productdemo1";
			
			try {
				stmt=con.createStatement();
				res=stmt.executeQuery(query);
				System.out.println("id"+"\t"+"productname"+"\t"+"productprice");
				System.out.println("==========================================");
				while(res.next())
				{
					int id=res.getInt(1);
					String pName=res.getString(2);
					double price=res.getDouble(3);
					
					System.out.println(id+"\t"+pName+"\t\t"+price);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			finally {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
			System.out.println("=====================PRODUCTS ARE SUCCESSFULLY DISPLAY=====================");

		}
	public	void addProduct1(int id,String name,double price,Statement stmt,Connection con)
	{	
		String query1="insert into productdemo1 values("+id+",'"+name+"','"+price+"')";
		try 
		{
			stmt=con.createStatement();
			 int count=stmt.executeUpdate(query1);
			System.out.println("RECORD INSERTED"+count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		System.out.println("=====================PRODUCT ADD SUCCESSFULLY=====================");

	}
	

	public void availableAccounts(Statement stmt,Connection con,ResultSet res) {
		String query="select * from login_info";
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			System.out.println("id"+"\t"+"username"+"\t"+"password");
			System.out.println("==========================================");
			while(res.next())
			{
				int id=res.getInt(1);
				String uName=res.getString(2);
				String pass=res.getString(3);
				
				System.out.println(id+"\t"+uName+"\t\t"+pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteProduct(int pid,Connection con,Statement stmt,ResultSet res)
	{
		String query="select pid from productdemo1";
		
		boolean status=false;
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(res.next())
			{
				int id=res.getInt(1);
				
				if(id==pid)
				{
					status=true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status)
		{
			String query1="delete from productdemo1 where pid="+pid+"";
			
			try {
				stmt=con.createStatement();
				int count=stmt.executeUpdate(query1);
				System.out.println("RECORD DELETED :"+count);
				System.out.println("=====================PRODUCT DELETE SUCCESSFULLY=====================");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void deleteAccount(String username,String pass,Statement stmt,Connection con,ResultSet res)
	{
		String query="select username,password from login_info";
		boolean status=false;
		
			try {
				stmt=con.createStatement();
				res=stmt.executeQuery(query);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 try {
				while(res.next())
				 {
					String user=res.getString(1);
					String password=res.getString(2);
					
					if(user.equals(username) && password.equals(pass))
					{
						status=true;
					}	
				 }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			 if(status)
			 {
				String query2="delete from login_info where username='"+username+"' and password='"+pass+"'";
				try 
				{
					stmt=con.createStatement();
					int count=stmt.executeUpdate(query2);
					System.out.println("RECORD DELETED :"+count);
					System.out.println("=====================ACCOUNT DELETE SUCCESSFULLY=====================");
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
				else {
					System.out.println("INVALID USERNAME AND PASSWORD");
				} 
	}
}
