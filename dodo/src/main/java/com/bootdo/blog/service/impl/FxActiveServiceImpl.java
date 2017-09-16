package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.FxActiveMapper;
import com.bootdo.blog.domain.FxActiveDO;
import com.bootdo.blog.service.FxActiveService;



@Service
public class FxActiveServiceImpl implements FxActiveService {
	@Autowired
	private FxActiveMapper fxActiveMapper;
	
	@Override
	public FxActiveDO get(Long id){
		return fxActiveMapper.get(id);
	}
	
	@Override
	public List<FxActiveDO> list(Map<String, Object> map){
		return fxActiveMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fxActiveMapper.count(map);
	}
	
	@Override
	public int save(FxActiveDO fxActive){
		return fxActiveMapper.save(fxActive);
	}
	
	@Override
	public int update(FxActiveDO fxActive){
		return fxActiveMapper.update(fxActive);
	}
	
	@Override
	public int remove(Long id){
		return fxActiveMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fxActiveMapper.batchRemove(ids);
	}
	
}
