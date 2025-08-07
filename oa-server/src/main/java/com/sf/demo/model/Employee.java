package com.sf.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sf.demo.common.InfoStatusEnum;
import lombok.Data;

import java.util.Date;

/**
 * @Title: Employee
 * @Author 殇枫
 * @Package com.sf.demo.model
 * @Date 2025/8/7
 * @description:
 */
@Data
public class Employee {

    private String e_id;
    private String e_name;
    private Integer e_sex;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date e_birth;

    private Integer e_status;

    private Integer d_id;

    private String d_name;

    private boolean account;//工号是否是登录账号

    private boolean leader;//是否为部门领导

    public String getE_status_name(){
        if(e_status == null) {
            return null;
        }
        return InfoStatusEnum.getTextByCode(e_status);
    }

}
