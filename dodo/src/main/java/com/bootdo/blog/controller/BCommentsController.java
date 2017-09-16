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

import com.bootdo.blog.domain.BCommentsDO;
import com.bootdo.blog.service.BCommentsService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:55
 */
@Controller
@RequestMapping("/blog/bComments")
public class BCommentsController {
	@Autowired
	private BCommentsService bCommentsService;
	
	@GetMapping()
	@RequiresPermissions("blog:bComments")
	String BComments(){
	    return "blog/bComments/bComments";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<BCommentsDO> bCommentsList = bCommentsService.list(query);
		int total = bCommentsService.count(query);
		PageUtils pageUtils = new PageUtils(bCommentsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/bComments/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Integer id,ModelMap model){
		BCommentsDO bComments = bCommentsService.get(id);
		model.addAttribute("BComments", bComments);
	    return "blog/bComments/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("id") Integer id){
		BCommentsDO bComments = bCommentsService.get(id);
		return R.ok().put("bComments", bComments);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( BCommentsDO bComments){
		if(bCommentsService.save(bComments)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody BCommentsDO bComments){
		bCommentsService.update(bComments);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Integer id){
		if(bCommentsService.remove(id)>0){
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
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bCommentsService.batchRemove(ids);
		
		return R.ok();
	}
	
}
