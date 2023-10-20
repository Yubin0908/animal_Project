package com.lex.animal.dto;

import java.sql.Date;

public class PetDto {
	private int petid;
	private int comno;
	private String pettype;
	private String petbrads;
	private String petname;
	private int petage;
	private int petprice;
	private String petimg;
	private Date petupdate;
	private int pet_status;
	
	public PetDto() { }

	public PetDto(int petid, int comno, String pettype, String petbrads, String petname, int petage, int petprice,
			String petimg, Date petupdate, int pet_status) {
		super();
		this.petid = petid;
		this.comno = comno;
		this.pettype = pettype;
		this.petbrads = petbrads;
		this.petname = petname;
		this.petage = petage;
		this.petprice = petprice;
		this.petimg = petimg;
		this.petupdate = petupdate;
		this.pet_status = pet_status;
	}

	public int getPetid() {
		return petid;
	}

	public void setPetid(int petid) {
		this.petid = petid;
	}

	public int getComno() {
		return comno;
	}

	public void setComno(int comno) {
		this.comno = comno;
	}

	public String getPettype() {
		return pettype;
	}

	public void setPettype(String pettype) {
		this.pettype = pettype;
	}

	public String getPetbrads() {
		return petbrads;
	}

	public void setPetbrads(String petbrads) {
		this.petbrads = petbrads;
	}

	public String getPetname() {
		return petname;
	}

	public void setPetname(String petname) {
		this.petname = petname;
	}

	public int getPetage() {
		return petage;
	}

	public void setPetage(int petage) {
		this.petage = petage;
	}

	public int getPetprice() {
		return petprice;
	}

	public void setPetprice(int petprice) {
		this.petprice = petprice;
	}

	public String getPetimg() {
		return petimg;
	}

	public void setPetimg(String petimg) {
		this.petimg = petimg;
	}

	public Date getPetupdate() {
		return petupdate;
	}

	public void setPetupdate(Date petupdate) {
		this.petupdate = petupdate;
	}

	public int getPet_status() {
		return pet_status;
	}

	public void setPet_status(int pet_status) {
		this.pet_status = pet_status;
	}

	@Override
	public String toString() {
		return "PetDto [petid=" + petid + ", comno=" + comno + ", pettype=" + pettype + ", petbrads=" + petbrads
				+ ", petname=" + petname + ", petage=" + petage + ", petprice=" + petprice + ", petimg=" + petimg
				+ ", petupdate=" + petupdate + ", pet_status=" + pet_status + "]";
	}

}
