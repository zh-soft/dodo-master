package com.bootdo.blog.service;

import com.bootdo.blog.domain.FinancialIncomeDO;

import java.util.List;
import java.util.Map;

/**
 * 财务收入表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public interface FinancialIncomeService {
	
	FinancialIncomeDO get(Long id);
	
	List<FinancialIncomeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FinancialIncomeDO financialIncome);
	
	int update(FinancialIncomeDO financialIncome);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
