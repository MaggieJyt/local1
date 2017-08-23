package com.jyt.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.jyt.dao.UserDao;
import com.jyt.entity.Student;

public class LoginAction implements RequestAware {

	private String username;
	private String pwd;
	private Map<String, Object> request;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String execute() {
		UserDao userDao = new UserDao();
		Student user = new Student();
		user.setName(username);
		user.setPassword(pwd);
		System.out.println("action  " + username + pwd);
		if (userDao.Login(user)) {
			request.put("username", username);
			return "success";
		} else
			return "fail";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}
}