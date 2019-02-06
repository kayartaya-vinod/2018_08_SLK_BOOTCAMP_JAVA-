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
import com.slk.training.entity.Gender;
import com.slk.training.util.DateUtil;

@WebServlet("/add-contact")
public class AddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// since there is no data coming from the client,
		// we should simply redirect the user to the contact-form
		response.sendRedirect("contact-form.jsp");

		// the above function sends a HTTP Response header called "Location"
		// with "contact-form.jsp" and HTTP Response status 302, which
		// makes the browser request for "contact-form.jsp" using GET method.

		// This is also known as Clientside redirection
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// #1: read input from the client request
		Contact c = new Contact();
		c.setFirstname(request.getParameter("firstname"));
		c.setLastname(request.getParameter("lastname"));
		c.setEmail(request.getParameter("email"));
		c.setPhone(request.getParameter("phone"));
		c.setAddress(request.getParameter("address"));
		c.setCity(request.getParameter("city"));
		c.setState(request.getParameter("state"));
		c.setCountry(request.getParameter("country"));

		String strGender = request.getParameter("gender");
		
		Gender gender = strGender==null || strGender.equals("Male") ? Gender.MALE : Gender.FEMALE;
		c.setGender(gender);

		Integer pincode = null;
		try {
			pincode = new Integer(request.getParameter("pincode"));
		} catch (Exception e) {
		}
		c.setPincode(pincode);
		
		c.setBirthDate(DateUtil.toDate(request.getParameter("birthDate")));
		
		
		try {
			// #2: invoke dao/service method
			ContactsDao dao = DaoFactory.getContactsDao();
			
			// if "id" is present in the request and is not equals to "", 
			// then call the dao.updateContact(c)
			// else call the dao.addContact(c)
			
			String strId = request.getParameter("id");
			int x;
			if(strId.equals("")) {
				dao.addContact(c);
				x = 1;
			}
			else {
				c.setId(Integer.parseInt(strId));
				dao.updateContact(c);
				x = 2;
			}
			
			
			// #3: store the model data (if any) in a scope
			// not required in this use case
			
			// #4: forward/redirect to a view

			// serverside redirection (should not be done; not idempotent)
			// request.getRequestDispatcher("success.jsp").forward(request, response);
			
			// use the clientside redirection
			response.sendRedirect("success.jsp?x="+x);

			
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}

}
