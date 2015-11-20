package StudentCoursePlatform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class UserDAO {

	static Connection currentCon = null;
	
	public static UserBean login(UserBean bean){
		
		String username = bean.getuserId();
		String password = bean.getpassword();
		String firstName = null;
		String lastName = null;
		String userType = null;
		String searchQuery = "select first_name,last_name,user_type from t_user where user_id = ? and password= ? " ;
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		try {
			stmt = currentCon.prepareStatement(searchQuery);
			System.out.println(username + " " + password);
			stmt.setString(1,username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (!rs.next()){
				bean.setValid(false);
				System.out.println("geldi");
				stmt.close();
			} else {
				do {
				firstName = rs.getString("first_name");
				lastName = rs.getString("last_name");
				userType = rs.getString("user_type");
				bean.setValid(true);
				bean.setuserType(userType);
				System.out.println(firstName + " " + lastName + " " + userType);
				} while (rs.next());
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			currentCon.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
		
	}
	
	public static UserBean updateInformation(UserBean bean,UserFamilyBean fbean,UserPlaceBean pbean){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update t_identification_card set gender = ? , nationality = ?, birthdate= ? , religion = ?"
				+ ", blood_type = ?, registration_no = ?";
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			stmt.setString(1,bean.getgender());
			stmt.setString(2,bean.getnationality() );
			stmt.setString(3, bean.getbirthDate());
			stmt.setString(4, bean.getreligion());
			stmt.setString(5, bean.getbloodType());
			stmt.setString(6, bean.getregistrationNo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
	} 
	
	public static UserAdressBean UpdateAdress (UserAdressBean bean){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update t_adress set country = ? , state = ?, city= ? , o_phone = ?"
				+ ", email = ?, adress = ?, post_code = ?, gsm_phone=?";
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt.setString(1,bean.getcountry());
			stmt.setString(2,bean.getstate() );
			stmt.setString(3, bean.getcity());
			stmt.setString(4, bean.geto_phone());
			stmt.setString(5, bean.getemail());
			stmt.setString(6, bean.getadress());
			stmt.setString(7, bean.getpost_code());
			stmt.setString(8, bean.getgsm_phone());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return bean;
}
	public static UserEducationBean UpdateEducation (UserEducationBean bean){
	PreparedStatement stmt = null;
	currentCon = ConnectionManager.getConnection();
	String updateQuery = "update t_education  set h_sch_name = ? , h_sch_type = ?, h_sch_city= ? , grad_year = ?"
			+ ", f_lang = ?";
	try {
		stmt = currentCon.prepareStatement(updateQuery);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		
		stmt.setString(1,bean.geth_sch_name());
		stmt.setString(2,bean.geth_sch_type() );
		stmt.setString(3, bean.gett_sch_city());
		stmt.setString(4, bean.getgrad_year());
		stmt.setString(5, bean.getf_lang());
		stmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return bean;
	}
	
	public static UserUniversityBean UpdateUniversity (UserUniversityBean bean){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update t_university   set faculty = ? , department = ?, entry_year= ? , exit_year = ?";
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			stmt.setString(1,bean.getfaculty());
			stmt.setString(2,bean.getdepartment() );
			stmt.setString(3, bean.getentry_year());
			stmt.setString(4, bean.getexit_year());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
		}
	
	public static UserJobInfoBean UpdateJobInfo (UserJobInfoBean bean){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		String updateQuery = "update t_job   set company_name = ? , position = ?, adress= ? , phone = ?";
		try {
			stmt = currentCon.prepareStatement(updateQuery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			stmt.setString(1,bean.getcompanyName());
			stmt.setString(2,bean.getposition());
			stmt.setString(3, bean.getaddress());
			stmt.setString(4, bean.getphone());

			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
		}
	
	public static void InsertCourses (String [] courses,String userid){
		PreparedStatement stmt = null;
		currentCon = ConnectionManager.getConnection();
		for ( String st : courses) {
			String updateQuery = "insert into t_student_courses values  (? ,? , ? , ?, ?) ";
			try {
				stmt = currentCon.prepareStatement(updateQuery);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.setString(1, userid);
				stmt.setString(2, st);
				stmt.setString(3, "20152");
				stmt.setString(4, "0");
				stmt.setString(5, "");
				stmt.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		
	}
	
	public static ArrayList<CoursesBean> ListCourses (ArrayList<CoursesBean> list, String semester,ArrayList<String> semesterList, String userid) throws SQLException{
		
		PreparedStatement stmt = null;
		String searchquery ="select t1.*,t2.course_name,t2.course_credit from t_student_courses t1, t_course t2 "
				+ "where course_semester = ? and user_id = ? and t2.course_code = t1.course_code";
		currentCon=ConnectionManager.getConnection();
		CoursesBean courses;
		try{
		stmt = currentCon.prepareStatement(searchquery);	
		stmt.setString(1, semester);
		stmt.setString(2, userid);
		semesterList.add(semester);
		ResultSet rs = stmt.executeQuery();
		int index = 0;
		while (rs.next())
		{
			courses = new CoursesBean();
			courses.setcourseCode(rs.getString("course_code"));
			courses.setcourseGrade(rs.getString("course_grade"));
			courses.setcourseStatus(rs.getString("course_status"));
			courses.setcourseSemester(rs.getString("course_semester"));
			courses.setcourseName(rs.getString("course_name"));
			courses.setcourseCredit(rs.getString("course_credit"));
			list.add(index,courses);
			index ++;
		}
		
		} catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return list;
		}
	
		public static ArrayList<ArrayList<CoursesBean>> ListAllCourses(ArrayList<CoursesBean> list, String Semester,ArrayList<String> semesterList,String userid)
		{
		PreparedStatement stmt=null;
		String searchQuery="select distinct course_semester from t_student_courses where user_id = ? order by course_semester asc";
		ArrayList<ArrayList <CoursesBean>> list1 = new ArrayList<ArrayList<CoursesBean>>();
		currentCon = ConnectionManager.getConnection();
		CoursesBean courses = new CoursesBean();
		ArrayList<CoursesBean> list2 = null;
		try 
		{
			stmt = currentCon.prepareStatement(searchQuery);
			stmt.setString(1, userid);
			ResultSet rs = stmt.executeQuery();
			int index = 0;
			while (rs.next())
			{
				list2 = new ArrayList<CoursesBean>();
				list1.add(index,ListCourses(list2, rs.getString("course_semester"),semesterList,userid));
				index++;
			}
			
		
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return list1;
		}

}