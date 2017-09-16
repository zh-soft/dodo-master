package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysUserMapper {

	@Select("select `user_id`, `username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name` from sys_user where user_id = #{id}")
	SysUserDO get(Long userId);
	
	@Select("<script>" +
	"select * from sys_user " + 
			"<where>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" + 
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" + 
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" + 
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by user_id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SysUserDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_user " + 
			"<where>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"email != null and email != ''\">"+ "and email = #{email} " + "</if>" + 
		  		  "<if test=\"mobile != null and mobile != ''\">"+ "and mobile = #{mobile} " + "</if>" + 
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" + 
		  		  "<if test=\"userIdCreate != null and userIdCreate != ''\">"+ "and user_id_create = #{userIdCreate} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_user (`username`, `password`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `name`)"
	+ "values (#{username}, #{password}, #{email}, #{mobile}, #{status}, #{userIdCreate}, #{gmtCreate}, #{gmtModified}, #{name})")
	int save(SysUserDO sysUser);
	
	@Update("<script>"+ 
			"update sys_user " + 
					"<set>" + 
		            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"username != null\">`username` = #{username}, </if>" + 
                    "<if test=\"password != null\">`password` = #{password}, </if>" + 
                    "<if test=\"email != null\">`email` = #{email}, </if>" + 
                    "<if test=\"mobile != null\">`mobile` = #{mobile}, </if>" + 
                    "<if test=\"status != null\">`status` = #{status}, </if>" + 
                    "<if test=\"userIdCreate != null\">`user_id_create` = #{userIdCreate}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
          					"</set>" + 
					"where user_id = #{userId}"+
			"</script>")
	int update(SysUserDO sysUser);
	
	@Delete("delete from sys_user where user_id =#{userId}")
	int remove(Long user_id);
	
	@Delete("<script>"+ 
			"delete from sys_user where user_id in " + 
					"<foreach item=\"userId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{userId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] userIds);
}
