package com.bootdo.blog.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.blog.domain.FixedAssetsDO;
import com.bootdo.blog.service.FixedAssetsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 固定资产
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Controller
@RequestMapping("/blog/fixedAssets")
public class FixedAssetsController {
	@Autowired
	private FixedAssetsService fixedAssetsService;
	
	@GetMapping()
	@RequiresPermissions("blog:fixedAssets")
	String FixedAssets(){
	    return "blog/fixedAssets/fixedAssets";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FixedAssetsDO> fixedAssetsList = fixedAssetsService.list(query);
		int total = fixedAssetsService.count(query);
		PageUtils pageUtils = new PageUtils(fixedAssetsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/fixedAssets/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		FixedAssetsDO fixedAssets = fixedAssetsService.get(id);
		model.addAttribute("FixedAssets", fixedAssets);
	    return "blog/fixedAssets/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("id") Long id){
		FixedAssetsDO fixedAssets = fixedAssetsService.get(id);
		return R.ok().put("fixedAssets", fixedAssets);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( FixedAssetsDO fixedAssets){
		if(fixedAssetsService.save(fixedAssets)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody FixedAssetsDO fixedAssets){
		fixedAssetsService.update(fixedAssets);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long id){
		if(fixedAssetsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fixedAssetsService.batchRemove(ids);
		
		return R.ok();
	}
	
}
