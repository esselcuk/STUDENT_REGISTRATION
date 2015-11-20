package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateEducationServlet
 */
public class UpdateEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEducationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserEducationBean user = new UserEducationBean();
		user.seth_sch_name(request.getParameter("schoolname"));
		user.seth_sch_type(request.getParameter("schooltype"));
		user.sett_sch_city(request.getParameter("schoolcity"));
		user.setgrad_year(request.getParameter("graduationyear"));
		user.setf_lang(request.getParameter("language"));
		user = UserDAO.UpdateEducation(user);
		request.setAttribute("updateMessage", "Successfully Updated");
		RequestDispatcher rd = request.getRequestDispatcher("education.jsp");
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
