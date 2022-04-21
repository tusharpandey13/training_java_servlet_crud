package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

/**
 * Servlet implementation class RegDemo
 */
public class RegDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("uid");
		String name=request.getParameter("uname");
		String age= request.getParameter("uage");
		String sal= request.getParameter("usalary");
		String desig=request.getParameter("udesig");
		//System.out.println("hi"+id);

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Pass@123");
		PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?,?,?)");
		//Scanner sc = new Scanner(System.in);
		ps.setString(3,id);
		ps.setString(1,name);
		ps.setString(2,age);
		ps.setString(4,sal);
		ps.setString(5,desig);
		// //1ps.setString(6,pan);
		ps.execute();
		}
		catch(Exception e)
		{
		System.out.println(e);
		}
		finally
		{
		System.out.println("donee");
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
