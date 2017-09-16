package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysRoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 角色
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysRoleMapper {

	@Select("select `role_id`, `role_name`, `role_sign`, `remark`, `user_id_create`, `gmt_create`, `gmt_modified` from sys_role where role_id = #{id}")
	SysRoleDO get(Long roleId);
	
	@Select("<script>" +
	"select * from sys_role " + 
			"<where>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
		  		  "<if test=\"roleName != null and roleName != ''\">"+ "and role_name = #{roleName} " + "</if>" + 
		  		  "<if test=\"roleSign != null and roleSign != ''\">"+ "and role_sign = #{roleSign} " + "</if>" + 
		  		  "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" + 
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by role_id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SysRoleDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_role " + 
			"<where>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
		  		  "<if test=\"roleName != null and roleName != ''\">"+ "and role_name = #{roleName} " + "</if>" + 
		  		  "<if test=\"roleSign != null and roleSign != ''\">"+ "and role_sign = #{roleSign} " + "</if>" + 
		  		  "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" + 
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_role (`role_name`, `role_sign`, `remark`, `user_id_create`, `gmt_create`, `gmt_modified`)"
	+ "values (#{roleName}, #{roleSign}, #{remark}, #{userIdCreate}, #{gmtCreate}, #{gmtModified})")
	int save(SysRoleDO sysRole);
	
	@Update("<script>"+ 
			"update sys_role " + 
					"<set>" + 
		            "<if test=\"roleId != null\">`role_id` = #{roleId}, </if>" + 
                    "<if test=\"roleName != null\">`role_name` = #{roleName}, </if>" + 
                    "<if test=\"roleSign != null\">`role_sign` = #{roleSign}, </if>" + 
                    "<if test=\"remark != null\">`remark` = #{remark}, </if>" + 
                    "<if test=\"userIdCreate != null\">`user_id_create` = #{userIdCreate}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
          					"</set>" + 
					"where role_id = #{roleId}"+
			"</script>")
	int update(SysRoleDO sysRole);
	
	@Delete("delete from sys_role where role_id =#{roleId}")
	int remove(Long role_id);
	
	@Delete("<script>"+ 
			"delete from sys_role where role_id in " + 
					"<foreach item=\"roleId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{roleId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] roleIds);
}
