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

import com.bootdo.blog.domain.SysRoleDO;
import com.bootdo.blog.service.SysRoleService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 角色
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Controller
@RequestMapping("/blog/sysRole")
public class SysRoleController {
	@Autowired
	private SysRoleService sysRoleService;
	
	@GetMapping()
	@RequiresPermissions("blog:sysRole")
	String SysRole(){
	    return "blog/sysRole/sysRole";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysRoleDO> sysRoleList = sysRoleService.list(query);
		int total = sysRoleService.count(query);
		PageUtils pageUtils = new PageUtils(sysRoleList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/sysRole/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long roleId,ModelMap model){
		SysRoleDO sysRole = sysRoleService.get(roleId);
		model.addAttribute("SysRole", sysRole);
	    return "blog/sysRole/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{roleId}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("roleId") Long roleId){
		SysRoleDO sysRole = sysRoleService.get(roleId);
		return R.ok().put("sysRole", sysRole);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( SysRoleDO sysRole){
		if(sysRoleService.save(sysRole)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody SysRoleDO sysRole){
		sysRoleService.update(sysRole);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long roleId){
		if(sysRoleService.remove(roleId)>0){
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
	public R remove(@RequestParam("ids[]") Long[] roleIds){
		sysRoleService.batchRemove(roleIds);
		
		return R.ok();
	}
	
}
