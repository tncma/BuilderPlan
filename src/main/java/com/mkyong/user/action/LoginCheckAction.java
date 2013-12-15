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
import com.opensymphony.xwork2.ActionSupport;


public class LoginCheckAction extends ActionSupport implements SessionAware{

	Map Session=new HashMap();
	private String name;
	private String password;
	private Connection conn;
	private Statement st;
	private List<String> messages=new ArrayList<String>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setSession(Map Session) {
		this.Session=Session;	
	}
	
	public String display() throws SQLException
	{
		int sub_id=Integer.parseInt(Session.get("subid").toString());
		conn = DataBase.getConnection();
		st = conn.createStatement();
		PreparedStatement ps=null;
		String sql="select text from complaint where sub_=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,sub_id);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			messages.add(rs.getString(1));
		}
		System.out.println(messages.get(0));
		return SUCCESS;
	}
	public String check() throws SQLException
	{
		boolean found=false;
		int sub_id=0;
		conn = DataBase.getConnection();
		st = conn.createStatement();
		PreparedStatement ps=null;
		String sql="select * from admin where name=? and password=?";
		ps=conn.prepareStatement(sql);
		System.out.println(getName());
		System.out.println(getPassword());
		ps.setString(1,getName());
		ps.setString(2,getPassword());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			sub_id=rs.getInt(5);
			System.out.println("suBID"+sub_id);
			Session.put("subid",sub_id);
			found=true;
		}
		if(found)
		return "SUCCESS";
		else 
			return "ERROR";
	}
	public Map getSession() {
		return Session;
	}

}
