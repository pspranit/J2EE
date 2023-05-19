package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cartlink")
public class CokoiesDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("pName");
		String price=req.getParameter("pPrice");
		String add=req.getParameter("add");
		String show=req.getParameter("show");
		
		if(add!=null)
		{
			Cookie c1=new Cookie(name, price);
			resp.addCookie(c1);
			resp.sendRedirect("index.html");
		}
		else {
			Cookie[] data=req.getCookies();
			PrintWriter pw=resp.getWriter();
			try {
			for(int i=0;i<data.length;i++)
			{
				pw.print("<h1>"+data[i].getName()+"\t"+data[i].getValue()+"</h1>");
			}
			}catch (Exception e) {
				pw.print("<h1>DATA NOT PRESENT</h1>");
			}
		}
	}

}
