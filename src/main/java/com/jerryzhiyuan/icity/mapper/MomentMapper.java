package com.jerryzhiyuan.icity.mapper;

import com.jerryzhiyuan.icity.model.Moment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by huangzhiyuan on 2017/2/16.
 */
@Repository
public interface MomentMapper {
    //创建一个新的朋友圈
    Integer addMoment(Moment moment);

    //更新朋友圈
    Integer updateMomentByMid(Moment moment);

    //根据id查询用户数据
    Moment selectMomentByMid(@Param("mId") Integer userId);

    //通过id删除用户
    Integer deleteMomentByMid(@Param("mId") Integer mId);

    //查询朋友圈数
    Integer count();

    //查询所有用户数据
    List<Moment> selectAllMoment();

}
