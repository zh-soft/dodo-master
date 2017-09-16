package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.FinancialExpendMapper;
import com.bootdo.blog.domain.FinancialExpendDO;
import com.bootdo.blog.service.FinancialExpendService;



@Service
public class FinancialExpendServiceImpl implements FinancialExpendService {
	@Autowired
	private FinancialExpendMapper financialExpendMapper;
	
	@Override
	public FinancialExpendDO get(Long id){
		return financialExpendMapper.get(id);
	}
	
	@Override
	public List<FinancialExpendDO> list(Map<String, Object> map){
		return financialExpendMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return financialExpendMapper.count(map);
	}
	
	@Override
	public int save(FinancialExpendDO financialExpend){
		return financialExpendMapper.save(financialExpend);
	}
	
	@Override
	public int update(FinancialExpendDO financialExpend){
		return financialExpendMapper.update(financialExpend);
	}
	
	@Override
	public int remove(Long id){
		return financialExpendMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return financialExpendMapper.batchRemove(ids);
	}
	
}
