package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysLogDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 系统日志
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:55
 */
@Mapper
public interface SysLogMapper {

	@Select("select `id`, `user_id`, `username`, `operation`, `time`, `method`, `params`, `ip`, `gmt_create` from sys_log where id = #{id}")
	SysLogDO get(Long id);
	
	@Select("<script>" +
	"select * from sys_log " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" + 
		  		  "<if test=\"operation != null and operation != ''\">"+ "and operation = #{operation} " + "</if>" + 
		  		  "<if test=\"time != null and time != ''\">"+ "and time = #{time} " + "</if>" + 
		  		  "<if test=\"method != null and method != ''\">"+ "and method = #{method} " + "</if>" + 
		  		  "<if test=\"params != null and params != ''\">"+ "and params = #{params} " + "</if>" + 
		  		  "<if test=\"ip != null and ip != ''\">"+ "and ip = #{ip} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
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
	List<SysLogDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_log " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"username != null and username != ''\">"+ "and username = #{username} " + "</if>" + 
		  		  "<if test=\"operation != null and operation != ''\">"+ "and operation = #{operation} " + "</if>" + 
		  		  "<if test=\"time != null and time != ''\">"+ "and time = #{time} " + "</if>" + 
		  		  "<if test=\"method != null and method != ''\">"+ "and method = #{method} " + "</if>" + 
		  		  "<if test=\"params != null and params != ''\">"+ "and params = #{params} " + "</if>" + 
		  		  "<if test=\"ip != null and ip != ''\">"+ "and ip = #{ip} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_log (`user_id`, `username`, `operation`, `time`, `method`, `params`, `ip`, `gmt_create`)"
	+ "values (#{userId}, #{username}, #{operation}, #{time}, #{method}, #{params}, #{ip}, #{gmtCreate})")
	int save(SysLogDO sysLog);
	
	@Update("<script>"+ 
			"update sys_log " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"username != null\">`username` = #{username}, </if>" + 
                    "<if test=\"operation != null\">`operation` = #{operation}, </if>" + 
                    "<if test=\"time != null\">`time` = #{time}, </if>" + 
                    "<if test=\"method != null\">`method` = #{method}, </if>" + 
                    "<if test=\"params != null\">`params` = #{params}, </if>" + 
                    "<if test=\"ip != null\">`ip` = #{ip}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(SysLogDO sysLog);
	
	@Delete("delete from sys_log where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from sys_log where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
