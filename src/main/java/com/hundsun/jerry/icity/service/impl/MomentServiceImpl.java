package com.hundsun.jerry.icity.service.impl;

import com.hundsun.jerry.icity.mapper.MomentMapper;
import com.hundsun.jerry.icity.model.Moment;
import com.hundsun.jerry.icity.service.MomentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by huangzhiyuan on 2017/2/16.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class MomentServiceImpl implements MomentService{

    @Resource(name = "momentMapper")

    private MomentMapper momentMapper;

    public Integer addMoment(Moment moment) {
        //测试传入的数据
        System.out.print("传入的Text_Context为" + moment.getTextContent());
        return momentMapper.addMoment(moment);
    }

    public Integer deleteMomentByMid(@Param("mId") Integer mId) {
        return momentMapper.deleteMomentByMid(mId);
    }

    public Integer modify(Moment moment) {
        return momentMapper.updateMomentByMid(moment);
    }

    public Moment selectMomentByMid(@Param("mId") Integer mId) {
        return momentMapper.selectMomentByMid(mId);
    }

    public List<Moment> selectAllMoment() {
        return momentMapper.selectAllMoment();
    }

    public Integer count() {
        return momentMapper.count();
    }
}
