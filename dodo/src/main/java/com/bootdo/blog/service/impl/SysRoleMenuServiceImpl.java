package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysRoleMenuMapper;
import com.bootdo.blog.domain.SysRoleMenuDO;
import com.bootdo.blog.service.SysRoleMenuService;



@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuMapper sysRoleMenuMapper;
	
	@Override
	public SysRoleMenuDO get(Long id){
		return sysRoleMenuMapper.get(id);
	}
	
	@Override
	public List<SysRoleMenuDO> list(Map<String, Object> map){
		return sysRoleMenuMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysRoleMenuMapper.count(map);
	}
	
	@Override
	public int save(SysRoleMenuDO sysRoleMenu){
		return sysRoleMenuMapper.save(sysRoleMenu);
	}
	
	@Override
	public int update(SysRoleMenuDO sysRoleMenu){
		return sysRoleMenuMapper.update(sysRoleMenu);
	}
	
	@Override
	public int remove(Long id){
		return sysRoleMenuMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return sysRoleMenuMapper.batchRemove(ids);
	}
	
}
