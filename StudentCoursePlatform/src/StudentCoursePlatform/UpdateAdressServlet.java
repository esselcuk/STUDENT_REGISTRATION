package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateAdressServlet
 */
public class UpdateAdressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdressServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		UserAdressBean user = new UserAdressBean();
		user.setadress(request.getParameter("adress"));
		user.setstate(request.getParameter("state"));
		user.setcity(request.getParameter("city"));
		user.setpost_code(request.getParameter("postalcode"));
		user.setgsm_phone(request.getParameter("phone"));
		user.setemail(request.getParameter("email"));
		user=UserDAO.UpdateAdress(user);
		request.setAttribute("updateMessage", "Successfully Updated");
		RequestDispatcher rd = request.getRequestDispatcher("adress.jsp");
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
