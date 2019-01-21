package com.cx.prototype.mode.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.mode.mapper.UserInfoMapper;
import com.cx.prototype.mode.service.UserInfoService;
import com.cx.prototype.util.Utils;
import com.cx.prototype.util.entity.ResultBean;
import com.cx.prototype.util.service.CrudService;
import com.cx.prototype.util.shiro.ShiroUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserInfoServiceImpl extends CrudService<UserInfoMapper, UserInfo> implements UserInfoService {


    @Override
    public UserInfo findByUsername(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        return baseMapper.selectOne(userInfo);
    }

    @Override
    public ResultBean save(ResultBean result, JSONObject param) {
        UserInfo userInfo = Utils.parseObject(param, UserInfo.class);

        userInfo.setSalt(Utils.getUUID());//设置盐值
        userInfo.setPassword(ShiroUtil.getPassword(userInfo));//设置加盐后的密码
        int i = super.saveNoSession(userInfo);
        return result.SUCCESS();
    }


}
