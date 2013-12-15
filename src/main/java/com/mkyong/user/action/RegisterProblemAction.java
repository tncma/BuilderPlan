package com.mkyong.user.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.cma.database.DataBase;
import com.opensymphony.xwork2.Action;


public class RegisterProblemAction implements Action,SessionAware{
	private String name;
	private int doorno;
	private int pri_value;
	private String sub_dept;
	private String comp_text;
	private String street;
	private String village;
	private String district;
	private String operation;
	private String gender;
	private String telephone;
	private String mobileno;
	private String pincode;
	private String emailid;
	private Connection conn;
	private Statement st;
	private String dept;
	private Map<String,Integer> Session=new HashMap<String, Integer>();
	private List<String> sub_department=new ArrayList<String>();
	private List<Integer> Priority=new ArrayList<Integer>();

	public List<String> getSub_department() {
		return sub_department;
	}

	public void setSub_department(List<String> sub_department) {
		this.sub_department = sub_department;
	}

	public int getPri_value() {
		return pri_value;
	}

	public void setPri_value(int pri_value) {
		this.pri_value = pri_value;
	}

	public String getSub_dept() {
		return sub_dept;
	}

	public void setSub_dept(String sub_dept) {
		this.sub_dept = sub_dept;
	}

	public String getComp_text() {
		return comp_text;
	}

	public void setComp_text(String comp_text) {
		this.comp_text = comp_text;
	}

	public List<Integer> getPriority() {
		return Priority;
	}

	public void setPriority(List<Integer> priority) {
		Priority = priority;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDoorno() {
		return doorno;
	}

	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String execute() throws Exception {
		int id = 0;
		conn = DataBase.getConnection();
		st = conn.createStatement();
		String sql = "insert into user values (NULL,'"+name+ "','" + doorno +"','"+street+"','"+village+"','"+district+"','"+gender+"','"+telephone+"','"+mobileno+"','"+pincode+"','"+emailid+"')";
		
		st.executeUpdate(sql);
		PreparedStatement ps=null;
		sql="select user_id from user where user.name=?";
		ps=conn.prepareStatement(sql);
		
		ps.setString(1,name);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			id=rs.getInt(1);
		}
		System.out.println(id);
	
		Session.put("Id",id);
		
		checkdept();
		return "SUCCESS";
	}
	
	public String reg_complaint() throws Exception {
		conn = DataBase.getConnection();
		st = conn.createStatement();
		int id=Integer.parseInt(Session.get("Id").toString());
		Session.clear();
		String sql = "insert into complaint values('"+id+ "','" +sub_dept+"','"+comp_text+"','"+pri_value+"')";
		st.executeUpdate(sql);
		checkdept();
		return "SUCCESS";
	}
	
	public void checkdept() throws SQLException
	 {
		int id=0;
		 conn = DataBase.getConnection();
			st = conn.createStatement();
			PreparedStatement ps=null;
			String sql="select dept_id from department where department.name=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,dept);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
			}
			System.out.println(id);
			ps.close();
			String sql1 = "select sub_department.name from sub_department where sub_department.dept_id =?";
			ps=conn.prepareStatement(sql1);
			ps.setInt(1, id);
		   rs=ps.executeQuery();
			while(rs.next()) 
			{
				
				//System.out.println(rs.toString());
				sub_department.add(rs.getString(1));
			}
			Priority.add(1);
			Priority.add(2);
			Priority.add(3);
	 }

	@Override
	public void setSession(Map session) {
		this.Session=session;
		
	}
	

}
