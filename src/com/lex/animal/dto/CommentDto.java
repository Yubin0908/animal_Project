package com.lex.animal.dto;

import java.sql.Date;

public class CommentDto {
	private int mid;
	private String id;
	private int nid;
	private Date mdate;
	private String mtext;
	private int mgroup;
	private int mstep;
	private int mindent;
	private String mip;
	private String name;
	private int reply_count;
	
	
	
	public CommentDto() { }
	
	public CommentDto(int mid, String id, int nid, Date mdate, String mtext, int mgroup, int mstep, int mindent,
			String mip, String name) {
		super();
		this.mid = mid;
		this.id = id;
		this.nid = nid;
		this.mdate = mdate;
		this.mtext = mtext;
		this.mgroup = mgroup;
		this.mstep = mstep;
		this.mindent = mindent;
		this.mip = mip;
		this.name = name;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getMtext() {
		return mtext;
	}

	public void setMtext(String mtext) {
		this.mtext = mtext;
	}

	public int getMgroup() {
		return mgroup;
	}

	public void setMgroup(int mgroup) {
		this.mgroup = mgroup;
	}

	public int getMstep() {
		return mstep;
	}

	public void setMstep(int mstep) {
		this.mstep = mstep;
	}

	public int getMindent() {
		return mindent;
	}

	public void setMindent(int mindent) {
		this.mindent = mindent;
	}

	public String getMip() {
		return mip;
	}

	public void setMip(String mip) {
		this.mip = mip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getReply_count() {
		return reply_count;
	}
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	@Override
	public String toString() {
		return "CommentDto [mid=" + mid + ", id=" + id + ", nid=" + nid + ", mdate=" + mdate + ", mtext=" + mtext
				+ ", mgroup=" + mgroup + ", mstep=" + mstep + ", mindent=" + mindent + ", mip=" + mip + ", name=" + name
				+ "]";
	}
	
}
