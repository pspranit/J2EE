package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sixlink")
public class HttpDemo5 extends HttpServlet{
	static String str1="hr";
	static String str2="manager";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String eName=req.getParameter("empName");
			
			String current=req.getParameter("empSalary");
			
			double eSalary=Double.parseDouble(current);
			
			String designation=req.getParameter("designation");
			
			PrintWriter pw=resp.getWriter();

			
			if(designation.equals(str1))
			{
				double hrSalary=eSalary+eSalary*0.2;
//				pw.print("HR INCREMENTED SALARY BY 20% :"+hrSalary);
				pw.print("<h1 style=color:purple;> HR incremented salary 20% :"+"<b style=color:black;>"+hrSalary+"</b>"+"</h1>");
			}
			else if(designation.equals(str2))
			{
				double mgrSalary=eSalary+eSalary*0.3;
//				pw.print("MANAGER INCREMENTED SALARY BY 30% :"+mgrSalary);
				pw.print("<h1 style=color:red;>MANAGER incremented salary 30% :"+"<b style=color:black;>"+mgrSalary+"</b>"+"</h1>");

			}
					
	}

}

