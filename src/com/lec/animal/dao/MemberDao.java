package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.MemberDto;

public class MemberDao {

	public final static int PASS = 1;
	public final static int FAIL = 0;
	public final static int EXIST = 1;
	public final static int NONEXITS = 0;
	
	public DataSource ds;
	
	public static MemberDao instance = new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	private MemberDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "DB 접속 에러");
		}
	}
	
//	-- (1) 회원가입 시 id중복체크
	public int idConfirm(String id) {
		int result = EXIST;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM MEMBER WHERE ID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = EXIST;
			} else {
				result = NONEXITS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "중복체크 에러");
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
//	-- (2) 회원가입 - 정보등록
	public int joinMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement psA = null;
		PreparedStatement psB = null;
		String sqlA = "INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,SYSDATE,1)";
		String sqlB = "INSERT INTO CUSTOMER_PET VALUES(CUSTOMER_PET_SEQ.NEXTVAL, ?,?,?)";
		try {
			conn = ds.getConnection();
			// A sql문 처리
			psA = conn.prepareStatement(sqlA);
	        psA.setString(1, member.getId());
	        psA.setString(2, member.getPw());
	        psA.setString(3, member.getName());
	        psA.setString(4, member.getLoctel());
	        psA.setString(5, member.getMidtel());
	        psA.setString(6, member.getLastel());
	        psA.setString(7, member.getEmail());
	        psA.setString(8, member.getAddress());
	        psA.setString(9, member.getNickname());
			// B sql문 처리
			psB = conn.prepareStatement(sqlB);
			psB.setString(1, member.getId());
			psB.setString(2, member.getAname());
			psB.setDate(3, member.getAdate());
			result = psB.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "회원가입 에러");
		} finally {
			try {
				if(psA!=null) psA.close();
				if(psB!=null) psB.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return result;
	}
//	-- (3) DTO 가져오기 (CUSTOMER_PET JOIN)
	public MemberDto getMember(String id) {
		MemberDto member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT M.*, P.* " + 
					 "FROM MEMBER M, CUSTOMER_PET P " + 
					 "WHERE M.ID = P.ID AND M.ID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String loctel = rs.getString("loctel");
				String midtel = rs.getString("midtel");
				String lastel = rs.getString("lastel");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String nickname = rs.getString("nickname");
				Date regidate = rs.getDate("regidate");
				int account_status = rs.getInt("account_status");
				int petno = rs.getInt("petno");
				String aname = rs.getString("aname");
				Date adate = rs.getDate("adate");
				member = new MemberDto(id, pw, name, loctel, midtel, lastel, email, address, nickname, regidate, account_status, petno, aname, adate);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Loding 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return member;
	}
//	-- (4) 회원정보 수정 전 비밀번호 체크
	public int pwcheck(String id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT PW FROM MEMBER WHERE ID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = PASS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "pwCheck 에러");
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
//	-- (5) 회원정보 수정
	public int modifyMember(MemberDto member) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE MEMBER SET " + 
				   	"    PW = , " + 
					"    LOCTEL = , " + 
					"    MIDTEL = , " + 
					"    LASTEL = , " + 
					"    EMAIL = , " + 
					"    ADDRESS = , " + 
					"    NICKNAME = " + 
					"    WHERE ID = ";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getPw());
			ps.setString(2, member.getLoctel());
			ps.setString(3, member.getMidtel());
			ps.setString(4, member.getLastel());
			ps.setString(5, member.getEmail());
			ps.setString(6, member.getAddress());
			ps.setString(7, member.getNickname());
			ps.setString(8, member.getId());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "정보수정 에러");
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return result;
	}
//	-- (6) 회원탈퇴
	public int withdrawalMember(String id) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE MEMBER SET ACCOUNT_STATUS = 0 WHERE ID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "회원탈퇴 에러");
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return result;
	}
//	-- (7) 로그인
	public int logincheck(String id, String pw) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PW = ? AND ACCOUNT_STATUS = 1";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = PASS;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "로그인 에러");
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
}
