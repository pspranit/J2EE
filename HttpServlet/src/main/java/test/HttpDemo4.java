package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fivelink")
public class HttpDemo4 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstName=req.getParameter("first");
		String lastName=req.getParameter("last");
		
		String cNo=req.getParameter("cont");
		long cont=Long.parseLong(cNo);
		
		String ps="";
		String[] gender=req.getParameterValues("gender");
		for(int i=0;i<gender.length;i++)
		{
			ps=(gender[i]);
		}
		
		String ps1="";
		String[] branch=req.getParameterValues("branch");
		for(int i=0;i<branch.length;i++)
		{
			ps1=(branch[i]);
		}
		
		PrintWriter pw=resp.getWriter();

		pw.print("<table border=1px rules=all>"+
		
				"<tr cellspacing=10px bgcolor=yellow cellpadding=10px rules=all>"+
				"<th>"+"FIRSTNAME"+"</th>"+
				"<th>"+"LASTNAME"+"</th>"+
				"<th>"+"CONT_NO"+"</th>"+
				"<th>"+"GENDER"+"</th>"+
				"<th>"+"BRANCH"+"</th>"+
				"</tr>"+
				
				"<tr >"+
				"<td>"+firstName+"</td>"+
				"<td>"+lastName+"</td>"+
				"<td>"+cont+"</td>"+
				"<td>"+ps+"</td>"+
				"<td>"+ps1+"</td>"+
				"</tr>"+
				"</table>");


		
		
	}

}
