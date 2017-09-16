package com.bootdo.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 财务收入表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public class FinancialIncomeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id 
	private Long id;
	//用户id
	private Long userId;
	//收入类型,经费,资产变卖,公司
	private String incomeType;
	//收入金额
	private BigDecimal incomeAmount;
	//收入单位 RMD,USD
	private String unit;
	//收入时间
	private Date incomeDate;
	//收入
	private Integer incomeStatus;
	//收入资料地址
	private String dataUrl;
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
	 * 设置：用户id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：收入类型,经费,资产变卖,公司
	 */
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	/**
	 * 获取：收入类型,经费,资产变卖,公司
	 */
	public String getIncomeType() {
		return incomeType;
	}
	/**
	 * 设置：收入金额
	 */
	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	/**
	 * 获取：收入金额
	 */
	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}
	/**
	 * 设置：收入单位 RMD,USD
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：收入单位 RMD,USD
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：收入时间
	 */
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	/**
	 * 获取：收入时间
	 */
	public Date getIncomeDate() {
		return incomeDate;
	}
	/**
	 * 设置：收入
	 */
	public void setIncomeStatus(Integer incomeStatus) {
		this.incomeStatus = incomeStatus;
	}
	/**
	 * 获取：收入
	 */
	public Integer getIncomeStatus() {
		return incomeStatus;
	}
	/**
	 * 设置：收入资料地址
	 */
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	/**
	 * 获取：收入资料地址
	 */
	public String getDataUrl() {
		return dataUrl;
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
