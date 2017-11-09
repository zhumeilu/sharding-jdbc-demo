package com.zml.model;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/29
 * Time: 20:48
 */
@Getter
@Setter
@TableName("admin")
@Alias("Admin")
public class Admin extends BaseModel{
    private Long user_id;
    private String username;
}
