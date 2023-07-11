package com.entity;

public class Books {
	
	private int bookId;
	private String authorNAme;
	private String bookName;
	private double bookPrice;
	private double bookRating;
	private String publishedDate;
	private int userId;
	public Books() {
		super();
	}
	public Books(String authorNAme, String bookName, double bookPrice, double bookRating, String publishedDate,
			int userId) {
		super();
		this.authorNAme = authorNAme;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookRating = bookRating;
		this.publishedDate = publishedDate;
		this.userId = userId;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAuthorNAme() {
		return authorNAme;
	}
	public void setAuthorNAme(String authorNAme) {
		this.authorNAme = authorNAme;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public double getBookRating() {
		return bookRating;
	}
	public void setBookRating(double bookRating) {
		this.bookRating = bookRating;
	}
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", authorNAme=" + authorNAme + ", bookName=" + bookName + ", bookPrice="
				+ bookPrice + ", bookRating=" + bookRating + ", publishedDate=" + publishedDate + ", userId=" + userId
				+ "]";
	}
	
	

}
