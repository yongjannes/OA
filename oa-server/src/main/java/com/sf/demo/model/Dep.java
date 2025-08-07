package com.sf.demo.model;

import lombok.Data;

/**
 * @Title: Dep
 * @Author 殇枫
 * @Package com.sf.demo.model
 * @Date 2025/8/7
 * @description:
 */
@Data
public class Dep {

    private Integer d_id;
    private String d_name;

    private String d_remark;

    private Integer d_status;
}