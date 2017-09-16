package com.bootdo.blog.dao;

import com.bootdo.blog.domain.TActiveDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 活动
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface TActiveMapper {

	@Select("select `id`, `Initiator`, `from_time`, `end_time`, `address`, `budget_amount`, `active_users`, `description`, `create_time`, `update_time`, `create_user`, `update_user` from t_active where id = #{id}")
	TActiveDO get(Long id);
	
	@Select("<script>" +
	"select * from t_active " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"initiator != null and initiator != ''\">"+ "and Initiator = #{initiator} " + "</if>" + 
		  		  "<if test=\"fromTime != null and fromTime != ''\">"+ "and from_time = #{fromTime} " + "</if>" + 
		  		  "<if test=\"endTime != null and endTime != ''\">"+ "and end_time = #{endTime} " + "</if>" + 
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"budgetAmount != null and budgetAmount != ''\">"+ "and budget_amount = #{budgetAmount} " + "</if>" + 
		  		  "<if test=\"activeUsers != null and activeUsers != ''\">"+ "and active_users = #{activeUsers} " + "</if>" + 
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
	List<TActiveDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from t_active " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"initiator != null and initiator != ''\">"+ "and Initiator = #{initiator} " + "</if>" + 
		  		  "<if test=\"fromTime != null and fromTime != ''\">"+ "and from_time = #{fromTime} " + "</if>" + 
		  		  "<if test=\"endTime != null and endTime != ''\">"+ "and end_time = #{endTime} " + "</if>" + 
		  		  "<if test=\"address != null and address != ''\">"+ "and address = #{address} " + "</if>" + 
		  		  "<if test=\"budgetAmount != null and budgetAmount != ''\">"+ "and budget_amount = #{budgetAmount} " + "</if>" + 
		  		  "<if test=\"activeUsers != null and activeUsers != ''\">"+ "and active_users = #{activeUsers} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into t_active (`Initiator`, `from_time`, `end_time`, `address`, `budget_amount`, `active_users`, `description`, `create_time`, `update_time`, `create_user`, `update_user`)"
	+ "values (#{initiator}, #{fromTime}, #{endTime}, #{address}, #{budgetAmount}, #{activeUsers}, #{description}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
	int save(TActiveDO tActive);
	
	@Update("<script>"+ 
			"update t_active " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"initiator != null\">`Initiator` = #{initiator}, </if>" + 
                    "<if test=\"fromTime != null\">`from_time` = #{fromTime}, </if>" + 
                    "<if test=\"endTime != null\">`end_time` = #{endTime}, </if>" + 
                    "<if test=\"address != null\">`address` = #{address}, </if>" + 
                    "<if test=\"budgetAmount != null\">`budget_amount` = #{budgetAmount}, </if>" + 
                    "<if test=\"activeUsers != null\">`active_users` = #{activeUsers}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"updateTime != null\">`update_time` = #{updateTime}, </if>" + 
                    "<if test=\"createUser != null\">`create_user` = #{createUser}, </if>" + 
                    "<if test=\"updateUser != null\">`update_user` = #{updateUser}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(TActiveDO tActive);
	
	@Delete("delete from t_active where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from t_active where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
