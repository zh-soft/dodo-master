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

import com.bootdo.blog.domain.BContentDO;
import com.bootdo.blog.service.BContentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 文章内容
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:55
 */
@Controller
@RequestMapping("/blog/bContent")
public class BContentController {
	@Autowired
	private BContentService bContentService;
	
	@GetMapping()
	@RequiresPermissions("blog:bContent:bContent")
	String BContent(){
	    return "blog/bContent/bContent";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:bContent:bContent")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);
		List<BContentDO> bContentList = bContentService.list(query);
		int total = bContentService.count(query);
		PageUtils pageUtils = new PageUtils(bContentList, total);
		return pageUtils;
	}
//	@ResponseBody
//	@GetMapping("/list")
//	@RequiresPermissions("blog:list")
//	public PageUtils list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//		List<BContentDO> bContentList = bContentService.list(query);
//		int total = bContentService.count(query);
//		PageUtils pageUtils = new PageUtils(bContentList, total);
//		return pageUtils;
//	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/bContent/add";
	}


	@GetMapping("/edit/{cid}")
	//@RequiresPermissions("blog:bComments")
	String edit(@PathVariable("cid") Long cid,ModelMap model){
		BContentDO bContent = bContentService.get(cid);
		model.addAttribute("bContent", bContent);
	    return "blog/bContent/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{cid}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("cid") Long cid){
		BContentDO bContent = bContentService.get(cid);
		return R.ok().put("bContent", bContent);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( BContentDO bContent){
		if(bContentService.save(bContent)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody BContentDO bContent){
		bContentService.update(bContent);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long cid){
		if(bContentService.remove(cid)>0){
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
	public R remove(@RequestParam("ids[]") Long[] cids){
		bContentService.batchRemove(cids);
		
		return R.ok();
	}
	
}
