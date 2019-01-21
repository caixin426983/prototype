package com.cx.prototype.mode.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.prototype.mode.entity.SysPermission;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.mode.mapper.SysPermissionMapper;
import com.cx.prototype.mode.service.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
    @Override
    public List<SysPermission> selectPermByUser(UserInfo userInfo) {
        return baseMapper.selectPermByUser(userInfo);
    }
}
