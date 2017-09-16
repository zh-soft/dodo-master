package com.bootdo.blog.dao;

import com.bootdo.blog.domain.SysMacroDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 通用字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 16:47:56
 */
@Mapper
public interface SysMacroMapper {

	@Select("select `macro_id`, `type_id`, `name`, `value`, `status`, `type`, `order_num`, `remark`, `gmt_create`, `gmt_modified` from sys_macro where macro_id = #{id}")
	SysMacroDO get(Long macroId);
	
	@Select("<script>" +
	"select * from sys_macro " + 
			"<where>" + 
		  		  "<if test=\"macroId != null and macroId != ''\">"+ "and macro_id = #{macroId} " + "</if>" + 
		  		  "<if test=\"typeId != null and typeId != ''\">"+ "and type_id = #{typeId} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"value != null and value != ''\">"+ "and value = #{value} " + "</if>" + 
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"orderNum != null and orderNum != ''\">"+ "and order_num = #{orderNum} " + "</if>" + 
		  		  "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by macro_id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<SysMacroDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from sys_macro " + 
			"<where>" + 
		  		  "<if test=\"macroId != null and macroId != ''\">"+ "and macro_id = #{macroId} " + "</if>" + 
		  		  "<if test=\"typeId != null and typeId != ''\">"+ "and type_id = #{typeId} " + "</if>" + 
		  		  "<if test=\"name != null and name != ''\">"+ "and name = #{name} " + "</if>" + 
		  		  "<if test=\"value != null and value != ''\">"+ "and value = #{value} " + "</if>" + 
		  		  "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" + 
		  		  "<if test=\"type != null and type != ''\">"+ "and type = #{type} " + "</if>" + 
		  		  "<if test=\"orderNum != null and orderNum != ''\">"+ "and order_num = #{orderNum} " + "</if>" + 
		  		  "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" + 
		  		  "<if test=\"gmtCreate != null and gmtCreate != ''\">"+ "and gmt_create = #{gmtCreate} " + "</if>" + 
		  		  "<if test=\"gmtModified != null and gmtModified != ''\">"+ "and gmt_modified = #{gmtModified} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into sys_macro (`type_id`, `name`, `value`, `status`, `type`, `order_num`, `remark`, `gmt_create`, `gmt_modified`)"
	+ "values (#{typeId}, #{name}, #{value}, #{status}, #{type}, #{orderNum}, #{remark}, #{gmtCreate}, #{gmtModified})")
	int save(SysMacroDO sysMacro);
	
	@Update("<script>"+ 
			"update sys_macro " + 
					"<set>" + 
		            "<if test=\"macroId != null\">`macro_id` = #{macroId}, </if>" + 
                    "<if test=\"typeId != null\">`type_id` = #{typeId}, </if>" + 
                    "<if test=\"name != null\">`name` = #{name}, </if>" + 
                    "<if test=\"value != null\">`value` = #{value}, </if>" + 
                    "<if test=\"status != null\">`status` = #{status}, </if>" + 
                    "<if test=\"type != null\">`type` = #{type}, </if>" + 
                    "<if test=\"orderNum != null\">`order_num` = #{orderNum}, </if>" + 
                    "<if test=\"remark != null\">`remark` = #{remark}, </if>" + 
                    "<if test=\"gmtCreate != null\">`gmt_create` = #{gmtCreate}, </if>" + 
                    "<if test=\"gmtModified != null\">`gmt_modified` = #{gmtModified}, </if>" + 
          					"</set>" + 
					"where macro_id = #{macroId}"+
			"</script>")
	int update(SysMacroDO sysMacro);
	
	@Delete("delete from sys_macro where macro_id =#{macroId}")
	int remove(Long macro_id);
	
	@Delete("<script>"+ 
			"delete from sys_macro where macro_id in " + 
					"<foreach item=\"macroId\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{macroId}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] macroIds);
}
