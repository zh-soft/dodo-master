package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 角色
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysRoleService {
	
	SysRoleDO get(Long roleId);
	
	List<SysRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysRoleDO sysRole);
	
	int update(SysRoleDO sysRole);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
