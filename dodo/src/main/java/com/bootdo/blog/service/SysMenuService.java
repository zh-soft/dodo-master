package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysMenuDO;

import java.util.List;
import java.util.Map;

/**
 * 菜单管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysMenuService {
	
	SysMenuDO get(Long menuId);
	
	List<SysMenuDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysMenuDO sysMenu);
	
	int update(SysMenuDO sysMenu);
	
	int remove(Long menuId);
	
	int batchRemove(Long[] menuIds);
}
