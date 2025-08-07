package com.sf.demo.dto;

import com.sf.demo.common.page.PageParamDto;
import lombok.Data;

/**
 * @Title: DepQueryDto
 * @Author  殇枫
 * @Package com.sf.demo.dto
 * @Date  2025/8/7
 * @description: 
*/
@Data
public class DepQueryDto extends PageParamDto {

    private String d_id;
    private String d_name;

    private String d_remark;

    private Integer d_status;
}
