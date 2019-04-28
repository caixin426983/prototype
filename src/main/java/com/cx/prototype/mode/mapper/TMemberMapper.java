package com.cx.prototype.mode.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cx.prototype.mode.entity.TMember;
import com.cx.prototype.mode.pojo.TMemberPojo;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author cx123
 * @since 2019-04-21
 */
@Repository
public interface TMemberMapper extends BaseMapper<TMember> {


    List<TMemberPojo> exportMember();


}
