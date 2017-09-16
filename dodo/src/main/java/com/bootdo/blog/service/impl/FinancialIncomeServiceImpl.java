package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.FinancialIncomeMapper;
import com.bootdo.blog.domain.FinancialIncomeDO;
import com.bootdo.blog.service.FinancialIncomeService;



@Service
public class FinancialIncomeServiceImpl implements FinancialIncomeService {
	@Autowired
	private FinancialIncomeMapper financialIncomeMapper;
	
	@Override
	public FinancialIncomeDO get(Long id){
		return financialIncomeMapper.get(id);
	}
	
	@Override
	public List<FinancialIncomeDO> list(Map<String, Object> map){
		return financialIncomeMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return financialIncomeMapper.count(map);
	}
	
	@Override
	public int save(FinancialIncomeDO financialIncome){
		return financialIncomeMapper.save(financialIncome);
	}
	
	@Override
	public int update(FinancialIncomeDO financialIncome){
		return financialIncomeMapper.update(financialIncome);
	}
	
	@Override
	public int remove(Long id){
		return financialIncomeMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return financialIncomeMapper.batchRemove(ids);
	}
	
}
