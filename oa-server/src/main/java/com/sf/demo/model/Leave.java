package com.sf.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sf.demo.common.LeaveStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Title: Leave
 * @Author 殇枫
 * @Package com.sf.demo.model
 * @Date 2025/8/7
 * @description:
 */
@Data
public class Leave {

    private Long l_id;
    private String e_id;
    private String e_name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date l_submit_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date l_start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date l_end;

    private String l_cause;

    private Integer l_status;

    public String getL_status_name(){
        if(l_status == null) {
            return null;
        }
        return LeaveStatusEnum.getText(l_status);
    }

    private String d_name;//部门名称

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date l_sp_date;//审批日期

    private String l_sp_advice;//审批意见

    private String l_spr;//审批人

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date l_back_date;//销假日期
}
