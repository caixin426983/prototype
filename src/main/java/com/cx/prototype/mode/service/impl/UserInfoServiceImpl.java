package com.cx.prototype.mode.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.mode.mapper.UserInfoMapper;
import com.cx.prototype.mode.service.UserInfoService;
import com.cx.prototype.util.Utils;
import com.cx.prototype.util.shiro.ShiroUtil;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {


    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        return baseMapper.selectOne(userInfo);
    }

    @Override
    public Integer save(UserInfo userInfo) {
        userInfo.setSalt(Utils.getUUID());//设置盐值
        userInfo.setPassword(ShiroUtil.getPassword(userInfo));
        return this.baseMapper.insert(userInfo);
    }


}
