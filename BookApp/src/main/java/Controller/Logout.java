package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet("/logoutlink")
public class Logout extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		HttpSession session=req.getSession();
		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("contact");
		session.removeAttribute("address");
		session.removeAttribute("email");
		session.removeAttribute("gender");
		session.removeAttribute("password");
	
		resp.sendRedirect("login.html");
	}

}
