package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterService {

	public boolean addUserAccount(String userName, long newCont, String address, String email, String password,
			String gender, Connection con) {
		
		PreparedStatement pstmt;
		int count=0;
		try {
			pstmt=con.prepareStatement("insert into user_info(username,contact,address,email,gender,password) values(?,?,?,?,?,?)");
			
			pstmt.setString(1, userName);
			pstmt.setLong(2, newCont);
			pstmt.setString(3, address);
			pstmt.setString(4, email);
			pstmt.setString(5, gender);
			pstmt.setString(6, password);
			
			count=pstmt.executeUpdate();
	
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		if(count >0)
		{
			return true;
		}
		else {
			return false;
		}
		
	}

}
