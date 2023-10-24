package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.NoticeDto;
import com.lex.animal.dto.PetDto;

public class NoticeDao {

	public final static int PASS = 1;
	public final static int FAIL = 0;
	public DataSource ds;
	
	public static NoticeDao instance = new NoticeDao();
	public static NoticeDao getInstance() {
		return instance;
	}
	
	private NoticeDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "connet 에러");
		}
	}
//	  -- (1) 리스트 출력(paging)
	public ArrayList<NoticeDto> listNotice(int startRow, int endRow) {
		ArrayList<NoticeDto> notice = new ArrayList<NoticeDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM NOTICE ORDER BY NID DESC) A)" + 
					 "  WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int nid = rs.getInt("nid");
				int comno = rs.getInt("comno");
				Date ndate = rs.getDate("ndate");
				String ntitle = rs.getString("ntitle");
				String ntext = rs.getString("ntext");
				String nimg = rs.getString("nimg");
				String nip = rs.getString("nip");
				notice.add(new NoticeDto(nid, comno, ndate, ntitle, ntext, nimg, nip));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "리스트 출력에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return notice;
	}
//	  -- (2) 공지사항 상세보기
	public NoticeDto getNotice(int nid) {
		NoticeDto notice = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NOTICE WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			rs = ps.executeQuery();
			if(rs.next()) {
				int comno = rs.getInt("comno");
				Date ndate = rs.getDate("ndate");
				String ntitle = rs.getString("ntitle");
				String ntext = rs.getString("ntext");
				String nimg = rs.getString("nimg");
				String nip = rs.getString("nip");
				notice = new NoticeDto(nid, comno, ndate, ntitle, ntext, nimg, nip);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Notice DtoLoad 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return notice;
	}
//	  -- (3) 공지사항 작성
	public int addNotice(NoticeDto notice) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO NOTICE VALUES (NOTICE_SEQ.NEXTVAL ,?, SYSDATE, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notice.getComno());
			ps.setString(2, notice.getNtitle());
			ps.setString(3, notice.getNtext());
			ps.setString(4, notice.getNimg());
			ps.setString(5, notice.getNip());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addNotice 에러");
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
//	  -- (4) 공지사항 수정
	public int modifyNotice(NoticeDto notice) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "UPDATE NOTICE SET " + 
				"    NDATE = SYSDATE," + 
				"    NTITLE = ?," + 
				"    NTEXT = ?," + 
				"    NIMG = ?," + 
				"    NIP = ?" + 
				"    WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, notice.getNtitle());
			ps.setString(2, notice.getNtext());
			ps.setString(3, notice.getNimg());
			ps.setString(4, notice.getNip());
			ps.setInt(5, notice.getNid());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Modify Notice 에러");
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
//	  -- (5) 공지사항 삭제
	public int deleteNotice(int nid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM NOTICE WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "deleteNotice 에러");
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
//	-- (6) 리스트 갯수
	public int getNoticeCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM NOTICE";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "cnt 출력에러");
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
}
