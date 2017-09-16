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

import com.bootdo.blog.domain.SysRoleMenuDO;
import com.bootdo.blog.service.SysRoleMenuService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 角色与菜单对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Controller
@RequestMapping("/blog/sysRoleMenu")
public class SysRoleMenuController {
	@Autowired
	private SysRoleMenuService sysRoleMenuService;
	
	@GetMapping()
	@RequiresPermissions("blog:sysRoleMenu")
	String SysRoleMenu(){
	    return "blog/sysRoleMenu/sysRoleMenu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysRoleMenuDO> sysRoleMenuList = sysRoleMenuService.list(query);
		int total = sysRoleMenuService.count(query);
		PageUtils pageUtils = new PageUtils(sysRoleMenuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/sysRoleMenu/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		SysRoleMenuDO sysRoleMenu = sysRoleMenuService.get(id);
		model.addAttribute("SysRoleMenu", sysRoleMenu);
	    return "blog/sysRoleMenu/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("id") Long id){
		SysRoleMenuDO sysRoleMenu = sysRoleMenuService.get(id);
		return R.ok().put("sysRoleMenu", sysRoleMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( SysRoleMenuDO sysRoleMenu){
		if(sysRoleMenuService.save(sysRoleMenu)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody SysRoleMenuDO sysRoleMenu){
		sysRoleMenuService.update(sysRoleMenu);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long id){
		if(sysRoleMenuService.remove(id)>0){
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
		sysRoleMenuService.batchRemove(ids);
		
		return R.ok();
	}
	
}
