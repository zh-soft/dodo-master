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

import com.bootdo.blog.domain.SysUserDO;
import com.bootdo.blog.service.SysUserService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Controller
@RequestMapping("/blog/sysUser")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
	
	@GetMapping()
	@RequiresPermissions("blog:sysUser")
	String SysUser(){
	    return "blog/sysUser/sysUser";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysUserDO> sysUserList = sysUserService.list(query);
		int total = sysUserService.count(query);
		PageUtils pageUtils = new PageUtils(sysUserList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/sysUser/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long userId,ModelMap model){
		SysUserDO sysUser = sysUserService.get(userId);
		model.addAttribute("SysUser", sysUser);
	    return "blog/sysUser/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserDO sysUser = sysUserService.get(userId);
		return R.ok().put("sysUser", sysUser);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( SysUserDO sysUser){
		if(sysUserService.save(sysUser)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody SysUserDO sysUser){
		sysUserService.update(sysUser);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long userId){
		if(sysUserService.remove(userId)>0){
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
	public R remove(@RequestParam("ids[]") Long[] userIds){
		sysUserService.batchRemove(userIds);
		
		return R.ok();
	}
	
}
