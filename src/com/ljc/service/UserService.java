package com.ljc.service;

import java.util.List;

import com.ljc.pojo.User;

public interface UserService {
	/**
	 * 用户登陆
	 * 
	 * @author li jianchun
	 * @param username
	 * @param pass
	 * @return 0表示登陆成功，1表示用户不存在，2表示密码错误
	 */
	public int login(String userName, String pass);


	/**
	 * 检查用户名是否存在
	 * 
	 * @author li jianchun
	 * @param username
	 * @return 不存在返回false，存在返回true
	 */

	public boolean isUserNameExist(String userName);

	/**
	 * 分页得到所有用户记录
	 * 
	 * @author li jianchun
	 * @param pageUser
	 * @return
	 */
	public List<User> getUserByPage(int page, int pageCount);
	/**
	 * 注册新用户
	 * 
	 * @author li jianchun
	 * @param user
	 * @return 成功1，失败0
	 */
	
	int register(String userName, String password);

}
