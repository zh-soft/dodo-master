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

import com.bootdo.finance.domain.FinancialExpendDO;
import com.bootdo.finance.service.FinancialExpendService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 财务支出表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Controller
@RequestMapping("/finance/financialExpend")
public class FinancialExpendController {
	@Autowired
	private FinancialExpendService financialExpendService;
	
	@GetMapping()
	@RequiresPermissions("finance:financialExpend")
	String FinancialExpend(){
	    return "finance/financialExpend/financialExpend";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("finance:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FinancialExpendDO> financialExpendList = financialExpendService.list(query);
		int total = financialExpendService.count(query);
		PageUtils pageUtils = new PageUtils(financialExpendList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "finance/financialExpend/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		FinancialExpendDO financialExpend = financialExpendService.get(id);
		model.addAttribute("FinancialExpend", financialExpend);
	    return "finance/financialExpend/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("finance:info")
	public R info(@PathVariable("id") Long id){
		FinancialExpendDO financialExpend = financialExpendService.get(id);
		return R.ok().put("financialExpend", financialExpend);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("finance:save")
	public R save( FinancialExpendDO financialExpend){
		if(financialExpendService.save(financialExpend)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("finance:update")
	public R update(@RequestBody FinancialExpendDO financialExpend){
		financialExpendService.update(financialExpend);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("finance:remove")
	public R remove( Long id){
		if(financialExpendService.remove(id)>0){
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
		financialExpendService.batchRemove(ids);
		
		return R.ok();
	}
	
}
