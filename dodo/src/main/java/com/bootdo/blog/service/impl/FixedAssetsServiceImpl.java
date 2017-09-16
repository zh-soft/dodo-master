package com.bootdo.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.blog.dao.FixedAssetsMapper;
import com.bootdo.blog.domain.FixedAssetsDO;
import com.bootdo.blog.service.FixedAssetsService;



@Service
public class FixedAssetsServiceImpl implements FixedAssetsService {
	@Autowired
	private FixedAssetsMapper fixedAssetsMapper;
	
	@Override
	public FixedAssetsDO get(Long id){
		return fixedAssetsMapper.get(id);
	}
	
	@Override
	public List<FixedAssetsDO> list(Map<String, Object> map){
		return fixedAssetsMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return fixedAssetsMapper.count(map);
	}
	
	@Override
	public int save(FixedAssetsDO fixedAssets){
		return fixedAssetsMapper.save(fixedAssets);
	}
	
	@Override
	public int update(FixedAssetsDO fixedAssets){
		return fixedAssetsMapper.update(fixedAssets);
	}
	
	@Override
	public int remove(Long id){
		return fixedAssetsMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Long[] ids){
		return fixedAssetsMapper.batchRemove(ids);
	}
	
}
