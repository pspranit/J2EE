package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/eightlink")
public class HttpDemo6 extends HttpServlet{

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

//		PrintWriter pw=resp.getWriter();
		
		String no1=req.getParameter("no1");
		
		String no2=req.getParameter("no2");
		
		int num1=Integer.parseInt(no1);
		int num2=Integer.parseInt(no2);
		
		String [] addmul=req.getParameterValues("btn");
		PrintWriter pw=resp.getWriter();

		for(int i=0;i<addmul.length;i++)
		{
			if(addmul[i].equalsIgnoreCase("add"))
			{
				int result=num1+num2;
			pw.print("<h1 style=color:red;>ADDITION IS :"+"<b style=color:black>"+result+"</b>"+"</h1>");
			}
			else if(addmul[i].equalsIgnoreCase("multi"))
			{

				int result1=num1*num2;
			pw.print("<h1 style=color:red;>MULTIPLICATION IS :"+"<b style=color:black>"+result1+"</b>"+"</h1>");
			}
		}
		
	}
}
