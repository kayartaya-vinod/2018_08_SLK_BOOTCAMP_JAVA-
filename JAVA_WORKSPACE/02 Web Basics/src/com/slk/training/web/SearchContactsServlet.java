package com.slk.training.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;

@WebServlet("/search-contacts")
public class SearchContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// step 1: read inputs from the client request
		String city = request.getParameter("city");
		
		try {
			// step 2: use appropriate model method to get the required data
			ContactsDao dao = DaoFactory.getContactsDao();
			List<Contact> list = dao.getContactsByCity(city);
			
			// step 3: store the model data in appropriate scope (storage location)
			request.setAttribute("contacts", list);
			
			// step 4: forward the request to appropriate view (JSP)
			request.getRequestDispatcher("/show-contacts.jsp").forward(request, response);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}

	}

}
