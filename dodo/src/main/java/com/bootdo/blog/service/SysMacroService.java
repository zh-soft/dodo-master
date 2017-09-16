package com.bootdo.blog.service;

import com.bootdo.blog.domain.SysMacroDO;

import java.util.List;
import java.util.Map;

/**
 * 通用字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
public interface SysMacroService {
	
	SysMacroDO get(Long macroId);
	
	List<SysMacroDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SysMacroDO sysMacro);
	
	int update(SysMacroDO sysMacro);
	
	int remove(Long macroId);
	
	int batchRemove(Long[] macroIds);
}
