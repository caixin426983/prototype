package com.cx.prototype.mode.service;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.UserInfo;
import com.cx.prototype.util.entity.ResultBean;

public interface UserInfoService {

    UserInfo findByUsername(String username);


    ResultBean save(ResultBean result, JSONObject param);

}

