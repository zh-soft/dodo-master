package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysLogMapper;
import com.bootdo.blog.domain.SysLogDO;
import com.bootdo.blog.service.SysLogService;



@Service
public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public SysLogDO get(Long id){
		return sysLogMapper.get(id);
	}
	
	@Override
	public List<SysLogDO> list(Map<String, Object> map){
		return sysLogMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysLogMapper.count(map);
	}
	
	@Override
	public int save(SysLogDO sysLog){
		return sysLogMapper.save(sysLog);
	}
	
	@Override
	public int update(SysLogDO sysLog){
		return sysLogMapper.update(sysLog);
	}
	
	@Override
	public int remove(Long id){
		return sysLogMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysLogMapper.batchRemove(ids);
	}
	
}
