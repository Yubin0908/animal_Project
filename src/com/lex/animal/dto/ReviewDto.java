package com.lex.animal.dto;

import java.sql.Date;

public class ReviewDto {
	private String name;
	private int rid;
	private String id;
	private Date rdate;
	private String rtitle;
	private String rtext;
	private String rimg;
	private String rip;
	private int rdata_status;
	
	public ReviewDto() { }

	public ReviewDto(String name, int rid, String id, Date rdate, String rtitle, String rtext, String rimg, String rip,
			int rdata_status) {
		super();
		this.name = name;
		this.rid = rid;
		this.id = id;
		this.rdate = rdate;
		this.rtitle = rtitle;
		this.rtext = rtext;
		this.rimg = rimg;
		this.rip = rip;
		this.rdata_status = rdata_status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRdate() {
		return rdate;
	}

	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRtext() {
		return rtext;
	}

	public void setRtext(String rtext) {
		this.rtext = rtext;
	}

	public String getRimg() {
		return rimg;
	}

	public void setRimg(String rimg) {
		this.rimg = rimg;
	}

	public String getRip() {
		return rip;
	}

	public void setRip(String rip) {
		this.rip = rip;
	}

	public int getRdata_status() {
		return rdata_status;
	}

	public void setRdata_status(int rdata_status) {
		this.rdata_status = rdata_status;
	}

	@Override
	public String toString() {
		return "ReviewDto [name=" + name + ", rid=" + rid + ", id=" + id + ", rdate=" + rdate + ", rtitle=" + rtitle
				+ ", rtext=" + rtext + ", rimg=" + rimg + ", rip=" + rip + ", rdata_status=" + rdata_status + "]";
	}
	
	
	
}
