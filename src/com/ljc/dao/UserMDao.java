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
	 * �����û�����ѯ������¼
	 * 
	 * @author li jianchun
	 * @param username
	 * @return
	 */
	public User getUserByUserName(String username);
	/**
	 * �����û����������ѯ������¼
	 * 
	 * @author li jianchun
	 * @param user
	 * @return
	 */
	public User getUserByUserNamePass(User user);

	/**
	 * ��ҳ�õ������û���¼
	 * @author li jianchun
	 * @param pagePojo
	 * @return
	 */
	public List <User> getUserByPage(PagePojo pagePojo);
	
	
}