package com.bootdo.blog.service;

import com.bootdo.blog.domain.FxActiveDO;

import java.util.List;
import java.util.Map;

/**
 * 活动
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public interface FxActiveService {
	
	FxActiveDO get(Long id);
	
	List<FxActiveDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FxActiveDO fxActive);
	
	int update(FxActiveDO fxActive);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
