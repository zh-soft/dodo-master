package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysUserRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 用户与角色对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysUserRoleMapper {

	@Select("select `id`, `user_id`, `role_id` from sys_user_role where id = #{id}")
	SysUserRoleDO get(Long id);
	
	@Select("<script>" +
	"select * from sys_user_role " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
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
	List<SysUserRoleDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_user_role " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_user_role (`user_id`, `role_id`)"
	+ "values (#{userId}, #{roleId})")
	int save(SysUserRoleDO sysUserRole);
	
	@Update("<script>"+ 
			"update sys_user_role " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"roleId != null\">`role_id` = #{roleId}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(SysUserRoleDO sysUserRole);
	
	@Delete("delete from sys_user_role where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from sys_user_role where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
