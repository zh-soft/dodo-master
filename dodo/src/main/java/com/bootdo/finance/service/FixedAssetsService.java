package com.bootdo.finance.service;

import com.bootdo.finance.domain.FixedAssetsDO;

import java.util.List;
import java.util.Map;

/**
 * 固定资产
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
public interface FixedAssetsService {
	
	FixedAssetsDO get(Long id);
	
	List<FixedAssetsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(FixedAssetsDO fixedAssets);
	
	int update(FixedAssetsDO fixedAssets);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
