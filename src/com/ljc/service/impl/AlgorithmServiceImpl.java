package com.ljc.service.impl;

import java.util.List;

import com.ljc.dao.AlgorithmMDao;
import com.ljc.dao.impl.AlgorithmMDaoImpl;
import com.ljc.pojo.Algorithm;
import com.ljc.pojo.PagePojo;
import com.ljc.service.AlgorithmService;

public class AlgorithmServiceImpl implements AlgorithmService {
	AlgorithmMDao algorithmMDao=new AlgorithmMDaoImpl();
	@Override
	public boolean isAlgorithmNameExist(String algorithmName) {
		
		Algorithm algorithm = algorithmMDao.getAlgorithmByAlgorithmName(algorithmName);
		if (algorithm==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}


	@Override
	public List <Algorithm> getAlgorithmByPage(int page, int pageCount) {
		// TODO Auto-generated method stub
		PagePojo pagePojo =new PagePojo();
		pagePojo.setPage(pageCount);
		pagePojo.setPage(page);
		List <Algorithm> algorithms =algorithmMDao.getAlgorithmByPagePojo(pagePojo);
		return algorithms;

	}
}
