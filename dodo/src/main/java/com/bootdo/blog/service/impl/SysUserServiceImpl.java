package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysUserMapper;
import com.bootdo.blog.domain.SysUserDO;
import com.bootdo.blog.service.SysUserService;



@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public SysUserDO get(Long userId){
		return sysUserMapper.get(userId);
	}
	
	@Override
	public List<SysUserDO> list(Map<String, Object> map){
		return sysUserMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserMapper.count(map);
	}
	
	@Override
	public int save(SysUserDO sysUser){
		return sysUserMapper.save(sysUser);
	}
	
	@Override
	public int update(SysUserDO sysUser){
		return sysUserMapper.update(sysUser);
	}
	
	@Override
	public int remove(Long userId){
		return sysUserMapper.remove(userId);
	}
	
	@Override
	public int batchRemove(Long[] userIds){
		return sysUserMapper.batchRemove(userIds);
	}
	
}
