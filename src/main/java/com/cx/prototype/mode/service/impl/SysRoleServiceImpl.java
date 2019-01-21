package com.cx.prototype.mode.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.prototype.mode.entity.SysRole;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.mode.mapper.SysRoleMapper;
import com.cx.prototype.mode.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public List<SysRole> selectRoleByUser(UserInfo userInfo) {
        return baseMapper.selectRoleByUser(userInfo);
    }
}
