package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.SysPermission;
import com.cx.prototype.mode.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    /**
     * 获取用户菜单
     *
     * @return
     */
    List<SysPermission> getUserMenu(@Param("userId") Long userId);


}
