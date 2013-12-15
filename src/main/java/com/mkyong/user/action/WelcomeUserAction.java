package com.mkyong.user.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cma.database.DataBase;

public class WelcomeUserAction{

	
	private List<String> department=new ArrayList<String>();
	private List<String> sub_department=new ArrayList<String>();
	private String sel_dept;
	
	private Connection conn;
	private Statement st;
	
	public String getSel_dept() {
		return sel_dept;
	}

	public void setSel_dept(String sel_dept) {
		this.sel_dept = sel_dept;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	public List<String> getSub_department() {
		return sub_department;
	}

	public void setSub_department(List<String> sub_department) {
		this.sub_department = sub_department;
	}
 public WelcomeUserAction()
 {
	 department.add("Education");
	 department.add("Sanitation");
 }
 
	// all struts logic here
	public String execute() throws SQLException {
		/*conn = DataBase.getConnection();
		st = conn.createStatement();
		String sql="drop table user";
		st.execute(sql);*/
		return "SUCCESS";

	}
}