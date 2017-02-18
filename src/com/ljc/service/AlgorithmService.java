package com.ljc.service;
import java.util.List;

import com.ljc.pojo.Algorithm;
import com.ljc.pojo.PagePojo;
import com.ljc.pojo.User;

public interface AlgorithmService{
	


	/**
	 * 检查用户名是否存在
	 * 
	 * @author li jianchun
	 * @param username
	 * @return 不存在返回false，存在返回true
	 */

	public boolean isAlgorithmNameExist(String algorithmName);

	/**
	 * 分页得到所有用户记录
	 * 
	 * @author li jianchun
	 * @param pageUser
	 * @return
	 */
	public List<Algorithm> getAlgorithmByPage(int page, int pageCount);
	

}