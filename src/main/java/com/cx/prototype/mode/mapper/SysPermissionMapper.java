package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.SysPermission;
import com.cx.prototype.mode.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<SysPermission> selectPermByUser(UserInfo userInfo);
}
