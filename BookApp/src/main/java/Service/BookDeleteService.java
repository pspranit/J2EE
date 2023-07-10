package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDeleteService {
	ResultSet res;
	public boolean getDeleteBook(int id, Connection con) {
	
		int count=0;
		PreparedStatement pstmt;
		
		try {
			pstmt=con.prepareStatement("delete from book_data where book_id=?");
			pstmt.setInt(1, id);
			count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		if(count>=1)
		{
			return true;
		}
		else {
			return false;
		}
	}

	
	
}
