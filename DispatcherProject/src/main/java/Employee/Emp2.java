package Employee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/link2")
public class Emp2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		double grossSal=(double) req.getAttribute("grosssal");
		
		double deduction=grossSal*0.05;
		double netSal=grossSal-deduction;
		
		req.setAttribute("netsalary", netSal);
		req.setAttribute("dedSal", deduction);


	}

}
