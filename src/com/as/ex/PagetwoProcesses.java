package com.as.ex;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PagetwoProcesses
 */
@WebServlet("/PagetwoProcesses")
public class PagetwoProcesses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 String Name=request.getParameter("Name");
	 String address=request.getParameter("address");
	 String id=request.getParameter("id");
	 String Age=request.getParameter("Age");
	 
	 System.out.println("Name is ="+Name);
	 System.out.println("address is ="+address);
	 System.out.println("Id is ="+id);
	 System.out.println("Age is ="+Age);
	 
	 request.getSession().setAttribute("Name",Name);
	 request.getSession().setAttribute("address",address);
	 request.getSession().setAttribute("Id",id);
	 request.getSession().setAttribute("Agee",Age);
	 
	 response.sendRedirect("jsp/printout.jsp");
	}

}
