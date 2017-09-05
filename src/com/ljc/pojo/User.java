package com.ljc.pojo;
//对应数据库中每张表的属性
public class User {
	private int id;
	private int level;
	private String userName;
	private String pass;

	public User(){};
	public User(int id,int level,String userName,String pass){
		this.id=id;
		this.level=level;
		this.userName=userName;
		this.pass=pass;
	};
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
