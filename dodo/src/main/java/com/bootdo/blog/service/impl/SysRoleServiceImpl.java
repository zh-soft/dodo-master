package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysRoleMapper;
import com.bootdo.blog.domain.SysRoleDO;
import com.bootdo.blog.service.SysRoleService;



@Service
public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleMapper sysRoleMapper;
	
	@Override
	public SysRoleDO get(Long roleId){
		return sysRoleMapper.get(roleId);
	}
	
	@Override
	public List<SysRoleDO> list(Map<String, Object> map){
		return sysRoleMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysRoleMapper.count(map);
	}
	
	@Override
	public int save(SysRoleDO sysRole){
		return sysRoleMapper.save(sysRole);
	}
	
	@Override
	public int update(SysRoleDO sysRole){
		return sysRoleMapper.update(sysRole);
	}
	
	@Override
	public int remove(Long roleId){
		return sysRoleMapper.remove(roleId);
	}
	
	@Override
	public int batchRemove(Long[] roleIds){
		return sysRoleMapper.batchRemove(roleIds);
	}
	
}
