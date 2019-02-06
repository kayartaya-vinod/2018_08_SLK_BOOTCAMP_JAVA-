package com.slk.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;

@WebServlet("/all-contacts")
public class GetAllContactsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		try {
			// 1. read all/any inputs from the http client (browser)
			// for this example, step#1 is skipped
			
			// 2. based on the request, invoke an appropriate Model (Service/DAO,..)
			ContactsDao dao = DaoFactory.getContactsDao();
			List<Contact> list = dao.getContacts();
			
			// 3. store the model data in a specific scope (storage location)
			req.setAttribute("contacts", list);
			
			// 4. forward the control (request/response) to a view (JSP)
			RequestDispatcher rd = req.getRequestDispatcher("/show-contacts.jsp");
			rd.forward(req, resp);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}
}










