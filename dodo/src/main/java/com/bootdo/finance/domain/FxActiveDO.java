package com.bootdo.finance.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 活动
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public class FxActiveDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id 
	private Long id;
	//活动发起人
	private Long initiator;
	//活动开始时间
	private Date fromTime;
	//活动结束时间
	private Date endTime;
	//地址
	private String address;
	//预算金额
	private BigDecimal budgetAmount;
	//参与人
	private String activeUsers;
	//描述
	private String description;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//创建人
	private String createUser;
	//更新人
	private String updateUser;

	/**
	 * 设置：id 
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：id 
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：活动发起人
	 */
	public void setInitiator(Long initiator) {
		this.initiator = initiator;
	}
	/**
	 * 获取：活动发起人
	 */
	public Long getInitiator() {
		return initiator;
	}
	/**
	 * 设置：活动开始时间
	 */
	public void setFromTime(Date fromTime) {
		this.fromTime = fromTime;
	}
	/**
	 * 获取：活动开始时间
	 */
	public Date getFromTime() {
		return fromTime;
	}
	/**
	 * 设置：活动结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：活动结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：预算金额
	 */
	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}
	/**
	 * 获取：预算金额
	 */
	public BigDecimal getBudgetAmount() {
		return budgetAmount;
	}
	/**
	 * 设置：参与人
	 */
	public void setActiveUsers(String activeUsers) {
		this.activeUsers = activeUsers;
	}
	/**
	 * 获取：参与人
	 */
	public String getActiveUsers() {
		return activeUsers;
	}
	/**
	 * 设置：描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
}
