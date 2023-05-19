package LOGIN;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/thirdlink")
public class Validation extends HttpServlet {
	private static String uName="pranitsahane";
	private static String pass="pass123";
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String userName=req.getParameter("user");
	String password=req.getParameter("pass");
	PrintWriter pw=resp.getWriter();
	
	if(uName.equalsIgnoreCase(userName) && pass.equalsIgnoreCase(password))
	{
		req.setAttribute("username", uName);
		RequestDispatcher rd=req.getRequestDispatcher("fourthlink");
		rd.include(req, resp);
	}
	else {	
		pw.print("<h1  style='color:red'>INVALID USERNAME AND PASSWORD</h1>");
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		rd.include(req, resp);
	}
	
}
}
