package com.cx.prototype.mode.service;

import com.alibaba.fastjson.JSONObject;
import com.cx.prototype.mode.entity.SysDictionary;
import com.cx.prototype.util.entity.PageParam;
import com.cx.prototype.util.entity.ResultBean;

public interface SysDictionaryService {

    ResultBean list(ResultBean result, PageParam param);

    SysDictionary detail(Long id);

    ResultBean insert(ResultBean result, JSONObject param);

    ResultBean update(ResultBean result, JSONObject param);

    int delete(Long id);
}
