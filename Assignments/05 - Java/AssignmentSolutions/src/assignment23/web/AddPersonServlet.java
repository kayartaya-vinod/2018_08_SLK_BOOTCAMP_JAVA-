package assignment23.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import assignment23.dao.ArrayListPersonDAO;
import assignment23.dao.PersonDAO;
import assignment23.entity.Person;

@WebServlet("/add-person")
public class AddPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("./");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(">>> inside AddPersonServlet.doPost()...");

		// #1: read inputs
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		Person person = new Person(firstname, lastname, phone, email);

		// #2: invoke DAO/service method
		PersonDAO dao = new ArrayListPersonDAO();
		dao.insert(person);

		// #3: store model data in the scope (not required for this usecase)

		// #4: redirect (idempotent, converting POST request to GET request)
		response.sendRedirect("./");
	}

}
