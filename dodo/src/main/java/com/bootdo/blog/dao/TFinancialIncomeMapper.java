package com.bootdo.blog.dao;

import com.bootdo.blog.domain.TFinancialIncomeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 财务收入表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface TFinancialIncomeMapper {

	@Select("select `id`, `user_id`, `income_type`, `income_amount`, `unit`, `income_date`, `income_status`, `data_url`, `description`, `create_time`, `update_time`, `create_user`, `update_user` from t_financial_income where id = #{id}")
	TFinancialIncomeDO get(Long id);
	
	@Select("<script>" +
	"select * from t_financial_income " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"incomeType != null and incomeType != ''\">"+ "and income_type = #{incomeType} " + "</if>" + 
		  		  "<if test=\"incomeAmount != null and incomeAmount != ''\">"+ "and income_amount = #{incomeAmount} " + "</if>" + 
		  		  "<if test=\"unit != null and unit != ''\">"+ "and unit = #{unit} " + "</if>" + 
		  		  "<if test=\"incomeDate != null and incomeDate != ''\">"+ "and income_date = #{incomeDate} " + "</if>" + 
		  		  "<if test=\"incomeStatus != null and incomeStatus != ''\">"+ "and income_status = #{incomeStatus} " + "</if>" + 
		  		  "<if test=\"dataUrl != null and dataUrl != ''\">"+ "and data_url = #{dataUrl} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<TFinancialIncomeDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from t_financial_income " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"incomeType != null and incomeType != ''\">"+ "and income_type = #{incomeType} " + "</if>" + 
		  		  "<if test=\"incomeAmount != null and incomeAmount != ''\">"+ "and income_amount = #{incomeAmount} " + "</if>" + 
		  		  "<if test=\"unit != null and unit != ''\">"+ "and unit = #{unit} " + "</if>" + 
		  		  "<if test=\"incomeDate != null and incomeDate != ''\">"+ "and income_date = #{incomeDate} " + "</if>" + 
		  		  "<if test=\"incomeStatus != null and incomeStatus != ''\">"+ "and income_status = #{incomeStatus} " + "</if>" + 
		  		  "<if test=\"dataUrl != null and dataUrl != ''\">"+ "and data_url = #{dataUrl} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into t_financial_income (`user_id`, `income_type`, `income_amount`, `unit`, `income_date`, `income_status`, `data_url`, `description`, `create_time`, `update_time`, `create_user`, `update_user`)"
	+ "values (#{userId}, #{incomeType}, #{incomeAmount}, #{unit}, #{incomeDate}, #{incomeStatus}, #{dataUrl}, #{description}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
	int save(TFinancialIncomeDO tFinancialIncome);
	
	@Update("<script>"+ 
			"update t_financial_income " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"incomeType != null\">`income_type` = #{incomeType}, </if>" + 
                    "<if test=\"incomeAmount != null\">`income_amount` = #{incomeAmount}, </if>" + 
                    "<if test=\"unit != null\">`unit` = #{unit}, </if>" + 
                    "<if test=\"incomeDate != null\">`income_date` = #{incomeDate}, </if>" + 
                    "<if test=\"incomeStatus != null\">`income_status` = #{incomeStatus}, </if>" + 
                    "<if test=\"dataUrl != null\">`data_url` = #{dataUrl}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"updateTime != null\">`update_time` = #{updateTime}, </if>" + 
                    "<if test=\"createUser != null\">`create_user` = #{createUser}, </if>" + 
                    "<if test=\"updateUser != null\">`update_user` = #{updateUser}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(TFinancialIncomeDO tFinancialIncome);
	
	@Delete("delete from t_financial_income where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from t_financial_income where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
