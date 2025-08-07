package com.sf.demo.dao;

import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Title: ExamDao
 * @Author 殇枫
 * @Package com.sf.demo.dao
 * @Date 2025/8/7
 * @description:
 */
@Mapper
public interface ExamDao {
    List<Leave> findExamList(LeaveQueryDto dto);

    @Update("update t_leave set l_sp_advice = #{l_sp_advice}, l_spr = #{l_spr},l_sp_date = #{l_sp_date} ," +
            "l_status = #{l_status}  where l_id = #{l_id}")
    void spLeave(LeaveDto dto);
}
