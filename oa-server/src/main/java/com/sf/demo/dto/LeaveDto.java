package com.sf.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Title: LeaveDto
 * @Author 殇枫
 * @Package com.sf.demo.dto
 * @Date 2025/8/7
 * @description:
 */
@Data
public class LeaveDto {

    private Long l_id;
    private String e_id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date l_submit_date;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date l_start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Shanghai")
    private Date l_end;

    private String l_cause;

    private Integer l_status;


    private String l_sp_advice;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Asia/Shanghai")
    private Date l_sp_date;

    private String l_spr;


}
