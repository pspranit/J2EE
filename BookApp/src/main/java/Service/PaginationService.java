package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Book;

public class PaginationService {

	ResultSet res;
	public List<Book> getRecords(int startPage, int totalPages,int userId ,Connection con)  {
		
		List<Book> list=new ArrayList<Book>();
		
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select * from book_data WHERE user_id=? limit "+(startPage-1)+","+totalPages);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
			
			while(res.next())
			{
				Book book=new Book();
				
				book.setBookid(res.getInt(1));
				book.setAuthorName(res.getString(2));
				book.setBookName(res.getString(3));
				book.setBookPrice(res.getDouble(4));
				book.setBookRating(res.getDouble(5));
				book.setPublishedDate(res.getString(6));
				book.setUserId(res.getInt(7));
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
