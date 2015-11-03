package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connutil.ConnectionUtil;

import java.sql.*;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		RequestDispatcher rd = null;
		con = conUtil.getConnection();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String query = "SELECT password FROM Register WHERE username = '"+ username + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next())
			{
				if (rs.getString("password").equals(password)) {
					request.setAttribute("Message", "User Successfully logged in");
					rd = request.getRequestDispatcher("/view/Success.jsp");
					rd.forward(request, response);
				} else {
					request.setAttribute("Message", "Incorrect Password");
					rd = request.getRequestDispatcher("/view/Error.jsp");
					rd.forward(request, response);
				}
			}else {
				request.setAttribute("Message", "Incorrect Username");
				rd = request.getRequestDispatcher("/view/Error.jsp");
				rd.forward(request, response);
			}

		} catch (SQLException e) {
			request.setAttribute("Message", (Object) e.toString());
			rd = request.getRequestDispatcher("/view/Error.jsp");
			rd.forward((ServletRequest) request, (ServletResponse) response);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
