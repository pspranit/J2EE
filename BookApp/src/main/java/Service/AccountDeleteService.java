package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDeleteService {

	ResultSet res;
	public boolean deleteAccount(String userName, String password, int userId, String name, String pass2, Connection con) {

		int userCount=0;
		int bookCount=0;
		PreparedStatement pstmt;
		boolean status=false;
		
		String query="select username,password from user_info where id=?";
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
			
			if(userName.equals(name) && password.equals(pass2))
			{
			while(res.next())
			{
				String uName=res.getString(1);
				String pass=res.getString(2);
				
				if(uName.equals(userName) && pass.equals(password))
				{
					status=true;
					break;
					
				}else {
					status=false;
				}
			}
	
			}
			else {
				status=false;
			}
					
				if(status) {
					PreparedStatement pstmt2=con.prepareStatement("delete from user_info where id=?");
					pstmt2.setInt(1, userId);
					
					 userCount=pstmt2.executeUpdate();
				}
				if(status)
				{
					PreparedStatement pstmt3=con.prepareStatement("delete from book_data where user_id=?");
					pstmt3.setInt(1, userId);
					bookCount=pstmt3.executeUpdate();
				}
				else
				{
					return false;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}

}
