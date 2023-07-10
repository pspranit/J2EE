package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookUpdateService {


	public String getUpdateBook(int id, String authorName, String bookName, double bookPrice, double bookRating,
			Connection con) {
		int count=0;
		PreparedStatement pstmt;
		String query="update book_data set author_name=(?),book_name=(?),book_price=(?),book_rating=(?) where book_id=(?)";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setInt(5, id);
			pstmt.setDouble(4, bookRating);
			pstmt.setDouble(3, bookPrice);
			pstmt.setString(2, bookName);
			pstmt.setString(1, authorName);
			
			 count=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(count>=1)
		{
			return "BOOK UPDATED SUCCESSFULLY !!";
		}
		else {
			return "BOOK NOT UPDATED !!";
		}
	}

}
