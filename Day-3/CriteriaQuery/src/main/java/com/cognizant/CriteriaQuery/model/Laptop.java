package com.cognizant.CriteriaQuery.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="laptop_table")
@DynamicUpdate

public class Laptop {

	@Id
	@Column(name="laptop_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int laptopId;
	 
	@Column(name="laptop_name",length=100,nullable=false)
	private String laptopName;
	
	@Column(name="review")
	private int review;
	@Column(name="hard_disk_size")
	private double hardDiskSize;
	@Column(name="ram_size")
	private double ramSize;
	@Column(name="cpu_speed")
	private double cpuSpeed;
	@Column(name="os")
	private String os;
	@Column(name="weight")
	private double weight;
	@Column(name="cpu")
	private String cpu;
	public int getLaptopId() {
		return laptopId;
	}
	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}
	public String getLaptopName() {
		return laptopName;
	}
	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}
	public int getReview() {
		return review;
	}
	public void setReview(int review) {
		this.review = review;
	}
	public double getHardDiskSize() {
		return hardDiskSize;
	}
	public void setHardDiskSize(double hardDiskSize) {
		this.hardDiskSize = hardDiskSize;
	}
	public double getRamSize() {
		return ramSize;
	}
	public void setRamSize(double ramSize) {
		this.ramSize = ramSize;
	}
	public double getCpuSpeed() {
		return cpuSpeed;
	}
	public void setCpuSpeed(double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", laptopName=" + laptopName + ", review=" + review + ", hardDiskSize="
				+ hardDiskSize + ", ramSize=" + ramSize + ", cpuSpeed=" + cpuSpeed + ", os=" + os + ", weight=" + weight
				+ ", cpu=" + cpu + "]";
	}
	
	


}
