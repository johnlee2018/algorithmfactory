package com.ljc.service.impl;

import java.util.List;
import com.ljc.dao.UserMDao;
import com.ljc.dao.impl.UserMDaoImpl;
import com.ljc.pojo.PagePojo;
import com.ljc.pojo.User;
import com.ljc.service.UserService;

/**
 * @author HP
 *
 */
public class UserServiceImpl implements UserService{
	private UserMDao userMDao = new UserMDaoImpl();

	 /**
	 * @author li jianchun
	 * @param userName
	 * @param pass
	 * @return
	 * 
	 */
	 
	@Override
	public int login(String userName, String pass) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPass(pass);
		user.setUserName(userName);
		user=userMDao.getUserByUserNamePass(user);
		if (user==null)
		{
			user=userMDao.getUserByUserName(userName);
			if (user==null)
			{
				return 2;//2 respects the userName doesn't exist; 
			}
			else{
				return 1;//1 respects the password is wrong;
			}
		}
		else
		{
			return 0; //0 respects ok;
		}
	}



	 /**
	 * @author li jianchun
	 * @param userName
	 * @return
	 * 
	 */
	 
	@Override
	public boolean isUserNameExist(String userName) {
		// TODO Auto-generated method stub
		UserMDao userMDao=new UserMDaoImpl();
		User user = userMDao.getUserByUserName(userName);
		if (user==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

	 
	 /**
	 * @author li jianchun
	 * @param page
	 * @param pageCount
	 * @return
	 * 
	 */
	 
	@Override
	public List<User> getUserByPage(int page, int pageCount) {
		// TODO Auto-generated method stub
		PagePojo pagePojo =new PagePojo();
		pagePojo.setPage(pageCount);
		pagePojo.setPage(page);
		List <User> users =userMDao.getUserByPage(pagePojo);
		return users;
	}
	
}