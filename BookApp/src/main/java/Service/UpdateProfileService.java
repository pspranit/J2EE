package Service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletResponse;

public class UpdateProfileService {

	ResultSet res;
	public boolean getUpdateProfile(int userId, String userName, long newCont, String address, String email,
			String password, String gender, Connection con, HttpServletResponse resp) {
		
		PreparedStatement pstmt;
		Statement stmt;
		int count=0;
		PrintWriter pw = null;
		try {
			 pw=resp.getWriter();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			stmt=con.createStatement();
			res=stmt.executeQuery("select * from user_info");
			
			while(res.next())
			{
				if(res.getInt(1)==userId)
				{
					pstmt=con.prepareStatement("update user_info set username=(?),contact=(?),address=(?),email=(?),gender=(?),password=(?) where id=(?)");
					pstmt.setInt(7, userId);
					pstmt.setString(6, password);
					pstmt.setString(5, gender);
					pstmt.setString(4, email);
					pstmt.setString(3, address);
					pstmt.setLong(2, newCont);
					pstmt.setString(1, userName);
					
					 count=pstmt.executeUpdate();
					break;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(count > 0)
		{
			return true;
		}
		else {
			return false;
		}
	}

}
