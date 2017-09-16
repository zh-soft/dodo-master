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

import com.bootdo.blog.domain.SysMacroDO;
import com.bootdo.blog.service.SysMacroService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 通用字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Controller
@RequestMapping("/blog/sysMacro")
public class SysMacroController {
	@Autowired
	private SysMacroService sysMacroService;
	
	@GetMapping()
	@RequiresPermissions("blog:sysMacro")
	String SysMacro(){
	    return "blog/sysMacro/sysMacro";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysMacroDO> sysMacroList = sysMacroService.list(query);
		int total = sysMacroService.count(query);
		PageUtils pageUtils = new PageUtils(sysMacroList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/sysMacro/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long macroId,ModelMap model){
		SysMacroDO sysMacro = sysMacroService.get(macroId);
		model.addAttribute("SysMacro", sysMacro);
	    return "blog/sysMacro/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{macroId}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("macroId") Long macroId){
		SysMacroDO sysMacro = sysMacroService.get(macroId);
		return R.ok().put("sysMacro", sysMacro);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( SysMacroDO sysMacro){
		if(sysMacroService.save(sysMacro)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody SysMacroDO sysMacro){
		sysMacroService.update(sysMacro);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long macroId){
		if(sysMacroService.remove(macroId)>0){
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
	public R remove(@RequestParam("ids[]") Long[] macroIds){
		sysMacroService.batchRemove(macroIds);
		
		return R.ok();
	}
	
}
