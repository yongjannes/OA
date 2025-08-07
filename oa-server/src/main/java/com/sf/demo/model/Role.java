package com.sf.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @Title: Role
 * @Author 殇枫
 * @Package com.sf.demo.model
 * @Date 2025/8/7
 * @description:
 */
@Data
public class Role {

    private Integer ro_id;
    private String ro_name;

    private List<String> funNameList;
}
