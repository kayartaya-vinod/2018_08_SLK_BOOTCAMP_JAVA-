package assignment23.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment23.dao.ArrayListPersonDAO;
import assignment23.dao.PersonDAO;
import assignment23.entity.Person;

@WebServlet("/list-all-persons")
public class ListAllPersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(">>> inside ListAllPersonsServlet.doGet()...");
		
		// #1: read inputs (none for this usecase)
		
		// #2: invoke dao/service
		PersonDAO dao = new ArrayListPersonDAO();
		List<Person> list = dao.getAll();
		
		System.out.printf("There are %d contacts\n", list.size());
		
		// #3: store model data in a scope
		request.setAttribute("persons", list);
		
		// #4: forward/include the view
		request.getRequestDispatcher("./show-persons.jsp")
			.include(request, response);
	}

}
