package com.sf.demo.service.leave;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;

/**
 * @Title: ApprevService
 * @Author 殇枫
 * @Package com.sf.demo.service.leave
 * @Date 2025/8/7
 * @description:
 */
public interface ApprevService {
    PageVo<Leave> getApprevPage(LeaveQueryDto dto);

    void addLeave(LeaveDto dto);

    void updateLeave(LeaveDto dto);

    void removeLeave(Long... ids);

    void submitLeave(Long id);

    void backLeave(Long id);
}
