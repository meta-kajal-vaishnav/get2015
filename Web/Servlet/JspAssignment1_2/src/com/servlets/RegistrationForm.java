package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
		String msg = "";
		response.setContentType("text/html");
		// checks if first name is empty or not
		if (request.getParameter("fName") == "") {
			msg += "Please enter First Name<br/>";
		}
		// checks that first name should contain only alphabets
		if (request.getParameter("fName").matches("\\d+")) {
			msg += "Only alphabets are allowed in first name<br/>";
		}
		// checks if last name is empty or not
		if (request.getParameter("lName") == "") {
			msg += "Please enter Last Name<br/>";
		}
		// checks that last name should contain only alphabets
		if (request.getParameter("lName").matches("\\d+")) {
			msg += "Only alphabets are allowed in last name<br/>";
		}
		// checks if password is empty or not
		if (request.getParameter("passwd") == "") {
			msg += "Please enter password<br/>";
		}
		// checks that password should have minimum 8 characters
		if (request.getParameter("passwd").length() < 8) {
			msg += "Password should be of minimum 8 characters<br/>";
		}
		// checks if re enter password field is empty or not
		if (request.getParameter("reEnterPasswd") == "") {
			msg += "Please enter password in re enter passwd field<br/>";
		}
		// checks if password matches re entered password
		if (!request.getParameter("passwd").equals(
				request.getParameter("reEnterPasswd"))) {
			msg += "Password doesnot match<br/>";
		}
		// checks if age is empty or not
		if (request.getParameter("age") == "") {
			msg += "Please enter age<br/>";
		}
		// checks if age contain only numeric value
		if (!request.getParameter("age").matches("[0-9]+")) {
			msg += "Please enter numeric value in age<br/>";
		} else
			msg += "User created successfully<br/>";

		request.setAttribute("message", msg);
		RequestDispatcher d = request
				.getRequestDispatcher("RegistrationFormNext");
		d.forward(request, response);
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