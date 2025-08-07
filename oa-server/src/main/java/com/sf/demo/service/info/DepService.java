package com.sf.demo.service.info;

import com.sf.demo.common.page.PageVo;
import com.sf.demo.dto.DepDto;
import com.sf.demo.dto.DepQueryDto;
import com.sf.demo.model.Dep;

/**
 * @Title: DepService
 * @Author 殇枫
 * @Package com.sf.demo.service.security.info
 * @Date 2025/8/7
 * @description:
 */
public interface DepService {
    PageVo<Dep> getDepPage(DepQueryDto depQueryDto);

    void addDep(DepDto depDto);

    void updateDep(DepDto depDto);

    void removeDep(Integer... ids);

    void changeStatus(Integer id, Integer status);
}
