package com.bootdo.finance.controller;

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

import com.bootdo.finance.domain.FxActiveDO;
import com.bootdo.finance.service.FxActiveService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 活动
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Controller
@RequestMapping("/finance/fxActive")
public class FxActiveController {
	@Autowired
	private FxActiveService fxActiveService;
	
	@GetMapping()
//	@RequiresPermissions("blog:fxActive")
	String FxActive(){
	    return "finance/fxActive/fxActive";
	}
	
	@ResponseBody
	@GetMapping("/list")
//	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FxActiveDO> fxActiveList = fxActiveService.list(query);
		int total = fxActiveService.count(query);
		PageUtils pageUtils = new PageUtils(fxActiveList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "finance/fxActive/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		FxActiveDO fxActive = fxActiveService.get(id);
		model.addAttribute("FxActive", fxActive);
	    return "finance/fxActive/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("id") Long id){
		FxActiveDO fxActive = fxActiveService.get(id);
		return R.ok().put("fxActive", fxActive);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("finance:save")
	public R save( FxActiveDO fxActive){
		if(fxActiveService.save(fxActive)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("finance:update")
	public R update(@RequestBody FxActiveDO fxActive){
		fxActiveService.update(fxActive);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long id){
		if(fxActiveService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("finance:remove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		fxActiveService.batchRemove(ids);
		
		return R.ok();
	}
	
}
