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

@WebServlet("/deletecontact")
public class DeleteBook extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	int cid=Integer.parseInt(req.getParameter("bid"));
	
	BooksDAO booksDAO=new BooksDAO(DBConnect.getConn());
	
	boolean status=booksDAO.deleteBook(cid);
	
	HttpSession session=req.getSession();
	
	if(status)
	{
		session.setAttribute("successAdd", "Your Book Deleted..");
		resp.sendRedirect("displaybook.jsp");
		
	}else {
		session.setAttribute("erroAdd", "Something wrong on server");
		resp.sendRedirect("editbook.jsp?cid"+cid);
	}
}
}
