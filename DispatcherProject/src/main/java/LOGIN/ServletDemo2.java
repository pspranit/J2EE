package LOGIN;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/secondlink")
public class ServletDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		PrintWriter pw=resp.getWriter();
		
		PrintWriter pw=(PrintWriter) req.getAttribute("printWriter");

		pw.print("<h1 style='color:green'>RESPONSE FROM SECOND SERVLET</h1>");

	}

}
