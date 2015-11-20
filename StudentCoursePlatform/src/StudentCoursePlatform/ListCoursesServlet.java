package StudentCoursePlatform;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ListCoursesServlet
 */
public class ListCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {	
		HttpSession session =null;
		session = request.getSession(true);
		ArrayList<CoursesBean> list = new ArrayList<CoursesBean>();
		ArrayList<ArrayList<CoursesBean>> list1 = new ArrayList<ArrayList<CoursesBean>>();
		CoursesBean courses = new CoursesBean();
		String semester = (request.getParameter("options"));
		ArrayList<String> list2 = new ArrayList<String>();
			if (semester.equals("2"))
			{
				list1=UserDAO.ListAllCourses(list,semester,list2,(String) session.getAttribute("userid"));
			} else 
			{
				list1.add(0,UserDAO.ListCourses(list, semester,list2,(String) session.getAttribute("userid")));
			}
		request.setAttribute("semester", list2);
		request.setAttribute("courses2", list1);
		RequestDispatcher rd = request.getRequestDispatcher("csr.jsp");
		rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
