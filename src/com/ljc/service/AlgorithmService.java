package com.ljc.service;
import java.util.List;

import com.ljc.pojo.Algorithm;
import com.ljc.pojo.PagePojo;
import com.ljc.pojo.User;

public interface AlgorithmService{
	


	/**
	 * ����û����Ƿ����
	 * 
	 * @author li jianchun
	 * @param username
	 * @return �����ڷ���false�����ڷ���true
	 */

	public boolean isAlgorithmNameExist(String algorithmName);

	/**
	 * ��ҳ�õ������û���¼
	 * 
	 * @author li jianchun
	 * @param pageUser
	 * @return
	 */
	public List<Algorithm> getAlgorithmByPage(int page, int pageCount);
	

}