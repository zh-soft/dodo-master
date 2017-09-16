package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysMenuMapper;
import com.bootdo.blog.domain.SysMenuDO;
import com.bootdo.blog.service.SysMenuService;



@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapper sysMenuMapper;
	
	@Override
	public SysMenuDO get(Long menuId){
		return sysMenuMapper.get(menuId);
	}
	
	@Override
	public List<SysMenuDO> list(Map<String, Object> map){
		return sysMenuMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysMenuMapper.count(map);
	}
	
	@Override
	public int save(SysMenuDO sysMenu){
		return sysMenuMapper.save(sysMenu);
	}
	
	@Override
	public int update(SysMenuDO sysMenu){
		return sysMenuMapper.update(sysMenu);
	}
	
	@Override
	public int remove(Long menuId){
		return sysMenuMapper.remove(menuId);
	}
	
	@Override
	public int batchRemove(Long[] menuIds){
		return sysMenuMapper.batchRemove(menuIds);
	}
	
}
