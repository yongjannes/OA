package com.sf.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @Title: User
 * @Author 殇枫
 * @Package com.sf.demo.model
 * @Date 2025/8/7
 * @description:
 */
@Data
public class User {

    private String u_id;
    private String u_name;

    private String u_type;

    private List<String> roleNameList;
}
