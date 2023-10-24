package com.lec.animal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.lex.animal.dto.PetDto;

public class PetDao {
	public final static int PASS = 1;
	public final static int FAIL = 0;
	public DataSource ds;
	
	public static PetDao instance = new PetDao();
	public static PetDao getInstance() {
		return instance;
	}
	
	private PetDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "DB 접속에러");
		}
	}
	
//	-- (1) 리스트 출력(paging)
	public ArrayList<PetDto> listDog(int startRow, int endRow) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM LOCAL_PET WHERE PETTYPE='강아지' AND PET_STATUS = 1 ORDER BY PETID DESC) A)" + 
					 "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String pettype = rs.getString("pettype");
				String petbrads = rs.getString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Dog리스트 출력에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
	public ArrayList<PetDto> listCat(int startRow, int endRow) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
				 	 "    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM LOCAL_PET WHERE PETTYPE='고양이' AND PET_STATUS = 1 ORDER BY PETID DESC) A)" + 
				 	 "    WHERE RN BETWEEN ? AND ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String pettype = rs.getString("pettype");
				String petbrads = rs.getString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "Cat리스트 출력에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
//    -- (2) 리스트 갯수
	public int getPetCnt(String pettype) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) CNT FROM LOCAL_PET WHERE PETTYPE= ? AND PET_STATUS = 1";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pettype);
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
//	  -- (3) 리스트 추가
	public int addPet(PetDto pet) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;

		String sql = "INSERT INTO LOCAL_PET VALUES(LOCAL_PET_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE, 1)";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pet.getComno());
			ps.setString(2, pet.getPettype());
			ps.setString(3, pet.getPetbrads());
			ps.setString(4, pet.getPetname());
			ps.setInt(5, pet.getPetage());
			ps.setInt(6, pet.getPetprice());
			ps.setString(7, pet.getPetimg());
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "addPet 에러");
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
	
//    -- (4) 리스트 수정
	public int modifyPet(PetDto pet) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE LOCAL_PET SET" + 
					"    COMNO = ?," + 
					"    PETTYPE = ?," + 
					"    PETBRADS = ?," + 
					"    PETNAME = ?," + 
					"    PETAGE = ?," + 
					"    PETPRICE = ?," + 
					"    PETIMG = ?," + 
					"    PETUPDATE = SYSDATE" + 
					"    WHERE PETID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pet.getComno());
			ps.setString(2, pet.getPettype());
			ps.setString(3, pet.getPetbrads());
			ps.setString(4, pet.getPetname());
			ps.setInt(5, pet.getPetage());
			ps.setInt(6, pet.getPetprice());
			ps.setString(7, pet.getPetimg());
			ps.setInt(8, pet.getPetid());
			result = ps.executeUpdate();
			if(result == PASS) {
				System.out.println("글수정성공");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "pet Modify 에러");
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
//    -- (5) 리스트 삭제
	public int deletePet(int petid) {
		int result = FAIL;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE LOCAL_PET SET" + 
					"    PET_STATUS = 0" + 
					"    WHERE PETID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, petid);
			result = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage() + "deletePet 에러");
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
//	-- (6) 필터링(특정한 부분 출력)
	public ArrayList<PetDto> filterPet(String petbrads) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT A.* FROM (SELECT * FROM LOCAL_PET) A)" + 
				 	 "    WHERE PET_STATUS = 1 AND PETBRADS = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, petbrads);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String pettype = rs.getString("pettype");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "FilterPet 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
	public ArrayList<PetDto> filterEtcCat(String pettype) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT A.* FROM (SELECT * FROM LOCAL_PET) A)" + 
					 "    WHERE PET_STATUS = 1 AND PETTYPE= ? AND PETBRADS != '노르웨이숲' AND PETBRADS != '브리티쉬' AND PETBRADS != '랙돌' AND PETBRADS != '러시안블루' AND PETBRADS != '먼치킨' AND PETBRADS != '메인쿤' AND PETBRADS != '뱅갈' AND PETTYPE='고양이'";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pettype);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String petbrads = rs.getNString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "filterEtcPet 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
	public ArrayList<PetDto> filterEtcDog(String pettype) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT A.* FROM (SELECT * FROM LOCAL_PET) A)" + 
					 "    WHERE PET_STATUS = 1 AND PETBRADS != '푸들' AND PETBRADS != '말티즈' AND PETBRADS != '미니비숑' AND PETBRADS != '비숑' AND PETBRADS != '보더콜리' AND PETBRADS != '포메라니안' AND PETBRADS != '폼피츠' AND PETTYPE=?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pettype);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String petbrads = rs.getNString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "filterEtcPet 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
//	-- (7) Main Page List Print
	public ArrayList<PetDto> mainPetList(String pettype) {
		ArrayList<PetDto> pets = new ArrayList<PetDto>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM" + 
					 "    (SELECT ROWNUM RN, A.* FROM (SELECT * FROM LOCAL_PET WHERE PETTYPE= ? AND  PET_STATUS = 1 ORDER BY PETID DESC) A)" + 
					 "    WHERE RN BETWEEN 1 AND 8";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, pettype);
			rs = ps.executeQuery();
			while(rs.next()) {
				int petid = rs.getInt("petid");
				int comno = rs.getInt("comno");
				String petbrads = rs.getNString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs.getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pets.add(new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "mainPetListPet 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pets;
	}
//	-- (8) DTO 가져오기
	public PetDto getPet(int petid) {
		PetDto pet = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM LOCAL_PET WHERE PETID = ?";
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, petid);
			rs = ps.executeQuery();
			if(rs.next()) {
				int comno = rs.getInt("comno");
				String pettype = rs.getString("pettype");
				String petbrads = rs.getString("petbrads");
				String petname = rs.getString("petname");
				int petage = rs.getInt("petage");
				int petprice = rs.getInt("petprice");
				String petimg = rs. getString("petimg");
				Date petupdate = rs.getDate("petupdate");
				int pet_status = rs.getInt("pet_status");
				pet = new PetDto(petid, comno, pettype, petbrads, petname, petage, petprice, petimg, petupdate, pet_status);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "pet DtoLoad 에러");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(conn!=null) conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage() + "close 에러");
			}
		}
		return pet;
	}
}
