package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCoursesServlet
 */
public class AddCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =null;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String [] courses = new String  [request.getParameterValues("adress").length];
		session = request.getSession(true);
		courses= request.getParameterValues("adress");
		UserDAO.InsertCourses(courses,(String) session.getAttribute("userid"));
		request.setAttribute("updateMessage", "Successfully Added");
		RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
		//response.sendRedirect("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
