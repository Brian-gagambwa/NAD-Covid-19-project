package org.health.health;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import databaseconnection.healthcentreDatabase;

import model.healthcentre;

/**
 * Servlet implementation class HealthCenterAdministrationModuleServlet
 */
//@WebServlet("/HealthCenterAdministrationModuleServlet")
@WebServlet("/healthcentre")

public class HealthCenterAdministrationModuleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HealthCenterAdministrationModuleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher = request.getRequestDispatcher("healthcentre.jsp");
			dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		
		String healthcentre = request.getParameter("healthcentre");
        String location = request.getParameter("location");
        String vaccinesadministered = request.getParameter("vaccinesadministered");
        String vaccinesdispatched = request.getParameter("vaccinesdispatched");
      
       // vaccine vaccine = new vaccine();
        healthcentre hea = new healthcentre();
        hea.setHealthcentre(healthcentre);
        hea.setLocation(location);
        hea.setVaccinesadministered(vaccinesadministered);
        hea.setVaccinesdispatched(vaccinesdispatched);
       
        try {
            healthcentreDatabase.addhealthcentre(hea);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		 RequestDispatcher dispatcher = request.getRequestDispatcher("healthcentre.jsp");
			dispatcher.forward(request, response);

	}

}
