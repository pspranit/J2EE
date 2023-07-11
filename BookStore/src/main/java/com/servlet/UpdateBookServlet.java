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

@WebServlet("/updatebook")
public class UpdateBookServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int cid=Integer.parseInt(req.getParameter("bid"));
		String aname=req.getParameter("aname");
		String bname=req.getParameter("bname");
		double bprice=Double.parseDouble(req.getParameter("bprice"));
		double brating=Double.parseDouble(req.getParameter("brating"));
		String bdate=req.getParameter("bdate");;
		
		Books book=new Books();
		book.setAuthorNAme(bname);
		book.setBookName(bname);
		book.setBookPrice(bprice);
		book.setBookRating(brating);
		book.setPublishedDate(bdate);
		
		BooksDAO contactDAO=new BooksDAO(DBConnect.getConn());
		boolean status=contactDAO.updateContact(book);
		
		HttpSession session=req.getSession();
		
		if(status)
		{
			session.setAttribute("successAdd", "Your Book Updated..");
			resp.sendRedirect("displaybook.jsp");
			
		}else {
			session.setAttribute("erroAdd", "Something wrong on server");
			resp.sendRedirect("editbook.jsp?bid"+cid);
		}
		
		
	}

}
