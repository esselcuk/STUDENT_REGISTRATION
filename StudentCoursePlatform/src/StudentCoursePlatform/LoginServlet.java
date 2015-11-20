package StudentCoursePlatform;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		UserBean user = new UserBean();
		user.setuserId(request.getParameter("un"));
		user.setpassword(request.getParameter("pass"));
		user= UserDAO.login(user);
		if(user.isValid())
		{
			 session = request.getSession(true);
			// request.setAttribute("userid", user.getuserId());
			session.setAttribute("userid", user.getuserId());
			if (user.getuserType().equals("0")){
			//response.sendRedirect("studentLogged.jsp");
				 System.out.println((String)request.getAttribute("userid") + "ekledim"); 
			RequestDispatcher rd = request.getRequestDispatcher("studentLogged.jsp");
			rd.forward(request, response);
			}
			else {
			//	response.sendRedirect("advisorLogged.jsp");
				RequestDispatcher rd = request.getRequestDispatcher("advisorLogged.jsp");
				rd.forward(request, response);
			}
			
		} else {
			session = request.getSession(true);
			session.invalidate();
			request.setAttribute("errorMessage", "Login Failed, please try again");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			//response.sendRedirect("login.jsp");
			rd.forward(request, response);
			
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
