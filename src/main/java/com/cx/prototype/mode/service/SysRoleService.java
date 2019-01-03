package com.cx.prototype.mode.service;

import com.baomidou.mybatisplus.service.IService;
import com.cx.prototype.mode.entity.SysRole;
import com.cx.prototype.mode.entity.UserInfo;

import java.util.List;

public interface SysRoleService extends IService<SysRole> {

    List<SysRole> selectRoleByUser(UserInfo userInfo);
}
