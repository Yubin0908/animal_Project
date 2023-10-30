package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.CommentDto;
import com.lex.animal.dto.NoticeDto;

public class CommentDao {
	
	public final static int PASS = 1;
	public final static int FAIL = 0;
	public DataSource ds;
	
	public static CommentDao instance = new CommentDao();
	public static CommentDao getInstance() {
		return instance;
	}
	
	private CommentDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "connect 에러");
		}
	}
//	  -- (1) 댓글 출력[NAME, MTEXT, MIP, MDATE](PAGEING)
	public ArrayList<CommentDto> listComment(int nid, int startRow, int endRow) {
		ArrayList<CommentDto> comment = new ArrayList<CommentDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM " + 
				"  (SELECT ROWNUM RN, A.* FROM (SELECT * FROM COMMENT_T WHERE NID = ? ORDER BY MGROUP DESC, MSTEP) A)" + 
				"WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			ps.setInt(2, startRow);
			ps.setInt(3, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int mid = rs.getInt("mid");
				String id = rs.getString("id");
				Date mdate = rs.getDate("mdate");
				String mtext = rs.getString("mtext");
				int mgroup = rs.getInt("mgroup");
				int mstep = rs.getInt("mstep");
				int mindent = rs.getInt("mindent");
				String mip = rs.getString("mip");
				comment.add(new CommentDto(mid, id, nid, mdate, mtext, mgroup, mstep, mindent, mip, null));
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
		return comment;
	}
//	  -- (2) 댓글 쓰기
	public int addComment(CommentDto comment) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		replyCntPlus(comment.getNid());
		String sql = "INSERT INTO COMMENT_T VALUES(COMMENT_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, COMMENT_SEQ.CURRVAL, 0, 0, ?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getId());
			ps.setInt(2, comment.getNid());
			ps.setString(3, comment.getMtext());
			ps.setString(4, comment.getMip());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addComment 에러");
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
//	  -- (3) 댓글 삭제
	public int deleteComment(int mid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM COMMENT_T WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			result = ps.executeUpdate();
			replyCntMinus(result);
		} catch (Exception e) {
			System.out.println(e.getMessage() + "deleteComment 에러");
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
//	  -- (4) DTO 가져오기
	public CommentDto getComment(int mid) {
		CommentDto comment = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM COMMENT_T WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mid);
			rs = ps.executeQuery();
			if(rs.next()) {
				String id = rs.getString("id");
				int nid = rs.getInt("nid");
				Date mdate = rs.getDate("mdate");
				String mtext = rs.getString("mtext");
				int mgroup = rs.getInt("mgroup");
				int mstep = rs.getInt("mstep");
				int mindent = rs.getInt("mindent");
				String mip = rs.getString("mip");
				comment = new CommentDto(mid, id, nid, mdate, mtext, mgroup, mstep, mindent, mip, null);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Comment DtoLoad 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return comment;
	}
//	  -- (5) 댓글 수정
	public int modifyComment(CommentDto comment) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "UPDATE COMMENT_T SET" + 
				"    MDATE = SYSDATE," + 
				"    MTEXT = ?," + 
				"    MIP = ?" + 
				"    WHERE MID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getMtext());
			ps.setString(2, comment.getMip());
			ps.setInt(3, comment.getMid());
			result = ps.executeUpdate();
			System.out.println(result == PASS ? "성공":"실패");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Modify Comment 에러");
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
//	  -- (6) 댓글 갯수
	public int getCommentCnt(int nid) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM COMMENT_T WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
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
//	  -- (7) MSTEP 조정단계
	private void replyCommentFirstStep(int mgroup, int mstep) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE COMMENT_T SET MSTEP = MSTEP + 1 WHERE MGROUP = ? AND MSTEP > 0";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mgroup);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "mstep 조정 에러");
		} finally {
			try {
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "close 에러");
		}
		}
	}
//	  -- (8) 답글 쓰기
	public int replyComment(CommentDto comment) {
		int result = FAIL;
		replyCommentFirstStep(comment.getMgroup(), comment.getMstep());
		replyCntPlus(comment.getNid());
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO COMMENT_T VALUES (COMMENT_SEQ.NEXTVAL, ?, ?, SYSDATE, ?, ?, ?, ?, ?)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, comment.getId());
			ps.setInt(2, comment.getNid());
			ps.setString(3, comment.getMtext());
			ps.setInt(4, comment.getMgroup());
			ps.setInt(5, comment.getMstep() + 1);
			ps.setInt(6, comment.getMindent() + 1);
			ps.setString(7, comment.getMip());
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
//	-- (9) reply_count ++
	private void replyCntPlus(int nid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE NOTICE SET REPLY_COUNT = REPLY_COUNT + 1 WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "count ++ 에러");
		} finally {
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
	}
//	-- (10) REPLY_COUNT --
	private void replyCntMinus(int nid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE NOTICE SET REPLY_COUNT = REPLY_COUNT - 1 WHERE NID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, nid);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "count -- 에러");
		} finally {
			try {
				
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
	}
}

