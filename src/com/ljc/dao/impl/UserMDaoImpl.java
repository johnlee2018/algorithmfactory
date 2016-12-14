package com.ljc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ljc.dao.UserMDao;
import com.ljc.pojo.PagePojo;
import com.ljc.pojo.User;
import com.ljc.util.DBUtil;

public class UserMDaoImpl implements UserMDao {

	/**
	 * 根据用户名查询单条记录
	 * 
	 * @author li jianchun
	 * @param username
	 * @return
	 */
	@Override
	public User getUserByUserName(String userName) {
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select id,username,pass from user where username=?";
			sta = conn.prepareStatement(sql);
			sta.setString(1, userName);
			rs = sta.executeQuery();
			//System.out.println("%%%%%%%");
			//System.out.println(rs);

			if (rs.next()) 
			{
				user = handleRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (sta != null) {
					sta.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return user;
	}

	/**
	 * 根据用户名和密码查询单条记录
	 * 
	 * @author li jianchun
	 * @param user
	 * @return
	 */
	@Override
	public User getUserByUserNamePass(User u) {
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select id,username,pass from user where username=? and pass=?";
			sta = conn.prepareStatement(sql);
			sta.setString(1, u.getUserName());
			sta.setString(2, u.getPass());
			rs = sta.executeQuery();
			//System.out.println("##########");
			//System.out.println(rs);

			if (rs.next()) {
				user = handleRs(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (sta != null) {
					sta.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return user;
	}

	/**
	 * 分页得到所有用户记录
	 * 
	 * @author li jianchun
	 * @param PagePojo
	 * @return
	 */
	@Override
	public List<User> getUserByPage(PagePojo pagePojo) {
		Connection conn = null;
		PreparedStatement sta = null;
		ResultSet rs = null;
		List<User> users = null;
		try {
			conn = DBUtil.getConnection();
			String sql = null;
			if (pagePojo.getPage() == 0) {
				sql = "select id,username,pass from user";
			} else {
				sql = "select id,username,pass from user limit ?,?";
			}

			sta = conn.prepareStatement(sql);
			if (pagePojo.getPage() != 0) {
				sta.setInt(1, pagePojo.getStart());
				sta.setInt(2, pagePojo.getPageCount());
			}
			rs = sta.executeQuery();
			///System.out.println("**********");
			//System.out.println(rs);
			users = new ArrayList<User>();
			while (rs.next()) {
				User user = handleRs(rs);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (sta != null) {
					sta.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
			}
		}
		return users;
	}

	private User handleRs(ResultSet rs) {
		User user = new User();
		try {
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setPass(rs.getString("pass"));
		} catch (SQLException e) {
		}
		return user;
	}

}
