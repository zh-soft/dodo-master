package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysUserDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysUserService {
	
	SysUserDO get(Long userId);
	
	List<SysUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysUserDO sysUser);
	
	int update(SysUserDO sysUser);
	
	int remove(Long userId);
	
	int batchRemove(Long[] userIds);
}
