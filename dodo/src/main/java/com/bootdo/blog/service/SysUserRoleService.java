package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysUserRoleDO;

import java.util.List;
import java.util.Map;

/**
 * 用户与角色对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysUserRoleService {
	
	SysUserRoleDO get(Long id);
	
	List<SysUserRoleDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserRoleDO sysUserRole);
	
	int update(SysUserRoleDO sysUserRole);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
