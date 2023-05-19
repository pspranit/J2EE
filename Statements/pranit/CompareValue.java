package pranit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CompareValue {

	public static void main(String[] args) throws SQLException {
		
//		
//		int no1=Integer.parseInt(args[0]);
//		int no2=Integer.parseInt(args[1]);
//		System.out.println(no1+no2);
		
		String user="admin";
		String pass="123";
		
		boolean status=daoOpeartions(user, pass);
		System.out.println(status);
		
	}	

		static boolean daoOpeartions(String user, String pass) throws SQLException {
			Connection con=null;
			 Statement stmt=null;
			ResultSet res=null;
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123");
			
			String query="select username,password from login_info";
			
				stmt=con.createStatement();
				res=stmt.executeQuery(query);
				
				boolean status=true;
				
				 while(res.next())
				 {
					 String uName=res.getString(1);
					 String uPass=res.getString(2);
					 
					 if(user.equals(uName) && pass.equals(uPass))
						{
							status= true;
							break;
						}
						else 
					{
							status= false;
					}
					 
//					 status=((user.equals(uName) && pass.equals(uPass))? true : false);
				 }
				 
				if(status)
				{
					return status;
				}
				else {
					return status;
				}
		}
	}


