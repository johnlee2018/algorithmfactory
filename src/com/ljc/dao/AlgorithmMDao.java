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
	 * get one algorithm by algorthmName
	 * @author li jianchun
	 * @param algorithmName
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
}