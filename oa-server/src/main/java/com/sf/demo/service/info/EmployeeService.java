package com.sf.demo.service.info;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.EmpDto;
import com.sf.demo.dto.EmpQueryDto;
import com.sf.demo.model.Dep;
import com.sf.demo.model.Employee;

import java.util.List;
import java.util.Map;

/**
 * @Title: EmployeeService
 * @Author 殇枫
 * @Package com.sf.demo.service.info
 * @Date 2025/8/7
 * @description:
 */
public interface EmployeeService {
    PageVo<Employee> getEmployeePage(EmpQueryDto empQueryDto);

    List<Dep> getAllEnableDepList();

    void addEmp(EmpDto empDto);


    void updateEmp(EmpDto empDto);

    void removeEmp(String... ids);

    void changeStatus(String id, Integer status);

    void createUser(Map<String, String> userIdMap);

    void cancelUser(Map<String, String> userIdMap);

    void setLeader(Map<String, String> empIdMap);
}
