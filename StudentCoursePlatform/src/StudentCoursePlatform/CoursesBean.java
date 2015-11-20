package StudentCoursePlatform;

import java.util.ArrayList;

public class CoursesBean {
	private String courseCode;
	private String courseSemester;
	private String courseStatus;
	private String courseGrade;
	private String courseName;
	private String courseCredit;
	private ArrayList<CoursesBean> list;
	
	public String getcourseCode(){
		return courseCode;
	}
	
	public void setcourseCode(String courseCode){	
		this.courseCode = courseCode;	
	}
	
	public String getcourseSemester(){
		return courseSemester;
	}
	
	public void setcourseSemester(String courseSemester){	
		this.courseSemester = courseSemester;	
	}
	
	public String getcourseStatus(){
		return courseStatus;
	}
	
	public void setcourseStatus(String courseStatus){	
		this.courseStatus = courseStatus;	
	}
	
	public String getcourseGrade(){
		return courseGrade;
	}
	
	public void setcourseGrade(String courseGrade){	
		this.courseGrade = courseGrade;	
	}
	
	public void setcourseName(String courseName){	
		this.courseName = courseName;	
	}
	
	public String getcourseName(){
		return courseName;
	}
	
	public void setcourseCredit(String courseCredit){	
		this.courseCredit = courseCredit;	
	}
	
	public String getcourseCredit(){
		return courseCredit;
	}
	
	public ArrayList<CoursesBean> getlist(){
		return list;
	}
	
	public void setlist(ArrayList<CoursesBean> list){	
		this.list = list;	
	}
}
