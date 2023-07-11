package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.dao.BooksDAO;
import com.entity.Books;


@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int userId=Integer.parseInt(req.getParameter("userId"));
	String aname=req.getParameter("aname");
	String bname=req.getParameter("bname");
	double bprice=Double.parseDouble(req.getParameter("bprice"));
	double brating=Double.parseDouble(req.getParameter("brating"));
	String bdate=req.getParameter("bdate");;
	
	BooksDAO booksDAO=new BooksDAO(DBConnect.getConn());
	Books books =new Books(aname, bname, bprice, brating, bdate, userId);
	
	boolean status=booksDAO.addBook(books);
	HttpSession session=req.getSession();
	
	if(status)
	{
		session.setAttribute("successAdd", "Book Add Successfully");
		resp.sendRedirect("addbook.jsp");
		
	}else {
		session.setAttribute("erroAdd", "Something wrong on server");
		resp.sendRedirect("addbook.jsp");
	}
	
}
}
