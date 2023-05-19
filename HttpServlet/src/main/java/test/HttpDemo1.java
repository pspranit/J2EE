package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondlink")
public class HttpDemo1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no1=req.getParameter("no1");
		String no2=req.getParameter("no2");
		int num1=Integer.parseInt(no1);
		int num2=Integer.parseInt(no2);
		int result=num1+num2;
		
		PrintWriter pw=resp.getWriter();
		pw.print("<h1 style=color:red;>ADDITION IS :"+result+"</h1>");
		
			
	}

}
