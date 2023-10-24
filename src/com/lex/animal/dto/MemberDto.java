package com.lex.animal.dto;

import java.sql.Date;

public class MemberDto {
	private String id;
	private String pw;
	private String name;
	private String loctel;
	private String midtel;
	private String lastel;
	private String email;
	private String address;
	private String nickname;
	private Date regidate;
	private int account_status;
	private int petno;
	private String aname;
	private Date adate;
	
	public MemberDto(String id, String pw, String name, String loctel, String midtel, String lastel, String email,
			String address, String nickname, Date regidate, int account_status) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.loctel = loctel;
		this.midtel = midtel;
		this.lastel = lastel;
		this.email = email;
		this.address = address;
		this.nickname = nickname;
		this.regidate = regidate;
		this.account_status = account_status;
	}

	public MemberDto(String id, String pw, String name, String loctel, String midtel, String lastel, String email,
			String address, String nickname, Date regidate, int account_status, int petno, String aname, Date adate) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.loctel = loctel;
		this.midtel = midtel;
		this.lastel = lastel;
		this.email = email;
		this.address = address;
		this.nickname = nickname;
		this.regidate = regidate;
		this.account_status = account_status;
		this.petno = petno;
		this.aname = aname;
		this.adate = adate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoctel() {
		return loctel;
	}

	public void setLoctel(String loctel) {
		this.loctel = loctel;
	}

	public String getMidtel() {
		return midtel;
	}

	public void setMidtel(String midtel) {
		this.midtel = midtel;
	}

	public String getLastel() {
		return lastel;
	}

	public void setLastel(String lastel) {
		this.lastel = lastel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

	public int getAccount_status() {
		return account_status;
	}

	public void setAccount_status(int account_status) {
		this.account_status = account_status;
	}

	public int getPetno() {
		return petno;
	}

	public void setPetno(int petno) {
		this.petno = petno;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pw=" + pw + ", name=" + name + ", loctel=" + loctel + ", midtel=" + midtel
				+ ", lastel=" + lastel + ", email=" + email + ", address=" + address + ", nickname=" + nickname
				+ ", regidate=" + regidate + ", account_status=" + account_status + ", petno=" + petno + ", aname="
				+ aname + ", adate=" + adate + "]";
	}
	
}
