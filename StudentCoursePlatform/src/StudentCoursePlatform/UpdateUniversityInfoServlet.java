package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUniversityInfoServlet
 */
public class UpdateUniversityInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUniversityInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserUniversityBean user = new UserUniversityBean();
		user.setfaculty(request.getParameter("faculty"));
		user.setdepartment(request.getParameter("department"));
		user.setentry_year(request.getParameter("entryyear"));
		user.setexit_year(request.getParameter("exityear"));
		user=UserDAO.UpdateUniversity(user);
		request.setAttribute("updateMessage", "Successfully Updated");
		RequestDispatcher rd = request.getRequestDispatcher("universityInfo.jsp");
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
