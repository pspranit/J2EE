package PRODUCT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/onelink")
public class One extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String qty=req.getParameter("productqty");
		int pQty=Integer.parseInt(qty);
		
		String oprice=req.getParameter("productprice");
		int pPrice=Integer.parseInt(oprice);
		
		PrintWriter pw=resp.getWriter();

		double total=pPrice*pQty;
		
		pw.print("<h1 style='color:purple'>TOTAL AMMOUNT :"+total+"</h1>");
		req.setAttribute("gst", total);
		
		RequestDispatcher rd=req.getRequestDispatcher("twolink");
		rd.include(req, resp);		
		
//		
//		Two two = new Two();
//		
//		two.returnTotal(req, resp, total);
		
	}
}
