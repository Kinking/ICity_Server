package com.jerryzhiyuan.icity.service;

import com.jerryzhiyuan.icity.model.Moment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/2/16.
 */
public interface MomentService {
    //创建新用户
    Integer addMoment(Moment moment);

    //通过id删除用户
    Integer deleteMomentByMid(@Param("mId") Integer mId);

    //更新用户数据
    Integer modify(Moment moment);

    //根据id查询用户数据
    Moment selectMomentByMid(@Param("mId") Integer mId);

    //查询所有用户数据
    List<Moment> selectAllMoment();

    //查询用户数
    Integer count();
}
