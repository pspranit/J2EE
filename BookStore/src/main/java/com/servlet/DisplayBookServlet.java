package com.servlet;
//package com.servlet;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.conn.DBConnect;
//import com.dao.ContactDAO;
//import com.entity.Contact;
//import com.entity.User;
//
//@WebServlet("/dislaycontact")
//public class DisplayContactServlet extends HttpServlet{
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		ContactDAO contactDAO=new ContactDAO(DBConnect.getConn());
//		HttpSession session=req.getSession();
//		
//		User user=(User)session.getAttribute("user");
//		
//		List<Contact> list =contactDAO.getContact(user.getId());
//		
//		
//		if(list != null)
//		{
//			session.setAttribute("contactlist", list);
//			resp.sendRedirect("viewcontact.jsp");
//		}
//		else {
//			session.setAttribute("contactlist", list);
//			resp.sendRedirect("index.jsp");
//		}
//	}
//
//}
