package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.AdminDto;

public class AdminDao {

	public final static int PASS = 1;
	public final static int FAIL = 0;
	
	public DataSource ds;
	
	public static AdminDao instance = new AdminDao();
	public static AdminDao getinstance() {
		return instance;
	}
	
	private AdminDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "DB 접속 에러");
		}
	}
	
//	-- (1) 로그인
	public int adminLogin(int comno, String compw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE COM_STATUS = 1 AND COMNO = ? AND COMPW = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comno);
			ps.setString(2, compw);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = PASS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "login 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return result;
	}
	
//	-- (2) dto 가져오기
	public AdminDto getAdmin(int comno) {
		AdminDto admin = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ADMIN WHERE COMNO = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, comno);
			rs = ps.executeQuery();
			if(rs.next()) {
				String compw = rs.getString("compw");
				String comname = rs.getString("comname");
				Date comdate = rs.getDate("comdate");
				String comemail = rs.getString("comemail");
				int com_status = rs.getInt("com_status");
				admin = new AdminDto(comno, compw, comname, comdate, comemail, com_status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "login 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}	
		return admin;
	}
}
