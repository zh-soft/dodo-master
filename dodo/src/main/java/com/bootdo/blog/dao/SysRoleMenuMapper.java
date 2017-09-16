package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysRoleMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 角色与菜单对应关系
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysRoleMenuMapper {

	@Select("select `id`, `role_id`, `menu_id` from sys_role_menu where id = #{id}")
	SysRoleMenuDO get(Long id);
	
	@Select("<script>" +
	"select * from sys_role_menu " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
		  		  "<if test=\"menuId != null and menuId != ''\">"+ "and menu_id = #{menuId} " + "</if>" + 
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
	List<SysRoleMenuDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_role_menu " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"roleId != null and roleId != ''\">"+ "and role_id = #{roleId} " + "</if>" + 
		  		  "<if test=\"menuId != null and menuId != ''\">"+ "and menu_id = #{menuId} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_role_menu (`role_id`, `menu_id`)"
	+ "values (#{roleId}, #{menuId})")
	int save(SysRoleMenuDO sysRoleMenu);
	
	@Update("<script>"+ 
			"update sys_role_menu " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"roleId != null\">`role_id` = #{roleId}, </if>" + 
                    "<if test=\"menuId != null\">`menu_id` = #{menuId}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(SysRoleMenuDO sysRoleMenu);
	
	@Delete("delete from sys_role_menu where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from sys_role_menu where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
