package com.slk.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;

// not used anywhere; just kept for reference

// @WebServlet("/all-contacts")
public class GetAllContactsServlet_old extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		out.println("<h1>List of contacts...</h1>");
		out.println("<hr />");
		out.println("<ul>");

		try {
			ContactsDao dao = DaoFactory.getContactsDao();
			List<Contact> list = dao.getContacts();
			for (Contact c : list) {
				out.printf("<li>%s %s</li>", c.getFirstname(), c.getLastname());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}

		out.println("</ul>");
		out.close();

	}

}
