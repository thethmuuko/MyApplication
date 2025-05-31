package com.samuel.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samuel.service.PersonService;

public class DataController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	PersonService personService = new PersonService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		
		personService.getAll().forEach((v) -> {
			pw.println("<p>Id	: %d </p><br>".formatted(v.getId()));
			pw.println("<p>Name	: %s </p><br>".formatted(v.getName()));
			pw.println("<p>Age	: %d </p><br>".formatted(v.getAge()));
			pw.println("<p>NRC	: %s </p><br>".formatted(v.getNrc()));
			
		});
		
		pw.println("</body>");
		pw.println("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
