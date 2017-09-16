package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysLogDO;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:55
 */
public interface SysLogService {
	
	SysLogDO get(Long id);
	
	List<SysLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysLogDO sysLog);
	
	int update(SysLogDO sysLog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
