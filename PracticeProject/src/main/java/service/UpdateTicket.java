package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTicket {


	public int updateTicket(int decreaseTicket, int ticket, String movieName, Connection con) throws SQLException {
		
		PreparedStatement pstmt=null;
		
		String query="update movie set no_of_tickets_available=(?) where m_name=(?)";
		pstmt=con.prepareStatement(query);
		
		pstmt.setInt(1, decreaseTicket);
		pstmt.setString(2, movieName);
		
		int count=pstmt.executeUpdate();
		return count;
	}

}
