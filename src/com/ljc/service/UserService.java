package com.ljc.service;

import java.util.List;

import com.ljc.pojo.User;

public interface UserService {
	/**
	 * �û���½
	 * 
	 * @author li jianchun
	 * @param username
	 * @param pass
	 * @return 0��ʾ��½�ɹ���1��ʾ�û������ڣ�2��ʾ�������
	 */
	public int login(String userName, String pass);


	/**
	 * ����û����Ƿ����
	 * 
	 * @author li jianchun
	 * @param username
	 * @return �����ڷ���false�����ڷ���true
	 */

	public boolean isUserNameExist(String userName);

	/**
	 * ��ҳ�õ������û���¼
	 * 
	 * @author li jianchun
	 * @param pageUser
	 * @return
	 */
	public List<User> getUserByPage(int page, int pageCount);
	/**
	 * ע�����û�
	 * 
	 * @author li jianchun
	 * @param user
	 * @return �ɹ�1��ʧ��0
	 */
	
	int register(String userName, String password);

}
