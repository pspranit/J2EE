package ArithmaticOperations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/arithmaticlink")
public class ArithmaticOperations extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no1=req.getParameter("no1");
		String no2=req.getParameter("no2");
		int num1=Integer.parseInt(no1);
		int num2=Integer.parseInt(no2);
		
		
		int resultAdd=num1+num2;
		int resultSub=num1-num2;
		int resultMulti=num1*num2;
		double resultDiv=num1/num2;
		
		req.setAttribute("addResult", resultAdd);
		req.setAttribute("subResult", resultSub);
		req.setAttribute("multiResult", resultMulti);
		req.setAttribute("divResult", resultDiv);
		
		RequestDispatcher rd=req.getRequestDispatcher("ArithmaticOp.jsp");
		rd.include(req, resp);
		
		
		
	}

}
