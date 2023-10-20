package com.lex.animal.dto;

import java.sql.Date;

public class AdminDto {
	private int comno;
	private String compw;
	private String comname;
	private Date comdate;
	private String comemail;
	private int com_status;
	
	public AdminDto() { }

	public AdminDto(int comno, String compw, String comname, Date comdate, String comemail, int com_status) {
		super();
		this.comno = comno;
		this.compw = compw;
		this.comname = comname;
		this.comdate = comdate;
		this.comemail = comemail;
		this.com_status = com_status;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	public String getCompw() {
		return compw;
	}

	public void setCompw(String compw) {
		this.compw = compw;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public Date getComdate() {
		return comdate;
	}

	public void setComdate(Date comdate) {
		this.comdate = comdate;
	}

	public String getComemail() {
		return comemail;
	}

	public void setComemail(String comemail) {
		this.comemail = comemail;
	}

	public int getCom_status() {
		return com_status;
	}

	public void setCon_status(int com_status) {
		this.com_status = com_status;
	}

	@Override
	public String toString() {
		return "AdminDto [comno=" + comno + ", compw=" + compw + ", comname=" + comname + ", comdate=" + comdate
				+ ", comemail=" + comemail + ", con_status=" + com_status + "]";
	}

}
