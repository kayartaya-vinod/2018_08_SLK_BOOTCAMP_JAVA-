package assignment23.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment23.dao.ArrayListPersonDAO;
import assignment23.dao.PersonDAO;

@WebServlet("/delete-person")
public class DeletePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// #1
		int id = Integer.parseInt(request.getParameter("id"));
		
		// #2
		PersonDAO dao = new ArrayListPersonDAO();
		dao.delete(id);
		
		// #3 (N/A)
		
		// #4
		response.sendRedirect("./");
		
	}

}
