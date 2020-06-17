package register.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.dao.PersonDao;
import register.model.Person;

/**
 * Servlet implementation class PersonServlet
 */
@WebServlet("/register")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PersonDao personDao =new PersonDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath()); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/Personregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String name= request.getParameter("name");
		String sername= request.getParameter("sername");
		String address= request.getParameter("address");
		String email= request.getParameter("email");
		
		Person person =new Person();
		person.setId(id);
		person.setName(name);
		person.setSername(sername);
		person.setAddress(address);
		person.setEmail(email);
		
		try {
			personDao.registerEmployee(person);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/personDetails.jsp");
		dispatcher.forward(request, response);
	}

}
