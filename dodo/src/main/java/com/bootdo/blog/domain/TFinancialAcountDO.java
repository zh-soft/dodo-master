package com.bootdo.blog.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 财务金额表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public class TFinancialAcountDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id 
	private Long id;
	//财务支出id
	private Long expendId;
	//财务收入id
	private Long incomeId;
	//支出类型 income,expend
	private String acountType;
	//支出金额
	private BigDecimal totalExpend;
	//收入金额
	private BigDecimal totalIncome;
	//当前总金额
	private BigDecimal totalAcount;
	//前一期账户金额
	private BigDecimal oldAcount;
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
	 * 设置：财务支出id
	 */
	public void setExpendId(Long expendId) {
		this.expendId = expendId;
	}
	/**
	 * 获取：财务支出id
	 */
	public Long getExpendId() {
		return expendId;
	}
	/**
	 * 设置：财务收入id
	 */
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}
	/**
	 * 获取：财务收入id
	 */
	public Long getIncomeId() {
		return incomeId;
	}
	/**
	 * 设置：支出类型 income,expend
	 */
	public void setAcountType(String acountType) {
		this.acountType = acountType;
	}
	/**
	 * 获取：支出类型 income,expend
	 */
	public String getAcountType() {
		return acountType;
	}
	/**
	 * 设置：支出金额
	 */
	public void setTotalExpend(BigDecimal totalExpend) {
		this.totalExpend = totalExpend;
	}
	/**
	 * 获取：支出金额
	 */
	public BigDecimal getTotalExpend() {
		return totalExpend;
	}
	/**
	 * 设置：收入金额
	 */
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	/**
	 * 获取：收入金额
	 */
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	/**
	 * 设置：当前总金额
	 */
	public void setTotalAcount(BigDecimal totalAcount) {
		this.totalAcount = totalAcount;
	}
	/**
	 * 获取：当前总金额
	 */
	public BigDecimal getTotalAcount() {
		return totalAcount;
	}
	/**
	 * 设置：前一期账户金额
	 */
	public void setOldAcount(BigDecimal oldAcount) {
		this.oldAcount = oldAcount;
	}
	/**
	 * 获取：前一期账户金额
	 */
	public BigDecimal getOldAcount() {
		return oldAcount;
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
