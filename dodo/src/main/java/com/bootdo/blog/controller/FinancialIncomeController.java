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

import com.bootdo.blog.domain.FinancialIncomeDO;
import com.bootdo.blog.service.FinancialIncomeService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 财务收入表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Controller
@RequestMapping("/blog/financialIncome")
public class FinancialIncomeController {
	@Autowired
	private FinancialIncomeService financialIncomeService;
	
	@GetMapping()
	@RequiresPermissions("blog:financialIncome")
	String FinancialIncome(){
	    return "blog/financialIncome/financialIncome";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("blog:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FinancialIncomeDO> financialIncomeList = financialIncomeService.list(query);
		int total = financialIncomeService.count(query);
		PageUtils pageUtils = new PageUtils(financialIncomeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "blog/financialIncome/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		FinancialIncomeDO financialIncome = financialIncomeService.get(id);
		model.addAttribute("FinancialIncome", financialIncome);
	    return "blog/financialIncome/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("blog:info")
	public R info(@PathVariable("id") Long id){
		FinancialIncomeDO financialIncome = financialIncomeService.get(id);
		return R.ok().put("financialIncome", financialIncome);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("blog:save")
	public R save( FinancialIncomeDO financialIncome){
		if(financialIncomeService.save(financialIncome)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("blog:update")
	public R update(@RequestBody FinancialIncomeDO financialIncome){
		financialIncomeService.update(financialIncome);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("blog:remove")
	public R remove( Long id){
		if(financialIncomeService.remove(id)>0){
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
		financialIncomeService.batchRemove(ids);
		
		return R.ok();
	}
	
}
