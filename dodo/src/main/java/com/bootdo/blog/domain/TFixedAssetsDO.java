package com.bootdo.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 固定资产
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public class TFixedAssetsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id 
	private Long id;
	//资产类型
	private String assetsType;
	//所属部门
	private String department;
	//购买金额
	private BigDecimal buyPrice;
	//购买时间
	private Date buyDate;
	//资产描述
	private String description;
	//资产所在位置
	private String position;
	//资产url
	private String picUrl;
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
	 * 设置：资产类型
	 */
	public void setAssetsType(String assetsType) {
		this.assetsType = assetsType;
	}
	/**
	 * 获取：资产类型
	 */
	public String getAssetsType() {
		return assetsType;
	}
	/**
	 * 设置：所属部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 获取：所属部门
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * 设置：购买金额
	 */
	public void setBuyPrice(BigDecimal buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * 获取：购买金额
	 */
	public BigDecimal getBuyPrice() {
		return buyPrice;
	}
	/**
	 * 设置：购买时间
	 */
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	/**
	 * 获取：购买时间
	 */
	public Date getBuyDate() {
		return buyDate;
	}
	/**
	 * 设置：资产描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：资产描述
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置：资产所在位置
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * 获取：资产所在位置
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * 设置：资产url
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	/**
	 * 获取：资产url
	 */
	public String getPicUrl() {
		return picUrl;
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
