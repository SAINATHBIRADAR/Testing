package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("uid");
		String name=request.getParameter("uname");
		String age= request.getParameter("uage");
		String sal= request.getParameter("usalary");
		String desig=request.getParameter("udesig");
		try
		{
//			[12:36] Sudipta Singhal

		
			//Class.forName("oracle.jdbc.OracleDriver"); // load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Pass@123");
			PreparedStatement ptstmt = con.prepareStatement("insert into emp values(?,?,?,?,?)");
			
			ptstmt.setString(1, name);
			ptstmt.setString(2, id);
			ptstmt.setString(3, age);
			ptstmt.setString(4, sal);
			ptstmt.setString(5, desig);
			ptstmt.execute();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
