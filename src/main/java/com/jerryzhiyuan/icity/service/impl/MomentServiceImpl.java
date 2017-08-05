package com.jerryzhiyuan.icity.service.impl;

import com.jerryzhiyuan.icity.mapper.MomentMapper;
import com.jerryzhiyuan.icity.model.Moment;
import com.jerryzhiyuan.icity.service.MomentService;
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
public class MomentServiceImpl implements MomentService {

    @Resource(name = "momentMapper")

    private MomentMapper momentMapper;

    /**
     * 发送实时信息的功能
     * @param moment
     * @return
     */
    public Integer addMoment(Moment moment) {
        //测试传入的数据
        System.out.print("传入的Text_Context为" + moment.getMomentContent());
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

    /**
     * 加载地图所有Marker
     * @return
     */
    public List<Moment> selectAllMoment() {
        return momentMapper.selectAllMoment();
    }

    public Integer count() {
        return momentMapper.count();
    }
}
