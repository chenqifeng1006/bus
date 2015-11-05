package com.cc.order.dto;

import java.util.Date;

public class Order {

	private Long id;
	
	private Long fkUserId;
	
	private Long fkDingId;
	
	private Long fkDiningId;
	
	private double price;
	
	private Date createTime;
	
	private String state;
	
	private String dishName;
	
	private String dishImage;
	
	private String diningName;
	
	private String diningImage;
	
	private Long dishId;
	
	private Long diningId;
	
	private Long fkOrderId;
	
	private Long fkDishId;
	
	private Integer num;
	
	

	public Long getFkDiningId() {
		return fkDiningId;
	}

	public void setFkDiningId(Long fkDiningId) {
		this.fkDiningId = fkDiningId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFkUserId() {
		return fkUserId;
	}

	public void setFkUserId(Long fkUserId) {
		this.fkUserId = fkUserId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public String getDiningName() {
		return diningName;
	}

	public void setDiningName(String diningName) {
		this.diningName = diningName;
	}

	public String getDiningImage() {
		return diningImage;
	}

	public void setDiningImage(String diningImage) {
		this.diningImage = diningImage;
	}

	public Long getDishId() {
		return dishId;
	}

	public void setDishId(Long dishId) {
		this.dishId = dishId;
	}

	public Long getDiningId() {
		return diningId;
	}

	public void setDiningId(Long diningId) {
		this.diningId = diningId;
	}

	public Long getFkOrderId() {
		return fkOrderId;
	}

	public void setFkOrderId(Long fkOrderId) {
		this.fkOrderId = fkOrderId;
	}

	public Long getFkDishId() {
		return fkDishId;
	}

	public void setFkDishId(Long fkDishId) {
		this.fkDishId = fkDishId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getFkDingId() {
		return fkDingId;
	}

	public void setFkDingId(Long fkDingId) {
		this.fkDingId = fkDingId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}