package com.cx.prototype.mode.service;

import com.cx.prototype.mode.entity.UserInfo;

public interface UserInfoService {

    UserInfo findByUsername(String username);
}
