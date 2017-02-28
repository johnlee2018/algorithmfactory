package com.ljc.dao;

import java.util.List;

import com.ljc.pojo.Algorithm;
import com.ljc.pojo.PagePojo;

/**
 * @author lijianchun
 *
 */
public interface AlgorithmMDao{ 
	
	/**
	 * get one algorithm by id
	 * @author li jianchun
	 * @param algorithmName
	 * @return
	 */
	
	public Algorithm getAlgorithmById(int id);
	
	/**
	 * get one algorithm by algorthm
	 * @author li jianchun
	 * @param algoritm
	 * @return
	 */

	public Algorithm getAlgorithmByAlgorithmName(String algorithmName);
	
	/**
	 * get one algorithm by algorthm
	 * @author li jianchun
	 * @param algoritm
	 * @return
	 */
	public Algorithm getAlgorithmByAlgorithmFunction(String  function);

	/**
	 * get algorithms by page
	 * @author li jianchun
	 * @param pagePojo
	 * @return
	 */
	public List <Algorithm> getAlgorithmByPagePojo(PagePojo pagePojo );

	/**
	 * @author li jianchun
	 * @param name
	 * @param function
	 * @return
	 * 
	 */
	public int insertAlgorithmNameFunction(String name, String function);
}