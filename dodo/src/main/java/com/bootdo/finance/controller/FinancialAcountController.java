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

import com.bootdo.finance.domain.FinancialAcountDO;
import com.bootdo.finance.service.FinancialAcountService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;




/**
 * 财务金额表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:54
 */
@Controller
@RequestMapping("/finance/financialAcount")
public class FinancialAcountController {
	@Autowired
	private FinancialAcountService financialAcountService;
	
	@GetMapping()
	@RequiresPermissions("finance:financialAcount")
	String FinancialAcount(){
	    return "finance/financialAcount/financialAcount";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("finance:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<FinancialAcountDO> financialAcountList = financialAcountService.list(query);
		int total = financialAcountService.count(query);
		PageUtils pageUtils = new PageUtils(financialAcountList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "finance/financialAcount/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(Long id,ModelMap model){
		FinancialAcountDO financialAcount = financialAcountService.get(id);
		model.addAttribute("FinancialAcount", financialAcount);
	    return "finance/financialAcount/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("finance:info")
	public R info(@PathVariable("id") Long id){
		FinancialAcountDO financialAcount = financialAcountService.get(id);
		return R.ok().put("financialAcount", financialAcount);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("finance:save")
	public R save( FinancialAcountDO financialAcount){
		if(financialAcountService.save(financialAcount)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("finance:update")
	public R update(@RequestBody FinancialAcountDO financialAcount){
		financialAcountService.update(financialAcount);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("finance:remove")
	public R remove( Long id){
		if(financialAcountService.remove(id)>0){
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
		financialAcountService.batchRemove(ids);
		
		return R.ok();
	}
	
}
