package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.groceryService;

@WebServlet("/glink")
public class groceryController extends HttpServlet {
	
	Connection con=null;
@Override
public void init() throws ServletException {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","sql@123" );

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String itemType=req.getParameter("grocery_item");
		String groceryType=req.getParameter("grocery_type");
		
		groceryService gs=new groceryService();
		try {
			double totalBill=gs.calCulateBill(itemType,groceryType,con);
			
			req.setAttribute("total", totalBill);
			
			RequestDispatcher rd=req.getRequestDispatcher("bill.jsp");
			rd.include(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
