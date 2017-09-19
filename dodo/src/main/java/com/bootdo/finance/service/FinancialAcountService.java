package com.bootdo.finance.service;

import com.bootdo.finance.domain.FinancialAcountDO;

import java.util.List;
import java.util.Map;

/**
 * 财务金额表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:54
 */
public interface FinancialAcountService {
	
	FinancialAcountDO get(Long id);
	
	List<FinancialAcountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FinancialAcountDO financialAcount);
	
	int update(FinancialAcountDO financialAcount);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
