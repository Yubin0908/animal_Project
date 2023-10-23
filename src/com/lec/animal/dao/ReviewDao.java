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
import com.lex.animal.dto.ReviewDto;

public class ReviewDao {
	public final static int PASS = 1;
	public final static int FAIL = 0;
	public DataSource ds;
	
	public static ReviewDao instance = new ReviewDao();
	public static ReviewDao getinstance() {
		return instance;
	}
	
	private ReviewDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "connect 에러");
		}
	}
	
//	  -- (1) 리스트 출력(paging)
	public ArrayList<ReviewDto> listReview(int startRow, int endRow) {
		ArrayList<ReviewDto> reviews = new ArrayList<ReviewDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT ROWNUM RN, RPAD(SUBSTR(NAME,0,1),LENGTH(NAME), '*') NAME, A.* FROM REVIEW A, MEMBER M" + 
					 "     WHERE A.ID = M.ID ORDER BY RID DESC)" + 
					 "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int rid = rs.getInt("rid");
				String id = rs.getString("id");
				Date rdate = rs.getDate("rdate");
				String rtitle = rs.getString("rtitle");
				String rtext = rs.getString("rtext");
				String rimg = rs.getString("rimg");
				String rip = rs.getString("rip");
				int rdata_status = rs.getInt("rdata_status");
				reviews.add(new ReviewDto(name, rid, id, rdate, rtitle, rtext, rimg, rip, rdata_status));
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
		return reviews;
	}
//	  -- (2) 글 갯수
	public int getReviewCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM REVIEW WHERE RDATA_STATUS = 1";
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
//	  -- (3) 리뷰 상세보기
	public ReviewDto getReview(int rid) {
		ReviewDto review = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT R.*, M.NAME FROM REVIEW R, MEMBER M WHERE R.ID = M.ID AND RID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				Date rdate = rs.getDate("rdate");
				String rtitle = rs.getString("rtitle");
				String rtext = rs.getString("rtext");
				String rimg = rs.getString("rimg");
				String rip = rs.getString("rip");
				int rdata_status = rs.getInt("rdata_status");
				review = new ReviewDto(name, rid, id, rdate, rtitle, rtext, rimg, rip, rdata_status);
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
		return review;
	}
//	  -- (4) 리뷰 작성
	public int ReviewAdd(ReviewDto review) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO REVIEW VALUES(REVIEW_SEQ.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?, 1)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getId());
			ps.setString(2, review.getRtitle());
			ps.setString(3, review.getRtext());
			ps.setString(4, review.getRimg());
			ps.setString(5, review.getRip());
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
//	  -- (5) 리뷰 수정
	public int modifyReview(ReviewDto review) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE REVIEW SET" + 
				"    RDATE = SYSDATE," + 
				"    RTITLE = ?," + 
				"    RTEXT = ?," + 
				"    RIMG = ?," + 
				"    RIP = ?" + 
				"    WHERE RID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, review.getRtitle());
			ps.setString(2, review.getRtext());
			ps.setString(3, review.getRimg());
			ps.setString(4, review.getRip());
			ps.setInt(5, review.getRid());
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
//	  -- (6) 리뷰 삭제
	public int deleteReview(int rid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM REVIEW WHERE RID= ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "delete 에러");
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
