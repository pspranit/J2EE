package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookAddService {

	public boolean addBook(String authorName, String bookName, double bookPrice, double bookRating,String pDate,Connection con,int userId) {
		
		PreparedStatement pstmt;
		int count=1;
		boolean status=false;
		String query="insert into book_data(author_name,book_name,book_price,book_rating,published_date,user_id) values(?,?,?,?,?,?)";
		
			try {
				pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, authorName);
				pstmt.setString(2, bookName);
				pstmt.setDouble(3,bookPrice);
				pstmt.setDouble(4, bookRating);
				pstmt.setString(5, pDate);
				pstmt.setInt(6, userId);
				
				count=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		
		if(count >=1)
		{
		status=true;
		}else {
			return status;
		}
		return status;
	}
	

}
