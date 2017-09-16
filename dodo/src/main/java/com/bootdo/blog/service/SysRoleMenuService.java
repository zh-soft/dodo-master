package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysRoleMenuDO;

import java.util.List;
import java.util.Map;

/**
 * 角色与菜单对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysRoleMenuService {
	
	SysRoleMenuDO get(Long id);
	
	List<SysRoleMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysRoleMenuDO sysRoleMenu);
	
	int update(SysRoleMenuDO sysRoleMenu);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
