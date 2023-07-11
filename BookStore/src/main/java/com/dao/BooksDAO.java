package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Books;

public class BooksDAO {

	private Connection con;

	public BooksDAO(Connection con) {
		super();
		this.con = con;
	}

	public boolean addBook(Books book) {
		boolean status = false;

		String query = "insert into book_data (author_name,book_name,book_price,book_rating,published_date,user_id) values(?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, book.getAuthorNAme());
			pstmt.setString(2, book.getBookName());
			pstmt.setDouble(3, book.getBookPrice());
			pstmt.setDouble(4, book.getBookRating());
			pstmt.setString(5, book.getPublishedDate());
			pstmt.setInt(6, book.getUserId());

			int count = pstmt.executeUpdate();

			if (count == 1) {
				status = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<Books> getBooks(int userId) {
		List<Books> list = new ArrayList<Books>();
		Books books = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book_data where user_id=?");
			pstmt.setInt(1, userId);
			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				books = new Books();

				books.setBookId(res.getInt(1));
				books.setAuthorNAme(res.getString(2));
				books.setBookName(res.getString(3));
				books.setBookPrice(res.getDouble(4));
				books.setBookRating(res.getDouble(5));
				books.setPublishedDate(res.getString(6));

				list.add(books);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public Books getBooktById(int cid) {
		Books books = new Books();

		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book_data where book_id=?");
			pstmt.setInt(1, cid);

			ResultSet res = pstmt.executeQuery();

			while (res.next()) {
				books.setBookId(res.getInt(1));
				books.setAuthorNAme(res.getString(2));
				books.setBookName(res.getString(3));
				books.setBookPrice(res.getDouble(4));
				books.setBookRating(res.getDouble(5));
				books.setPublishedDate(res.getString(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	public boolean updateContact(Books book) {
		boolean status = false;

		String query = "update book_data set author_name=?,book_name=?,book_price=?,book_rating=?,published_date=? where book_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);

			pstmt.setString(1, book.getAuthorNAme());
			pstmt.setString(2, book.getBookName());
			pstmt.setDouble(3, book.getBookPrice());
			pstmt.setDouble(4, book.getBookRating());
			pstmt.setString(5, book.getPublishedDate());
			int count = pstmt.executeUpdate();

			if (count == 1) {
				status = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean deleteBook(int cid) {

		boolean status = false;

		String query = "delete from book_data where book_id=?";

		try {

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, cid);

			int count = pstmt.executeUpdate();

			if (count == 1) {
				status = true;
			}

		} catch (SQLException e) {

		}
		return status;
	}
}
