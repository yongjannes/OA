package com.sf.demo.dto;

import com.sf.demo.common.page.PageParamDto;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Title: EmpQueryDto
 * @Author 殇枫
 * @Package com.sf.demo.dto
 * @Date 2025/8/7
 * @description:
 */
@Data
public class EmpQueryDto extends PageParamDto {

    private String e_id;
    private String e_name;
    private Integer e_sex;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birth_start;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birth_end;
    private Integer e_status;
    private Integer d_id;
}
