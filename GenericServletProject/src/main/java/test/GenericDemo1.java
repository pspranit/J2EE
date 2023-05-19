package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/welcomelink")
public class GenericDemo1 extends GenericServlet {

	private int no;
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		Date d1=new Date();
		PrintWriter pw=resp.getWriter();
//		pw.print(d1);

		pw.print("<h1 style=color:yellow;background-color:grey;>"+d1+"</h1>");
		
		
	}
}
