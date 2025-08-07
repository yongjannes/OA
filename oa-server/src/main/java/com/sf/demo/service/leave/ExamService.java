package com.sf.demo.service.leave;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;

/**
 * @Title: ExamService
 * @Author 殇枫
 * @Package com.sf.demo.service.leave
 * @Date 2025/8/7
 * @description:
 */
public interface ExamService {
    PageVo<Leave> getExamPage(LeaveQueryDto dto);

    void spLeave(LeaveDto dto);
}
