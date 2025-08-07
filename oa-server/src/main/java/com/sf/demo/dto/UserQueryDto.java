package com.sf.demo.dto;

import com.sf.demo.common.page.PageParamDto;
import lombok.Data;

/**
 * @Title: UserQueryDto
 * @Author 殇枫
 * @Package com.sf.demo.dto
 * @Date 2025/8/7
 * @description:
 */
@Data
public class UserQueryDto extends PageParamDto {

    private String u_id;
    private String u_name;
}
