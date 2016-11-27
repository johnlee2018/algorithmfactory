package com.ljc.dao;


import java.util.List;
import com.ljc.pojo.User;
import com.ljc.pojo.PagePojo;

/**
 * @author HP
 *
 */
public interface UserMDao{
	
	/**
	 * 根据用户名查询单条记录
	 * 
	 * @author li jianchun
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username);
	/**
	 * 根据用户名和密码查询单条记录
	 * 
	 * @author li jianchun
	 * @param user
	 * @return
	 */
	public User getUserByUserNamePass(User user);

	/**
	 * 分页得到所有用户记录
	 * @author li jianchun
	 * @param pagePojo
	 * @return
	 */
	public List <User> getUserByPage(PagePojo pagePojo);
	
	
}