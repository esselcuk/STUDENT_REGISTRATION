package StudentCoursePlatform;

public class UserBean {

	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String userType;
	private String idNumber;
	private String gender;
	private String nationality;
	private String birthDate;
	private String religion;
	private String bloodType;
	private String gsmPhone;
	private String registrationNo;
	public boolean valid;
	
	public String getuserId(){	
		
		return userId;	
	}
	
	public void setuserId(String userId){
		
		this.userId=userId;
	}
	
	public String getpassword(){	
		
		return password;	
	}
	
	public void setpassword(String password){
		
		this.password=password;
	}
	
	public String getfirstName(){	
		
		return firstName;	
	}
	
	public void setfirstName(String firstName){
		
		this.firstName=firstName;
	}
	public String getlastName(){	
		
		return lastName;	
	}
	
	public void setlastName(String lastName){
		
		this.lastName=lastName;
	}

public String getuserType(){	
		
		return userType;	
	}
	
	public void setuserType(String userType){
		
		this.userType=userType;
	}
public String getidNumber(){	
		
		return idNumber;	
	}
	
	public void setidNumber(String idNumber){
		
		this.idNumber=idNumber;
	}
public String getgender(){	
		
		return gender;	
	}
	
	public void setgender(String gender){
		
		this.gender=gender;
	}
	
public String getnationality(){	
		
		return nationality;	
	}
	
	public void setnationality(String nationality){
		
		this.nationality=nationality;
	}
	
public String getbirthDate(){	
		
		return birthDate;	
	}
	
	public void setbirthDate(String birthDate){
		
		this.birthDate=birthDate;
	}
	
public String getreligion(){	
		
		return religion;	
	}
	
	public void setreligion(String religion){
		
		this.religion=religion;
	}
	
public String getbloodType(){	
		
		return bloodType;	
	}
	
	public void setbloodType(String bloodType){
		
		this.bloodType=bloodType;
	}
	
public String getgsmPhone(){	
		
		return gsmPhone;	
	}
	
	public void setgsmPhone(String gsmPhone){
		
		this.gsmPhone=gsmPhone;
	}
	
public String getregistrationNo(){	
		
		return registrationNo;	
	}
	
	public void setregistrationNo(String registrationNo){
		
		this.registrationNo=registrationNo;
	}
	
	public boolean isValid(){
		return valid;
		
	}
	public void setValid(boolean valid){
		
		this.valid=valid;
	}
}
