package com.cx.prototype.mode.service;

import com.baomidou.mybatisplus.service.IService;
import com.cx.prototype.mode.entity.SysPermission;
import com.cx.prototype.mode.entity.UserInfo;

import java.util.List;

public interface SysPermissionService extends IService<SysPermission> {
    List<SysPermission> selectPermByUser(UserInfo userInfo);
}
