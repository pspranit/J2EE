package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/thirdlink")
public class HttpDemo2 extends HttpServlet{
	
	static String sUser="pranit";
	static String sPass="pass123";
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("user");
		String password=req.getParameter("pass");
		
		PrintWriter pw=resp.getWriter();
		
		if(sUser.equals(username) && sPass.equals(password))
		{
			pw.print("<h1> VALID USERNAME AND PASSWORD"+"</h1>");
		}
		else {
			pw.print("<h1> INVALID USERNAME AND PASSWORD"+"</h1>");

		}
	}

}
