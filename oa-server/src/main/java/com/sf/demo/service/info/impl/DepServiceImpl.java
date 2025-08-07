package com.sf.demo.service.info.impl;

import com.sf.demo.common.InfoStatusEnum;
import com.sf.demo.common.ex.BusinessException;
import com.sf.demo.common.page.PageVo;
import com.sf.demo.dao.DepDao;
import com.sf.demo.dto.DepDto;
import com.sf.demo.dto.DepQueryDto;
import com.sf.demo.model.Dep;
import com.sf.demo.service.info.DepService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: DepServiceImpl
 * @Author 殇枫
 * @Package com.sf.demo.service.info.impl
 * @Date 2025/8/7
 * @description:
 */
@RequiredArgsConstructor
@Service
@Transactional
public class DepServiceImpl implements DepService {

    private final DepDao depDao;

    @Override
    public PageVo<Dep> getDepPage(DepQueryDto depQueryDto) {

//        QueryAction<Dep> action = new QueryAction<Dep>() {
//            @Override
//            public List<Dep> executeQuery() throws Exception {
//                return depDao.findDepList(depQueryDto);
//            }
//        };

        //QueryAction<Dep> action = ()-> depDao.findDepList(depQueryDto);

        return PageVo.getPageVo(depQueryDto,()-> depDao.findDepList(depQueryDto));
    }


    private int id;//最大编号

    @PostConstruct //（初始化方法）表示该方法在创建对象后执行，而仅执行一次
    public void init(){
        id = depDao.findMaxId();
    }

    private synchronized int newId(){
        return ++id;
    }

    @Override
    public void addDep(DepDto depDto) {
        depDto.setD_id(newId());
        depDto.setD_status(InfoStatusEnum.undetermined.getCode());
        depDao.insertDep(depDto);
    }

    @Override
    public void updateDep(DepDto depDto) {
        depDao.updateDep(depDto);
    }

    @Override
    public void removeDep(Integer... ids) {
        if(ids == null || ids.length == 0){
            throw new BusinessException("请选择至少一条数据！");
        }

        //如果被删除的数据中存在状态不是“未确定”的，应阻止删除
        boolean exists = depDao.findExistsUndetermined(ids);
        if(exists){
            throw new BusinessException("存在已确定数据！不允许删除。");
        }
        depDao.deleteDep(ids);
    }

    @Override
    public void changeStatus(Integer id, Integer status) {
        depDao.updateStatus(id,status);
    }
}
