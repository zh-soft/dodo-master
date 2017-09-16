package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.SysMacroMapper;
import com.bootdo.blog.domain.SysMacroDO;
import com.bootdo.blog.service.SysMacroService;



@Service
public class SysMacroServiceImpl implements SysMacroService {
	@Autowired
	private SysMacroMapper sysMacroMapper;
	
	@Override
	public SysMacroDO get(Long macroId){
		return sysMacroMapper.get(macroId);
	}
	
	@Override
	public List<SysMacroDO> list(Map<String, Object> map){
		return sysMacroMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return sysMacroMapper.count(map);
	}
	
	@Override
	public int save(SysMacroDO sysMacro){
		return sysMacroMapper.save(sysMacro);
	}
	
	@Override
	public int update(SysMacroDO sysMacro){
		return sysMacroMapper.update(sysMacro);
	}
	
	@Override
	public int remove(Long macroId){
		return sysMacroMapper.remove(macroId);
	}
	
	@Override
	public int batchRemove(Long[] macroIds){
		return sysMacroMapper.batchRemove(macroIds);
	}
	
}
