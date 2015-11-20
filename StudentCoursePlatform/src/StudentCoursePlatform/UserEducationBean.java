package StudentCoursePlatform;

public class UserEducationBean {
	
	private String h_sch_name;
	private String h_sch_type;
	private String t_sch_city;
	private String grad_year;
	private String f_lang;
	
	
public String geth_sch_name(){	
		
		return h_sch_name;	
	}
	
	public void seth_sch_name(String h_sch_name){
		
		this.h_sch_name=h_sch_name;
	}

public String geth_sch_type(){	
		
		return h_sch_type;	
	}
	
	public void seth_sch_type(String h_sch_type){
		
		this.h_sch_type=h_sch_type;
	}
public String gett_sch_city(){	
		
		return t_sch_city;	
	}
	
	public void sett_sch_city(String t_sch_city){
		
		this.t_sch_city=t_sch_city;
	}
public String getgrad_year(){	
		
		return grad_year;	
	}
	
	public void setgrad_year(String grad_year){
		
		this.grad_year=grad_year;
	}
	
public String getf_lang(){	
		
		return f_lang;	
	}
	
	public void setf_lang(String f_lang){
		
		this.f_lang=f_lang;
	}
}
