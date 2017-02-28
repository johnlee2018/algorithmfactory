package com.ljc.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;



/**
 * @author HP
 *
 */
public class DBUtil {
	//private final static String URL = "jdbc:mysql://localhost/shoppingstyle=?characterEncoding=utf8";  
	private static DataSource ds = null;
	private static Logger log = Logger.getLogger(DBUtil.class);
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			ds = (DataSource) envCtx.lookup("jdbc/algorithmfactory");
		} catch (NamingException e) {

		}
	}

	public static Connection getConnection() throws SQLException {
		if (ds != null) {
			try {
				Connection conn = ds.getConnection();
				return conn;
			} catch (SQLException e) {
				log.error("until layer logic error", e);
				throw e;
			}
		} else {
			throw new SQLException("datasource init error");
		}
	}

}
