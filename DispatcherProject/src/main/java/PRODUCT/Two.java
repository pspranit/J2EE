	package PRODUCT;
	
	import java.io.IOException;
	import java.io.PrintWriter;
	
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	@WebServlet("/twolink")
	public class Two extends HttpServlet {
	
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			double gstTotal=(double) req.getAttribute("gst");
			PrintWriter pw=resp.getWriter();
			
			double gst=gstTotal+gstTotal*0.02;
			pw.print("<h1 style='color:red'>TOTAL AMMOUNT WITH GST OF 5% :"+gst+"</h1>");
			
		}
	
	
	//	public static void returnTotal(HttpServletRequest req, HttpServletResponse resp,double total) {
	//		PrintWriter pw;
	//		try {
	//			pw = resp.getWriter();
	//			double gst=total+total*0.02;
	//			pw.print("<h1>TOTAL AMMOUNT add 5% GST :"+gst+"</h1>");
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//		
	//
	//	}
		
	}
	
