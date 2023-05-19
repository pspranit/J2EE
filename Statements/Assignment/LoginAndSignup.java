package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginAndSignup {
	static Connection con=null;
	Statement stmt=null;
	ResultSet res=null;
	Scanner sc=new Scanner(System.in);
	
	LoginSignupOperations lso=new LoginSignupOperations();
	
	static
	{
		try {
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String username,String password) 
	{
		String query="select username,password from login_info";
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery(query);
			 boolean status=false;
			
			 while(res.next())
			 {
				String user=res.getString(1);
				String pass=res.getString(2);
				
				if(user.equals(username) && pass.equals(password))
				{
					status=true;
					System.out.println("LOGIN SUCCESS");
				}
				
				
			 }
			 while(status)
			 {
				 if(status)
				 {
				 System.out.println();
				 System.out.println("SELECT OPTION");
				 System.out.println("1:DISPLAY PRODUCT");
				 System.out.println("2:ADD PRODUCT");
				 System.out.println("3:DELETE PRODUCT\n");
				System.out.println("CHOICE ANY ONE OPTION");
				 
				 int choice=sc.nextInt();
				 if(choice==1)
				 {
					 System.out.println();
				    lso.displayProduct(stmt,con,res);
				 }
				 else if(choice==2)
				 {
					 System.out.println("ENTER ID");
					 int id=sc.nextInt();
					 
					 System.out.println("ENTER PRODUCTNAME");
					 String userN=sc.next();
					 
					 System.out.println("ENTER PRICE");
					 Double passW=sc.nextDouble();
					 
					 System.out.println();
					 lso.addProduct1(id, userN, passW,stmt,con);
				 }
				 else if(choice==3)
				 {
					 System.out.println("ENTER ID");
					int pid=sc.nextInt();
					lso.deleteProduct(pid,con,stmt,res);
				 }
				 else {
					 System.out.println("INVALID CHOICE");
				 }
				 
				 
			 }
			 else {
					System.out.println("PLZ ENTER VALID USERNAME AND PASSWORD");
				}
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

public void signup(int id, String username, String password) {
		
		String query1="insert into login_info values("+id+",'"+username+"','"+password+"')";
		try 
		{
			stmt=con.createStatement();
			 int count=stmt.executeUpdate(query1);
			System.out.println("RECORD INSERTED :"+count);
			
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
		
	}
	
public void deleteAccount()
	{
		System.out.println("ENTER YOUR VALID USERNAME AND PASSWORD");
		
		System.out.println("ENTER USERNAME");
		String username=sc.next();
		
		System.out.println("ENTER PASSWORD");
		String pass=sc.next();
		
		 lso.deleteAccount(username,pass,stmt,con,res);
		 System.out.println();
	}


public void availableInfo() {
	System.out.println("AVAILABLE ACOOUNTS ARE :");
	lso.availableAccounts(stmt,con,res);
	
}
	

}
