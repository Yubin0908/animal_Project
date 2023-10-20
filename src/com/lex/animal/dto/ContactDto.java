package com.lex.animal.dto;

import java.sql.Date;

public class ContactDto {
	private int cid;
	private int cpw;
	private String cwriter;
	private String ctitle;
	private String ctext;
	private Date cdate;
	private int cgroup;
	private int cstep;
	private int cindent;
	private String cip;
	private int cdata_status;
	public ContactDto() { }
	
	public ContactDto(int cid, int cpw, String cwriter, String ctitle, String ctext, Date cdate, int cgroup,
			int cstep, int cindent, String cip, int cdata_status) {
		super();
		this.cid = cid;
		this.cpw = cpw;
		this.cwriter = cwriter;
		this.ctitle = ctitle;
		this.ctext = ctext;
		this.cdate = cdate;
		this.cgroup = cgroup;
		this.cstep = cstep;
		this.cindent = cindent;
		this.cip = cip;
		this.cdata_status = cdata_status;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCpw() {
		return cpw;
	}

	public void setCpw(int cpw) {
		this.cpw = cpw;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	public String getCtext() {
		return ctext;
	}

	public void setCtext(String ctext) {
		this.ctext = ctext;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getCgroup() {
		return cgroup;
	}

	public void setCgroup(int cgroup) {
		this.cgroup = cgroup;
	}

	public int getCstep() {
		return cstep;
	}

	public void setCstep(int cstep) {
		this.cstep = cstep;
	}

	public int getCindent() {
		return cindent;
	}

	public void setCindent(int cindent) {
		this.cindent = cindent;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public int getCdata_status() {
		return cdata_status;
	}

	public void setCdata_status(int cdata_status) {
		this.cdata_status = cdata_status;
	}

	@Override
	public String toString() {
		return "ContactDto [cid=" + cid + ", cpw=" + cpw + ", cwriter=" + cwriter + ", ctitle=" + ctitle + ", ctext="
				+ ctext + ", cdate=" + cdate + ", cgroup=" + cgroup + ", cstep=" + cstep + ", cindent=" + cindent
				+ ", cip=" + cip + ", cdata_status=" + cdata_status + "]";
	}

}
