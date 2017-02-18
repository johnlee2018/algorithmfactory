package com.ljc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.sql.Connection;
import java.util.List;

import com.ljc.dao.AlgorithmMDao;
import com.ljc.pojo.Algorithm;
import com.ljc.pojo.PagePojo;
import com.ljc.util.DBUtil;

public class AlgorithmMDaoImpl implements AlgorithmMDao 
	{

	
	@Override
	public Algorithm getAlgorithmById(int id) {
		Connection conn=null;
		PreparedStatement psta=null;
		ResultSet rs=null;
		Algorithm algorithm=null;
		String sql=null;
		try 
		{
			conn=DBUtil.getConnection();
			sql="select id,name,function from  where id=? ";
			psta=conn.prepareStatement(sql);
			psta.setLong(1,id );
			rs=psta.executeQuery();
			if (rs.next())
				{
				algorithm = handleRs(rs);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if(psta!=null)
				{
					psta.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		return algorithm;
	}
	
	@Override
	public Algorithm getAlgorithmByAlgorithmName(String algorithmName) {
		Connection conn=null;
		PreparedStatement psta=null;
		ResultSet rs=null;
		Algorithm algorithm=null;
		String sql=null;
		try 
		{
			conn=DBUtil.getConnection();
			sql="select id,name,function from  where algorithmName=? ";
			psta=conn.prepareStatement(sql);
			psta.setString(1,algorithmName );
			rs=psta.executeQuery();
			if (rs.next())
				{
				algorithm = handleRs(rs);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if(psta!=null)
				{
					psta.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		return algorithm;
	}

	@Override
	public Algorithm getAlgorithmByAlgorithmFunction(String  function) {
		Connection conn=null;
		PreparedStatement psta=null;
		ResultSet rs=null;
		Algorithm algorithm=null;
		
		String sql=null;
		try 
		{
			conn=DBUtil.getConnection();
			sql="select id,name,function from  where function=? ";
			psta=conn.prepareStatement(sql);
			psta.setString(1,function );
			rs=psta.executeQuery();
			if (rs.next())
				{
				algorithm = handleRs(rs);
				}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (rs!=null)
				{
					rs.close();
				}
				if(psta!=null)
				{
					psta.close();
				}
				if(conn!=null)
				{
					conn.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		// TODO Auto-generated method stub
		return algorithm;
	}


	@Override
	public List<Algorithm> getAlgorithmByPagePojo(PagePojo pagePojo) {
		// TODO Auto-generated method stub
		Connection conn =null;
		PreparedStatement psta = null;
		ResultSet rs=null;
		List<Algorithm> algorithms=null;
		
		try {
			conn = DBUtil.getConnection();
			String sql = null;
			if (pagePojo.getPage() == 0) {
				sql = "select id,name,function from algorithm";
			} else {
				sql = "select id,name,function from algorithm limit ?,?";
			}

			psta = conn.prepareStatement(sql);
			if (pagePojo.getPage() != 0) {
				psta.setInt(1, pagePojo.getStart());
				psta.setInt(2, pagePojo.getPageCount());
			}
			rs = psta.executeQuery();
			algorithms = new ArrayList<Algorithm>();
			while (rs.next()) {
				Algorithm algorithm = handleRs(rs);
				algorithms.add(algorithm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psta != null) {
					psta.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return algorithms;
	}

	private Algorithm handleRs(ResultSet rs) {
		Algorithm algorithm = new Algorithm();
		try {
			//algorithm.setId(rs.getInt("id"));
			algorithm.setName(rs.getString("name"));
			algorithm.setFunction(rs.getString("function"));
		} catch (SQLException e) {
		}
		return algorithm;
	}

	}
