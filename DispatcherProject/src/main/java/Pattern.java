import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pattern")
public class Pattern extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String query=req.getParameter("search");
		
		resp.sendRedirect("https://www.google.com/search?q="+query);
		
		String row=req.getParameter("row");
		String col=req.getParameter("col");
		
		int newRow=Integer.parseInt(row);
		int newCol=Integer.parseInt(col);
		
		req.setAttribute("ps1", newRow);
		req.setAttribute("ps2", newCol);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("showpattern");
		dispatcher.include(req, resp);
		
	}
}
