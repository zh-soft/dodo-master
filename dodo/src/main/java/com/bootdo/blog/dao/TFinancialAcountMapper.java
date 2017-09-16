package com.bootdo.blog.dao;

import com.bootdo.blog.domain.TFinancialAcountDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 财务金额表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface TFinancialAcountMapper {

	@Select("select `id`, `expend_id`, `income_id`, `acount_type`, `total_expend`, `total_income`, `total_acount`, `old_acount`, `create_time`, `update_time`, `create_user`, `update_user` from t_financial_acount where id = #{id}")
	TFinancialAcountDO get(Long id);
	
	@Select("<script>" +
	"select * from t_financial_acount " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"expendId != null and expendId != ''\">"+ "and expend_id = #{expendId} " + "</if>" + 
		  		  "<if test=\"incomeId != null and incomeId != ''\">"+ "and income_id = #{incomeId} " + "</if>" + 
		  		  "<if test=\"acountType != null and acountType != ''\">"+ "and acount_type = #{acountType} " + "</if>" + 
		  		  "<if test=\"totalExpend != null and totalExpend != ''\">"+ "and total_expend = #{totalExpend} " + "</if>" + 
		  		  "<if test=\"totalIncome != null and totalIncome != ''\">"+ "and total_income = #{totalIncome} " + "</if>" + 
		  		  "<if test=\"totalAcount != null and totalAcount != ''\">"+ "and total_acount = #{totalAcount} " + "</if>" + 
		  		  "<if test=\"oldAcount != null and oldAcount != ''\">"+ "and old_acount = #{oldAcount} " + "</if>" + 
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
	List<TFinancialAcountDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from t_financial_acount " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"expendId != null and expendId != ''\">"+ "and expend_id = #{expendId} " + "</if>" + 
		  		  "<if test=\"incomeId != null and incomeId != ''\">"+ "and income_id = #{incomeId} " + "</if>" + 
		  		  "<if test=\"acountType != null and acountType != ''\">"+ "and acount_type = #{acountType} " + "</if>" + 
		  		  "<if test=\"totalExpend != null and totalExpend != ''\">"+ "and total_expend = #{totalExpend} " + "</if>" + 
		  		  "<if test=\"totalIncome != null and totalIncome != ''\">"+ "and total_income = #{totalIncome} " + "</if>" + 
		  		  "<if test=\"totalAcount != null and totalAcount != ''\">"+ "and total_acount = #{totalAcount} " + "</if>" + 
		  		  "<if test=\"oldAcount != null and oldAcount != ''\">"+ "and old_acount = #{oldAcount} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into t_financial_acount (`expend_id`, `income_id`, `acount_type`, `total_expend`, `total_income`, `total_acount`, `old_acount`, `create_time`, `update_time`, `create_user`, `update_user`)"
	+ "values (#{expendId}, #{incomeId}, #{acountType}, #{totalExpend}, #{totalIncome}, #{totalAcount}, #{oldAcount}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
	int save(TFinancialAcountDO tFinancialAcount);
	
	@Update("<script>"+ 
			"update t_financial_acount " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"expendId != null\">`expend_id` = #{expendId}, </if>" + 
                    "<if test=\"incomeId != null\">`income_id` = #{incomeId}, </if>" + 
                    "<if test=\"acountType != null\">`acount_type` = #{acountType}, </if>" + 
                    "<if test=\"totalExpend != null\">`total_expend` = #{totalExpend}, </if>" + 
                    "<if test=\"totalIncome != null\">`total_income` = #{totalIncome}, </if>" + 
                    "<if test=\"totalAcount != null\">`total_acount` = #{totalAcount}, </if>" + 
                    "<if test=\"oldAcount != null\">`old_acount` = #{oldAcount}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"updateTime != null\">`update_time` = #{updateTime}, </if>" + 
                    "<if test=\"createUser != null\">`create_user` = #{createUser}, </if>" + 
                    "<if test=\"updateUser != null\">`update_user` = #{updateUser}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(TFinancialAcountDO tFinancialAcount);
	
	@Delete("delete from t_financial_acount where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from t_financial_acount where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
