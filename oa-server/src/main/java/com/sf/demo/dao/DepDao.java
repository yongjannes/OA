package com.sf.demo.dao;

import com.sf.demo.dto.DepDto;
import com.sf.demo.dto.DepQueryDto;
import com.sf.demo.model.Dep;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Title: DepDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface DepDao {

    List<Dep> findDepList(DepQueryDto depQueryDto);

    @Select("select ifnull(max(d_id),0) from t_dep")
    int findMaxId();

    @Insert("insert into t_dep(d_id,d_name,d_remark,d_status) values(#{d_id},#{d_name},#{d_remark},#{d_status})")
    void insertDep(DepDto depDto);

    @Update("update t_dep set d_name = #{d_name} , d_remark = #{d_remark} where d_id = #{d_id}")
    void updateDep(DepDto depDto);

    void deleteDep(@Param("ids") Integer[] ids);

    boolean findExistsUndetermined(@Param("ids") Integer[] ids);

    @Update("update t_dep set d_status = #{status} where d_id = #{id}")
    void updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}
