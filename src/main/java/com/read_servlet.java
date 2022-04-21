package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.sql.*;

/**
 * Servlet implementation class read_servlet
 */
public class read_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public read_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("uid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","Pass@123");
			PreparedStatement ps = con.prepareStatement("select * from emp where id = ?");
			ps.setString(1,id);
			ResultSet R = ps.executeQuery();
			ResultSetMetaData md = R.getMetaData();
			int colCount = md.getColumnCount();
			ArrayList<String> tmpv = new ArrayList<String>();
			for (int i = 1; i <= colCount ; i++){
				String col_name = md.getColumnName(i);
				tmpv.add(col_name);
			}
			while(R.next()) {
				// System.out.println(R.getInt("ID") + " : " + R.getString(5));
				// System.out.println(R.getString());
				// for(int i = 0;i < colCount; i++) {
				// System.out.println(R.getString(i) + ", ");
				// }
				for(int i = 0; i < colCount; i++) 
					response.getWriter().println(tmpv.get(i)+ " : "+R.getString(tmpv.get(i)));
			}

		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			System.out.println("donee");
		}
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
