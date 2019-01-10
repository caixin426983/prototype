package com.cx.prototype.mode.service.impl;

import com.cx.prototype.mode.entity.SysPermission;
import com.cx.prototype.mode.mapper.UserInfoMapper;
import com.cx.prototype.mode.service.SysResourcesService;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.shiro.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysResourcesServiceImpl implements SysResourcesService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Override
    public ResultBean getUserMenu(ResultBean result) {
        Long userId = ShiroUtil.getUserId();
        List<SysPermission> userMenu = userInfoMapper.getUserMenu(userId);
        return result.SUCCESS().addData(userMenu);
    }
}
