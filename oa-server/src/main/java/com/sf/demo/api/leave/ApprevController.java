package com.sf.demo.api.leave;

import com.sf.demo.common.LeaveStatusEnum;
import com.sf.demo.common.currentuser.CurrentUser;
import com.sf.demo.common.page.PageVo;
import com.sf.demo.common.vo.R;
import com.sf.demo.dto.LeaveDto;
import com.sf.demo.dto.LeaveQueryDto;
import com.sf.demo.model.Leave;
import com.sf.demo.service.leave.ApprevService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Title: ApprevController
 * @Author 殇枫
 * @Package com.sf.demo.api.leave
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/leave/apprev")
public class ApprevController {

    private final ApprevService apprevService;

    private final CurrentUser currentUser;

    @GetMapping("")
    public R<PageVo<Leave>> apprevList(LeaveQueryDto dto){
        dto.setE_id(currentUser.getUserId());
        PageVo<Leave> page = apprevService.getApprevPage(dto);
        return R.OK(page);
    }

    @PostMapping("")
    public R<?> execAdd(@RequestBody LeaveDto dto){
        dto.setE_id(currentUser.getUserId());
        dto.setL_submit_date(new Date());
        dto.setL_status(LeaveStatusEnum.NOT_SUBMIT.getCode());
        apprevService.addLeave(dto);
        return R.OK();

    }

    @PutMapping("")
    public R<?> execUpd(@RequestBody LeaveDto dto){
        dto.setL_submit_date(new Date());
        apprevService.updateLeave(dto);
        return R.OK();

    }

    @DeleteMapping("/{id}")
    public R<?> execDel(@PathVariable Long id){
        apprevService.removeLeave(id);
        return R.OK();
    }

    @DeleteMapping("")
    public R<?> execDel(@RequestBody Long... ids){
        apprevService.removeLeave(ids);
        return R.OK();
    }

    @PutMapping("/submit/{id}")
    public R<?> execSubmit(@PathVariable Long id){
        apprevService.submitLeave(id);
        return R.OK();
    }

    @PutMapping("/back/{id}")
    public R<?> execBack(@PathVariable Long id){
        apprevService.backLeave(id);
        return R.OK();
    }


}
