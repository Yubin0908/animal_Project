package com.lex.animal.dto;

import java.sql.Date;

public class NoticeDto {
	private int nid;
	private int comno;
	private Date ndate;
	private String ntitle;
	private String ntext;
	private String nimg;
	private String nip;
	private int reply_count;
	
	public NoticeDto() { }
	
	public NoticeDto(int nid, int comno, Date ndate, String ntitle, String ntext, String nimg, String nip, int reply_count) {
		super();
		this.nid = nid;
		this.comno = comno;
		this.ndate = ndate;
		this.ntitle = ntitle;
		this.ntext = ntext;
		this.nimg = nimg;
		this.nip = nip;
		this.reply_count = reply_count;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNtext() {
		return ntext;
	}

	public void setNtext(String ntext) {
		this.ntext = ntext;
	}

	public String getNimg() {
		return nimg;
	}

	public void setNimg(String nimg) {
		this.nimg = nimg;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}
	
	public int getReply_count() {
		return reply_count;
	}
	
	public void setReply_count(int reply_count) {
		this.reply_count = reply_count;
	}

	@Override
	public String toString() {
		return "NoticeDto [nid=" + nid + ", comno=" + comno + ", ndate=" + ndate + ", ntitle=" + ntitle + ", ntext="
				+ ntext + ", nimg=" + nimg + ", nip=" + nip +  ", reply_count=" + reply_count + "]";
	}

}
