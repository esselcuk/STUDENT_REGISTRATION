package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateIdentificationServlet
 */
public class UpdateIdentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIdentificationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserBean user = new UserBean();
		UserPlaceBean userPlace = new UserPlaceBean();
		UserFamilyBean userFamily = new UserFamilyBean();
		user.setidNumber(request.getParameter("id"));
		user.setgender(request.getParameter("gender"));
		user.setnationality(request.getParameter("nationality"));
		user.setbirthDate(request.getParameter("birthdate"));
		user.setreligion(request.getParameter("religion"));
		user.setbloodType(request.getParameter("bloodtype"));
		user.setregistrationNo(request.getParameter("registration_no"));
		userPlace.setProvince(request.getParameter("province"));
		userPlace.setsubProvince(request.getParameter("subprovince"));
		userPlace.setvillage(request.getParameter("village"));
		userPlace.setfamilyNo(request.getParameter("family_no"));
		userPlace.setorderNo(request.getParameter("order_no"));
		userFamily.setmotherName(request.getParameter("mother_name"));
		userFamily.setmotherJob(request.getParameter("mother_job"));
		userFamily.setfatherJob(request.getParameter("father_job"));
		userFamily.setfatherName(request.getParameter("father_name"));
		user = UserDAO.updateInformation(user, userFamily, userPlace);
		request.setAttribute("updateMessage", "Successfully Updated");
		RequestDispatcher rd = request.getRequestDispatcher("identification.jsp");
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
