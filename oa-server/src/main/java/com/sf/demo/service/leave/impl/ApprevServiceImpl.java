package com.sf.demo.service.leave.impl;

import com.sf.demo.common.LeaveStatusEnum;
import com.sf.demo.common.ex.BusinessException;
import com.sf.demo.common.page.PageVo;
import com.sf.demo.dao.ApprevDao;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;
import com.sf.demo.service.leave.ApprevService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: ApprevServiceImpl
 * @Author 殇枫
 * @Package com.sf.demo.service.leave.impl
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@Service
@Transactional
public class ApprevServiceImpl implements ApprevService {
    private final ApprevDao apprevDao;

    @Override
    public PageVo<Leave> getApprevPage(LeaveQueryDto dto) {
        return PageVo.getPageVo(dto,()->apprevDao.findApprevList(dto));
    }

    @Override
    public void addLeave(LeaveDto dto) {
        apprevDao.insertLeave(dto);
    }

    @Override
    public void updateLeave(LeaveDto dto) {
        apprevDao.updateLeave(dto);
    }

    @Override
    public void removeLeave(Long... ids) {
        if(ids == null || ids.length == 0){
            throw new BusinessException("请至少选择一条请假申请！");
        }

        //如果有提交后的数据，则不允许删除
        boolean exists = apprevDao.findExistNotSubmited(ids);
        if(exists){
            throw new BusinessException("存在已提交的请假申请！");
        }

        apprevDao.deleteLeave(ids);
    }

    @Override
    public void submitLeave(Long id) {
        apprevDao.updateLeaveStatus(id, LeaveStatusEnum.SUBMITED.getCode());
    }

    @Override
    public void backLeave(Long id) {
        apprevDao.backLeave(id, LeaveStatusEnum.REVERSE.getCode());
    }
}