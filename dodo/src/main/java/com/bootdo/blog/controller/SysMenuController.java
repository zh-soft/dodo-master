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

import com.bootdo.blog.domain.SysMenuDO;
import com.bootdo.blog.service.SysMenuService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 菜单管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Controller
@RequestMapping("/blog/sysMenu")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@GetMapping()
	@RequiresPermissions("blog:sysMenu")
	String SysMenu(){
	    return "blog/sysMenu/sysMenu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SysMenuDO> sysMenuList = sysMenuService.list(query);
		int total = sysMenuService.count(query);
		PageUtils pageUtils = new PageUtils(sysMenuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/sysMenu/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long menuId,ModelMap model){
		SysMenuDO sysMenu = sysMenuService.get(menuId);
		model.addAttribute("SysMenu",sysMenu);
	    return "blog/sysMenu/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{menuId}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("menuId") Long menuId){
		SysMenuDO sysMenu = sysMenuService.get(menuId);
		return R.ok().put("sysMenu", sysMenu);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( SysMenuDO sysMenu){
		if(sysMenuService.save(sysMenu)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody SysMenuDO sysMenu){
		sysMenuService.update(sysMenu);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long menuId){
		if(sysMenuService.remove(menuId)>0){
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
	public R remove(@RequestParam("ids[]") Long[] menuIds){
		sysMenuService.batchRemove(menuIds);
		
		return R.ok();
	}
	
}
