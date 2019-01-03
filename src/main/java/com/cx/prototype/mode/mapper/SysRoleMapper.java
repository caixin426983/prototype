package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.SysRole;
import com.cx.prototype.mode.entity.UserInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectRoleByUser(UserInfo userInfo);
}

