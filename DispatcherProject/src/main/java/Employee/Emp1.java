package Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link1")
public class Emp1 extends HttpServlet {

	private double grossSal;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String eName=req.getParameter("empName");
		String id=req.getParameter("empId");
		String salary=req.getParameter("basicSal");
		
		//parsing
		
		int eId=Integer.parseInt(id);
		int bSalary=Integer.parseInt(salary);
		
		 double HRA=bSalary*0.3;
		  grossSal=bSalary+HRA;
		
		req.setAttribute("HRA", HRA);
		req.setAttribute("grosssal", grossSal);

		
		RequestDispatcher rd=req.getRequestDispatcher("link2");
		rd.include(req, resp);	
		
		double net=(double)req.getAttribute("netsalary");

		double deduction=(double) req.getAttribute("dedSal");
		
		
		PrintWriter pw=resp.getWriter();
		
		
		pw.print("<h1 style='color:red'>EMPLOYEE ID :"+eId+"</h1>");
		
		pw.print("<h1 style='color:green'>EMPLOYEE NAME :"+eName+"</h1>");

		pw.print("<h1 style='color:blue'>GROSS SALARY :"+grossSal+"</h1>");
		
		pw.print("<h1 style='color:pink'>NET SALARY :"+net+"</h1>");
		
		pw.print("<h1 style='color:purple'>HRA SALARY :"+HRA+"</h1>");
		
		pw.print("<h1 style='color:orange'>DEDUCTION SALARY :"+deduction+"</h1>");

		
		
	}
}
