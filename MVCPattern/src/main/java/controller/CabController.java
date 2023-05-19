package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CabService;
@WebServlet("/cablink")
public class CabController extends HttpServlet {
	
	CabService cs=new CabService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String km=req.getParameter("km");
		double cabKM=Double.parseDouble(km);
		
//		String ps1="";
//		String[] cab=req.getParameterValues("cab");
//		for(int i=0;i<cab.length;i++)
//		{
//			ps1=(cab[i]);
//		}
		
		String ps1=req.getParameter("cab");
		
		if(ps1.equals("mimi"))
		{
			double miniFair=cs.calMini(cabKM);
			

			req.setAttribute("type", ps1);
			req.setAttribute("totalKM", cabKM );
			req.setAttribute("fairAmt", miniFair);
			RequestDispatcher rd=req.getRequestDispatcher("DisplayFair.jsp");
			rd.include(req, resp);

		}
		else if(ps1.equals("prime"))
		{
			double primeFair=cs.cabPrime(cabKM);
			
//			String nKM=String.valueOf(km);
//			String cabType=String.valueOf(ps1);

			req.setAttribute("type", ps1);
			req.setAttribute("totalKM", cabKM);
			req.setAttribute("fairAmt", primeFair);
			RequestDispatcher rd=req.getRequestDispatcher("DisplayFair.jsp");
			rd.include(req, resp);
			
		}
		
		else if(ps1.equals("micro"))
		{
			double microFair=cs.cabMicro(cabKM);
			

			req.setAttribute("type", ps1);
			req.setAttribute("totalKM", cabKM);
			req.setAttribute("fairAmt", microFair);
			RequestDispatcher rd=req.getRequestDispatcher("DisplayFair.jsp");
			rd.include(req, resp);
		}
	}
}
