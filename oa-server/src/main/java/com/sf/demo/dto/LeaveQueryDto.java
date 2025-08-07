package com.sf.demo.dto;

import com.sf.demo.common.page.PageParamDto;
import lombok.Data;

/**
 * @Title: LeaveQueryDto
 * @Author 殇枫
 * @Package com.sf.demo.dto
 * @Date 2025/8/7
 * @description:
 */
@Data
public class LeaveQueryDto extends PageParamDto {
    private String l_id;
    private String e_id;//请假申请人编号
    private String l_cause;

    private Integer l_status;

    private String leader_id;//领导编号

    private String e_name;//申请人姓名


}