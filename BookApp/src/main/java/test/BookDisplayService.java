package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Book;

public class BookDisplayService {
	
	ResultSet res;
	PrintWriter pw;
	int count=0;
	ArrayList arrayList=new ArrayList();
	public ArrayList displayBooks(Connection con, HttpServletResponse resp,HttpServletRequest req,int userId) 
	{
		
		
		try {
			pw = resp.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		PreparedStatement pstmt;
		try {
			
			String query="SELECT * FROM book_data where user_id=?";
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, userId);
			res=pstmt.executeQuery();
		
			

			
			while(res.next())
			{
				int id=res.getInt(1);
				String authorName=res.getString(2);
				String bookName=res.getString(3);
				double bookPrice=res.getDouble(4);
				double rating=res.getDouble(5);
				Date date=res.getDate(6);
				int uId=res.getInt(7);
				
				arrayList.add(id);
				arrayList.add(authorName);
				arrayList.add(bookName);
				arrayList.add(bookPrice);
				arrayList.add(rating);
				arrayList.add(date);
				arrayList.add(uId);
				
				count++;			
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return arrayList;
	}
	
	public int getCount() {
		return count;
		
	}

	

}
