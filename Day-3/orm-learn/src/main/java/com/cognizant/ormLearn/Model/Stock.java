package com.cognizant.ormLearn.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Stock {
	
	@Id
	@Column(name="st_id")
	private int id;
	@Column(name="st_code")
	private String code;
	@Temporal(TemporalType.DATE)
	@Column(name="st_date")
	private Date date;
	@Column(name="st_open")
	private Double open;
	@Column(name="st_close")
	private Double close;
	@Column(name="st_volume")
	private int volume;
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
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	@Override
	public String toString() {
		return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close
				+ ", volume=" + volume + "]";
	}
	
	
}
