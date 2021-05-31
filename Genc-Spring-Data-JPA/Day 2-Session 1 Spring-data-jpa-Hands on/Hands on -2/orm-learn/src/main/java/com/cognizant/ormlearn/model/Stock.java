package com.cognizant.ormlearn.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "stock")
public class Stock {

	@Id
	@Column(name="st_id")
	private int id;
	
	@Column(name="st_code")
	private String code;
	
	@Column(name="st_date")
	private Date date;

	@Column(name="st_open")
	private java.math.BigDecimal open;
	
	@Column(name="st_close")
	private java.math.BigDecimal close;

	@Column(name="st_volume")
	private java.math.BigDecimal volume;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public java.math.BigDecimal getOpen() {
		return open;
	}

	public void setOpen(java.math.BigDecimal open) {
		this.open = open;
	}

	public java.math.BigDecimal getClose() {
		return close;
	}

	public void setClose(java.math.BigDecimal close) {
		this.close = close;
	}

	public java.math.BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(java.math.BigDecimal volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}

	

	
}
