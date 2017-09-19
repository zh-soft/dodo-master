package com.bootdo.finance.dao;

import com.bootdo.finance.domain.FixedAssetsDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 固定资产
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-16 17:14:55
 */
@Mapper
public interface FixedAssetsMapper {

	@Select("select `id`, `assets_type`, `department`, `buy_price`, `buy_date`, `description`, `position`, `pic_url`, `create_time`, `update_time`, `create_user`, `update_user` from fixed_assets where id = #{id}")
	FixedAssetsDO get(Long id);
	
	@Select("<script>" +
	"select * from fixed_assets " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"assetsType != null and assetsType != ''\">"+ "and assets_type = #{assetsType} " + "</if>" + 
		  		  "<if test=\"department != null and department != ''\">"+ "and department = #{department} " + "</if>" + 
		  		  "<if test=\"buyPrice != null and buyPrice != ''\">"+ "and buy_price = #{buyPrice} " + "</if>" + 
		  		  "<if test=\"buyDate != null and buyDate != ''\">"+ "and buy_date = #{buyDate} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"position != null and position != ''\">"+ "and position = #{position} " + "</if>" + 
		  		  "<if test=\"picUrl != null and picUrl != ''\">"+ "and pic_url = #{picUrl} " + "</if>" + 
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
	List<FixedAssetsDO> list(Map<String,Object> map);
	
	@Select("<script>" +
	"select count(*) from fixed_assets " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"assetsType != null and assetsType != ''\">"+ "and assets_type = #{assetsType} " + "</if>" + 
		  		  "<if test=\"department != null and department != ''\">"+ "and department = #{department} " + "</if>" + 
		  		  "<if test=\"buyPrice != null and buyPrice != ''\">"+ "and buy_price = #{buyPrice} " + "</if>" + 
		  		  "<if test=\"buyDate != null and buyDate != ''\">"+ "and buy_date = #{buyDate} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"position != null and position != ''\">"+ "and position = #{position} " + "</if>" + 
		  		  "<if test=\"picUrl != null and picUrl != ''\">"+ "and pic_url = #{picUrl} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"updateTime != null and updateTime != ''\">"+ "and update_time = #{updateTime} " + "</if>" + 
		  		  "<if test=\"createUser != null and createUser != ''\">"+ "and create_user = #{createUser} " + "</if>" + 
		  		  "<if test=\"updateUser != null and updateUser != ''\">"+ "and update_user = #{updateUser} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String,Object> map);
	
	@Insert("insert into fixed_assets (`assets_type`, `department`, `buy_price`, `buy_date`, `description`, `position`, `pic_url`, `create_time`, `update_time`, `create_user`, `update_user`)"
	+ "values (#{assetsType}, #{department}, #{buyPrice}, #{buyDate}, #{description}, #{position}, #{picUrl}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
	int save(FixedAssetsDO fixedAssets);
	
	@Update("<script>"+ 
			"update fixed_assets " + 
					"<set>" + 
		            "<if test=\"id != null\">`id` = #{id}, </if>" + 
                    "<if test=\"assetsType != null\">`assets_type` = #{assetsType}, </if>" + 
                    "<if test=\"department != null\">`department` = #{department}, </if>" + 
                    "<if test=\"buyPrice != null\">`buy_price` = #{buyPrice}, </if>" + 
                    "<if test=\"buyDate != null\">`buy_date` = #{buyDate}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
                    "<if test=\"position != null\">`position` = #{position}, </if>" + 
                    "<if test=\"picUrl != null\">`pic_url` = #{picUrl}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"updateTime != null\">`update_time` = #{updateTime}, </if>" + 
                    "<if test=\"createUser != null\">`create_user` = #{createUser}, </if>" + 
                    "<if test=\"updateUser != null\">`update_user` = #{updateUser}, </if>" + 
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(FixedAssetsDO fixedAssets);
	
	@Delete("delete from fixed_assets where id =#{id}")
	int remove(Long id);
	
	@Delete("<script>"+ 
			"delete from fixed_assets where id in " + 
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Long[] ids);
}
