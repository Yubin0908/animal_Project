package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.ContactDto;

public class ContactDao {
	public final static int PASS = 1;
	public final static int FAIL = 0;
	public DataSource ds;
	
	public static ContactDao instance = new ContactDao();
	public static ContactDao getinstance() {
		return instance;
	}
	
	private ContactDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "connect 에러");
		}
	}
	
//	-- (1) 리스트 출력(paging)
	public ArrayList<ContactDto> listContact(int startRow, int endRow) {
		ArrayList<ContactDto> contacts = new ArrayList<ContactDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM CONTACT ORDER BY CGROUP DESC, CSTEP) A)" + 
				    "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int cid = rs.getInt("cid");
				int cpw = rs.getInt("cpw");
				String cwriter = rs.getString("cwriter");
				String ctitle = rs.getString("ctitle");
				String ctext = rs.getString("ctext");
				Date cdate = rs.getDate("cdate");
				int cgroup = rs.getInt("cgroup");
				int cstep = rs.getInt("cstep");
				int cindent = rs.getInt("cindent");
				String cip = rs.getString("cip");
				int cdata_status = rs.getInt("cdata_status");
				contacts.add(new ContactDto(cid, cpw, cwriter, ctitle, ctext, cdate, cgroup, cstep, cindent, cip, cdata_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "list 출력 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return contacts;
	}
//  -- 게시물 갯수
	public int getContactCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM CONTACT WHERE CDATA_STATUS = 1";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "cnt 출력 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		
		return cnt;
	}
//	-- (2) 문의글 등록
	public int contactAdd(ContactDto contact) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, CONTACT_SEQ.CURRVAL, 0,0, ?, 1)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, contact.getCpw());
			ps.setString(2, contact.getCwriter());
			ps.setString(3, contact.getCtitle());
			ps.setString(4, contact.getCtext());
			ps.setString(5, contact.getCip());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "add 에러");
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
//	-- (3) 문의글 상세보기(CPW)
	public ContactDto getContact(int cid, int cpw) {
		ContactDto contact = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CONTACT WHERE CID = ? AND CPW = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, cpw);
			rs = ps.executeQuery();
			if(rs.next()) {
				String cwriter = rs.getString("cwriter");
				String ctitle = rs.getString("ctitle");
				String ctext = rs.getString("ctext");
				Date cdate = rs.getDate("cdate");
				int cgroup = rs.getInt("cgroup");
				int cstep = rs.getInt("cstep");
				int cindent = rs.getInt("cindent");
				String cip = rs.getString("cip");
				int cdata_status = rs.getInt("cdata_status");
				contact = new ContactDto(cid, cpw, cwriter, ctitle, ctext, cdate, cgroup, cstep, cindent, cip, cdata_status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "dto 불러오기 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		
		return contact;
	}
//	-- (4) 문의글 수정
	public int modifyContact(ContactDto contact) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE CONTACT SET " + 
				 	 "    CTITLE = ?," + 
					 "    CTEXT = ?," + 
					 "    CIP = ?" + 
					 "    WHERE CID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, contact.getCtitle());
			ps.setString(2, contact.getCtext());
			ps.setString(3, contact.getCip());
			ps.setInt(4, contact.getCid());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "modify 에러");
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
//	-- (5) 답변글 쓰기 전단계(step 조정작업)
	private void replyContactFirstStep(int cgroup, int cstep) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE CONTACT SET CSTEP = CSTEP + 1 WHERE CGROUP=? AND CSTEP > 0";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cgroup);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "cstep 조정 에러");
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "close 에러");
		}
		}
	}
	private void replyContactSecondStep(int cgroup) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE CONTACT SET CDATA_STATUS = 2 WHERE CGROUP = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cgroup);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "status 조정 에러");
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
	}
//	-- (6) 답변글 쓰기	
	public int replyContact(ContactDto contact) {
		int result = FAIL;
		replyContactFirstStep(contact.getCgroup(), contact.getCstep());
		replyContactSecondStep(contact.getCgroup());
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO CONTACT VALUES (CONTACT_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, 3)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, contact.getCpw());
			ps.setString(2, contact.getCwriter());
			ps.setString(3, contact.getCtitle());
			ps.setString(4, contact.getCtext());
			ps.setInt(5, contact.getCgroup());
			ps.setInt(6, contact.getCstep() + 1);
			ps.setInt(7, contact.getCindent() + 1);
			ps.setString(8, contact.getCip());
			ps.executeUpdate();
			result = PASS;
		} catch (Exception e) {
			System.out.println(e.getMessage() + "reply 에러");
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
}
