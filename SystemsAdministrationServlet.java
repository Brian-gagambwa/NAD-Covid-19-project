package org.health.administration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import databaseconnection.usermanagementDatabase;

import model.usermanagement;

/**
 * Servlet implementation class SystemsAdministrationServlet
 */
@WebServlet("/SystemsAdministrationServlet")
public class SystemsAdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemsAdministrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("Systems.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        String user = request.getParameter("users");
       

       // vaccine vaccine = new vaccine();
        usermanagement user1 = new usermanagement();
        user1.setName(name);
        user1.setEmail(email);
        user1.setPassword(password);
        user1.setAddress(address);
        user1.setContact(contact);
        user1.setUser(user);

        try {
        	usermanagementDatabase.adduser(user1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		RequestDispatcher dispatcher = request.getRequestDispatcher("Systems.jsp");
		dispatcher.forward(request, response);

	}

}
