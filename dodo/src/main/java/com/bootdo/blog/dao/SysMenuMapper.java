package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysMenuDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 菜单管理
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysMenuMapper {

	@Select("select `menu_id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `gmt_create`, `gmt_modified` from sys_menu where menu_id = #{id}")
	SysMenuDO get(Long menuId);
	
	@Select("<script>" +
	"select * from sys_menu " + 
			"<where>" + 
		  		  "<if test=\"menuId != null and menuId != ''\">"+ "and menu_id = #{menuId} " + "</if>" + 
		  		  "<if test=\"parentId != null and parentId != ''\">"+ "and parent_id = #{parentId} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"url != null and url != ''\">"+ "and url = #{url} " + "</if>" + 
		  		  "<if test=\"perms != null and perms != ''\">"+ "and perms = #{perms} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"icon != null and icon != ''\">"+ "and icon = #{icon} " + "</if>" + 
		  		  "<if test=\"orderNum != null and orderNum != ''\">"+ "and order_num = #{orderNum} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by menu_id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SysMenuDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_menu " + 
			"<where>" + 
		  		  "<if test=\"menuId != null and menuId != ''\">"+ "and menu_id = #{menuId} " + "</if>" + 
		  		  "<if test=\"parentId != null and parentId != ''\">"+ "and parent_id = #{parentId} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"url != null and url != ''\">"+ "and url = #{url} " + "</if>" + 
		  		  "<if test=\"perms != null and perms != ''\">"+ "and perms = #{perms} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"icon != null and icon != ''\">"+ "and icon = #{icon} " + "</if>" + 
		  		  "<if test=\"orderNum != null and orderNum != ''\">"+ "and order_num = #{orderNum} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_menu (`parent_id`, `name`, `url`, `perms`, `type`, `icon`, `order_num`, `gmt_create`, `gmt_modified`)"
	+ "values (#{parentId}, #{name}, #{url}, #{perms}, #{type}, #{icon}, #{orderNum}, #{gmtCreate}, #{gmtModified})")
	int save(SysMenuDO sysMenu);
	
	@Update("<script>"+ 
			"update sys_menu " + 
					"<set>" + 
		            "<if test=\"menuId != null\">`menu_id` = #{menuId}, </if>" + 
                    "<if test=\"parentId != null\">`parent_id` = #{parentId}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"url != null\">`url` = #{url}, </if>" + 
                    "<if test=\"perms != null\">`perms` = #{perms}, </if>" + 
                    "<if test=\"type != null\">`type` = #{type}, </if>" + 
                    "<if test=\"icon != null\">`icon` = #{icon}, </if>" + 
                    "<if test=\"orderNum != null\">`order_num` = #{orderNum}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
          					"</set>" + 
					"where menu_id = #{menuId}"+
			"</script>")
	int update(SysMenuDO sysMenu);
	
	@Delete("delete from sys_menu where menu_id =#{menuId}")
	int remove(Long menu_id);
	
	@Delete("<script>"+ 
			"delete from sys_menu where menu_id in " + 
					"<foreach item=\"menuId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{menuId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] menuIds);
}
