package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Book;
import Service.PaginationService;

@WebServlet("/paginationlink")
public class BookPagination extends HttpServlet {

	Connection con;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pranit", "root", "sql@123");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		String pageStr = req.getParameter("page");

		int startPage = Integer.parseInt(pageStr);

		int totalPages = 5;

		if (startPage == 1) {
			
		} else {
			startPage = startPage - 1;
			startPage = startPage * totalPages + 1;
		}
		
		int userId=(int)req.getSession().getAttribute("userid");

		PaginationService paginationService = new PaginationService();
		List<Book> books = paginationService.getRecords(startPage, totalPages,userId,con);

		HttpSession session=req.getSession();
		session.setAttribute("bookList", books);
		session.setAttribute("pageNo", pageStr);

		RequestDispatcher dispatcher = req.getRequestDispatcher("displaybook.jsp");
		dispatcher.include(req, resp);

	}

}
