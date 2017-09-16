package com.bootdo.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 财务支出表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public class TFinancialExpendDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id 
	private Long id;
	//用户id
	private Long userId;
	//支出类型,羽毛球活动,餐饮,打车,看电影
	private String expendType;
	//支出金额
	private BigDecimal expendAmount;
	//支出单位 RMD,USD
	private String unit;
	//支出状态
	private Integer expendStatus;
	//支出时间
	private Date expendDate;
	//描述
	private String description;
	//支出资料地址
	private String dataUrl;
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
	 * 设置：支出类型,羽毛球活动,餐饮,打车,看电影
	 */
	public void setExpendType(String expendType) {
		this.expendType = expendType;
	}
	/**
	 * 获取：支出类型,羽毛球活动,餐饮,打车,看电影
	 */
	public String getExpendType() {
		return expendType;
	}
	/**
	 * 设置：支出金额
	 */
	public void setExpendAmount(BigDecimal expendAmount) {
		this.expendAmount = expendAmount;
	}
	/**
	 * 获取：支出金额
	 */
	public BigDecimal getExpendAmount() {
		return expendAmount;
	}
	/**
	 * 设置：支出单位 RMD,USD
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 获取：支出单位 RMD,USD
	 */
	public String getUnit() {
		return unit;
	}
	/**
	 * 设置：支出状态
	 */
	public void setExpendStatus(Integer expendStatus) {
		this.expendStatus = expendStatus;
	}
	/**
	 * 获取：支出状态
	 */
	public Integer getExpendStatus() {
		return expendStatus;
	}
	/**
	 * 设置：支出时间
	 */
	public void setExpendDate(Date expendDate) {
		this.expendDate = expendDate;
	}
	/**
	 * 获取：支出时间
	 */
	public Date getExpendDate() {
		return expendDate;
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
	 * 设置：支出资料地址
	 */
	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}
	/**
	 * 获取：支出资料地址
	 */
	public String getDataUrl() {
		return dataUrl;
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
