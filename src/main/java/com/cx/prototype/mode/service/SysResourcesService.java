package com.cx.prototype.mode.service;

import com.cx.prototype.util.entity.ResultBean;
import org.springframework.stereotype.Repository;

@Repository
public interface SysResourcesService {

    ResultBean getUserMenu(ResultBean result);
}
