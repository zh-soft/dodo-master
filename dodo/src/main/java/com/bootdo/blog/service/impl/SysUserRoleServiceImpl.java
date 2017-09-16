package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysUserRoleMapper;
import com.bootdo.blog.domain.SysUserRoleDO;
import com.bootdo.blog.service.SysUserRoleService;



@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
	@Autowired
	private SysUserRoleMapper sysUserRoleMapper;
	
	@Override
	public SysUserRoleDO get(Long id){
		return sysUserRoleMapper.get(id);
	}
	
	@Override
	public List<SysUserRoleDO> list(Map<String, Object> map){
		return sysUserRoleMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysUserRoleMapper.count(map);
	}
	
	@Override
	public int save(SysUserRoleDO sysUserRole){
		return sysUserRoleMapper.save(sysUserRole);
	}
	
	@Override
	public int update(SysUserRoleDO sysUserRole){
		return sysUserRoleMapper.update(sysUserRole);
	}
	
	@Override
	public int remove(Long id){
		return sysUserRoleMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysUserRoleMapper.batchRemove(ids);
	}
	
}
