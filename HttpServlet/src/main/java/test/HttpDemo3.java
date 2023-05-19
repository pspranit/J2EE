package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fourthlink")
public class HttpDemo3 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String [] courses=req.getParameterValues("course");
		PrintWriter pw=resp.getWriter();
		pw.print("<h1>SELECTED COURCES"+"</h1>");
		
		for(int i=0;i<courses.length;i++)
		{
			pw.print("<h2>"+courses[i]+"</h2>");
		}
	}

}
