package com.zml.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zml.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/30
 * Time: 9:56
 */
@Mapper
@Component
public interface AdminMapper extends BaseMapper<Admin> {
    Admin selectByUserId(Long user_id);
}
