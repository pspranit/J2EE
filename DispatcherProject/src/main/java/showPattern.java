import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/showpattern")
public class showPattern extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int row=(int) req.getAttribute("ps1");
		int col=(int) req.getAttribute("ps2");

		PrintWriter pw=resp.getWriter();
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				pw.print("* ");
			}
			col++;
			pw.println();
		}
	}

}
