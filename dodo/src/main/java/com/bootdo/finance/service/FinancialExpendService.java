package com.bootdo.finance.service;

import com.bootdo.finance.domain.FinancialExpendDO;

import java.util.List;
import java.util.Map;

/**
 * 财务支出表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public interface FinancialExpendService {
	
	FinancialExpendDO get(Long id);
	
	List<FinancialExpendDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FinancialExpendDO financialExpend);
	
	int update(FinancialExpendDO financialExpend);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
