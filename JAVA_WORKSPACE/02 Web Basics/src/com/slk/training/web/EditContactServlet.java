package com.slk.training.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.training.dao.ContactsDao;
import com.slk.training.dao.DaoException;
import com.slk.training.dao.DaoFactory;
import com.slk.training.entity.Contact;

@WebServlet("/edit-contact")
public class EditContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			ContactsDao dao = DaoFactory.getContactsDao();
			Contact contact = dao.getContact(id);
			
			request.setAttribute("ct", contact);
			request.setAttribute("title", "Edit contact details");
			
			request.getRequestDispatcher("./contact-form.jsp")
				.forward(request, response);
			
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
