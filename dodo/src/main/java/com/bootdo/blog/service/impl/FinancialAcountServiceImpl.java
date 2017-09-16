package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.FinancialAcountMapper;
import com.bootdo.blog.domain.FinancialAcountDO;
import com.bootdo.blog.service.FinancialAcountService;



@Service
public class FinancialAcountServiceImpl implements FinancialAcountService {
	@Autowired
	private FinancialAcountMapper financialAcountMapper;
	
	@Override
	public FinancialAcountDO get(Long id){
		return financialAcountMapper.get(id);
	}
	
	@Override
	public List<FinancialAcountDO> list(Map<String, Object> map){
		return financialAcountMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return financialAcountMapper.count(map);
	}
	
	@Override
	public int save(FinancialAcountDO financialAcount){
		return financialAcountMapper.save(financialAcount);
	}
	
	@Override
	public int update(FinancialAcountDO financialAcount){
		return financialAcountMapper.update(financialAcount);
	}
	
	@Override
	public int remove(Long id){
		return financialAcountMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return financialAcountMapper.batchRemove(ids);
	}
	
}
