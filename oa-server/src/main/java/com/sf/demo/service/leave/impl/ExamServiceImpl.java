package com.sf.demo.service.leave.impl;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dao.ExamDao;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;
import com.sf.demo.service.leave.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: ExamServiceImpl
 * @Author 殇枫
 * @Package com.sf.demo.service.leave.impl
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ExamServiceImpl implements ExamService {
    private final ExamDao examDao;

    @Override
    public PageVo<Leave> getExamPage(LeaveQueryDto dto) {
        return PageVo.getPageVo(dto,()->examDao.findExamList(dto));
    }

    @Override
    public void spLeave(LeaveDto dto) {
        examDao.spLeave(dto);
    }
}
