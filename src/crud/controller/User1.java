package crud.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.dao.UserDAO;
import crud.model.User;

/**
 * Servlet implementation class User1
 */
@WebServlet("/")
public class User1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO ;  
   
    public User1() {
    	this.userDAO =new UserDAO();
    
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.doGet(request, response);
    	
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();
		
		switch(action) {
		case"/new":
			showNewForm(request , response);
			break;
			
		case"/insert":
			try {
				insertUser(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
		case"/delete":
			 try {
				deleteUser(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
		case"/edit":
			try {
				EditForm(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			break;
		case"/update":
			try {
				updateUser(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
			
		default:
			try {
				listUser(request , response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;	
		}
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
				dispatcher.forward(request, response);		
	}

	
	 private void insertUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        String name = request.getParameter("name");
			        String surname = request.getParameter("surname");
			        String email = request.getParameter("email");
			        String address = request.getParameter("address");
			        User newUser = new User(name,surname ,email, address);
			        userDAO.insertUser(newUser);
			        response.sendRedirect("list");
	 }
	 
	 private void deleteUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        userDAO.deleteUser(id);
			        response.sendRedirect("list");

	 }
	 
	 private void EditForm(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, ServletException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        User existingUser = userDAO.selectUser(id);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("userform.jsp");
			        request.setAttribute("user", existingUser);
			        dispatcher.forward(request, response);

	 }
	 private void updateUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException {
			        int id = Integer.parseInt(request.getParameter("id"));
			        String name = request.getParameter("name");
			        String surname = request.getParameter("surname");
			        String email = request.getParameter("email");
			        String address = request.getParameter("address");

			        User user = new User(id, name, surname, email, address);
			        userDAO.updateUser(user);
			        response.sendRedirect("list");
	 }
	 
	 private void listUser(HttpServletRequest request, HttpServletResponse response)
			    throws SQLException, IOException, ServletException {
			        java.util.List < User > listUser = userDAO.selectAllUsers();
			        request.setAttribute("listUser", listUser);
			        RequestDispatcher dispatcher = request.getRequestDispatcher("userlist.jsp");
			        dispatcher.forward(request, response);
			    }
}
