package com.sf.demo.api.leave;

import com.sf.demo.common.LeaveStatusEnum;
import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.common.page.PageVo;
import com.sf.demo.common.vo.R;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;
import com.sf.demo.service.leave.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Title: ExamController
 * @Author 殇枫
 * @Package com.sf.demo.api.leave
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/leave/exam")
public class ExamController {

    private final ExamService examService;

    private final CurrentUser currentUser;

    @GetMapping("")
    public R<PageVo<Leave>> examList(LeaveQueryDto dto){
        dto.setLeader_id(currentUser.getUserId());
        PageVo<Leave> page = examService.getExamPage(dto);
        return R.OK(page);
    }

    @PutMapping("/pass")
    public R<?> execPass(@RequestBody LeaveDto dto){
        dto.setL_status(LeaveStatusEnum.PASS.getCode());
        dto.setL_spr(currentUser.getUserName());
        dto.setL_sp_date(new Date());
        examService.spLeave(dto);
        return R.OK();
    }

    @PutMapping("/reject")
    public R<?> execReject(@RequestBody LeaveDto dto){
        dto.setL_status(LeaveStatusEnum.REJECTED.getCode());
        dto.setL_spr(currentUser.getUserName());
        dto.setL_sp_date(new Date());
        examService.spLeave(dto);
        return R.OK();
    }
}
