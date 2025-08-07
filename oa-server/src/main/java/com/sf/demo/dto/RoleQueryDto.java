package com.sf.demo.dto;

import com.sf.demo.common.page.PageParamDto;
import lombok.Data;

/**
 * @Title: RoleQueryDto
 * @Author 殇枫
 * @Package com.sf.demo.dto
 * @Date 2025/8/7
 * @description:
 */
@Data
public class RoleQueryDto extends PageParamDto {

    private String ro_id;
    private String ro_name;
}
