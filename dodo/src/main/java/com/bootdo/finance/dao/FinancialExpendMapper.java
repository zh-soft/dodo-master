package com.bootdo.finance.dao;

import com.bootdo.finance.domain.FinancialExpendDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 财务支出表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Mapper
public interface FinancialExpendMapper {

	@Select("select `id`, `user_id`, `expend_type`, `expend_amount`, `unit`, `expend_status`, `expend_date`, `description`, `data_url`, `create_time`, `update_time`, `create_user`, `update_user` from financial_expend where id = #{id}")
	FinancialExpendDO get(Long id);
	
	@Select("<script>" +
	"select * from financial_expend " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"expendType != null and expendType != ''\">"+ "and expend_type = #{expendType} " + "</if>" + 
		  		  "<if test=\"expendAmount != null and expendAmount != ''\">"+ "and expend_amount = #{expendAmount} " + "</if>" + 
		  		  "<if test=\"unit != null and unit != ''\">"+ "and unit = #{unit} " + "</if>" + 
		  		  "<if test=\"expendStatus != null and expendStatus != ''\">"+ "and expend_status = #{expendStatus} " + "</if>" + 
		  		  "<if test=\"expendDate != null and expendDate != ''\">"+ "and expend_date = #{expendDate} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"dataUrl != null and dataUrl != ''\">"+ "and data_url = #{dataUrl} " + "</if>" + 
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
	List<FinancialExpendDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from financial_expend " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"expendType != null and expendType != ''\">"+ "and expend_type = #{expendType} " + "</if>" + 
		  		  "<if test=\"expendAmount != null and expendAmount != ''\">"+ "and expend_amount = #{expendAmount} " + "</if>" + 
		  		  "<if test=\"unit != null and unit != ''\">"+ "and unit = #{unit} " + "</if>" + 
		  		  "<if test=\"expendStatus != null and expendStatus != ''\">"+ "and expend_status = #{expendStatus} " + "</if>" + 
		  		  "<if test=\"expendDate != null and expendDate != ''\">"+ "and expend_date = #{expendDate} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"dataUrl != null and dataUrl != ''\">"+ "and data_url = #{dataUrl} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into financial_expend (`user_id`, `expend_type`, `expend_amount`, `unit`, `expend_status`, `expend_date`, `description`, `data_url`, `create_time`, `update_time`, `create_user`, `update_user`)"
	+ "values (#{userId}, #{expendType}, #{expendAmount}, #{unit}, #{expendStatus}, #{expendDate}, #{description}, #{dataUrl}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
	int save(FinancialExpendDO financialExpend);
	
	@Update("<script>"+ 
			"update financial_expend " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"expendType != null\">`expend_type` = #{expendType}, </if>" + 
                    "<if test=\"expendAmount != null\">`expend_amount` = #{expendAmount}, </if>" + 
                    "<if test=\"unit != null\">`unit` = #{unit}, </if>" + 
                    "<if test=\"expendStatus != null\">`expend_status` = #{expendStatus}, </if>" + 
                    "<if test=\"expendDate != null\">`expend_date` = #{expendDate}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"dataUrl != null\">`data_url` = #{dataUrl}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"updateTime != null\">`update_time` = #{updateTime}, </if>" + 
                    "<if test=\"createUser != null\">`create_user` = #{createUser}, </if>" + 
                    "<if test=\"updateUser != null\">`update_user` = #{updateUser}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(FinancialExpendDO financialExpend);
	
	@Delete("delete from financial_expend where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from financial_expend where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
