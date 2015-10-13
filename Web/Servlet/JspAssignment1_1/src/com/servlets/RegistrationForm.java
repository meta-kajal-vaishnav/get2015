package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationForm
 */
// @WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		// checks if first name is empty or not
		if (request.getParameter("fName") == "") {
			out.println("Please enter First Name<br/>");
		}
		// checks that first name should contain only alphabets
		if (request.getParameter("fName").matches("\\d+"))// /^[A-Za-z]+$/
		{
			out.println("Only alphabets are allowed in first name<br/>");
		}
		// checks if last name is empty or not
		if (request.getParameter("lName") == "") {
			out.println("Please enter Last Name<br/>");
		}
		// checks that last name should contain only alphabets
		if (request.getParameter("lName").matches("\\d+")) {
			out.println("Only alphabets are allowed in last name<br/>");
		}
		// checks if password is empty or not
		if (request.getParameter("passwd") == "") {
			out.println("Please enter password<br/>");
		}
		// checks that password should have minimum 8 characters
		if (request.getParameter("passwd").length() < 8) {
			out.println("Password should be of minimum 8 characters<br/>");
		}
		// checks if re enter password field is empty or not
		if (request.getParameter("reEnterPasswd") == "") {
			out.println("Please enter password in re enter passwd field<br/>");
		}
		// checks if password matches re entered password
		if (!request.getParameter("passwd").equals(
				request.getParameter("reEnterPasswd"))) {
			out.println("Password doesnot match<br/>");
		}
		// checks if age is empty or not
		if (request.getParameter("age") == "") {
			out.println("Please enter age<br/>");
		}
		//
		if (!request.getParameter("age").matches("[0-9]+")) {
			out.println("Please enter numeric value in age<br/>");
		} else
			out.println("User created successfully<br/>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
