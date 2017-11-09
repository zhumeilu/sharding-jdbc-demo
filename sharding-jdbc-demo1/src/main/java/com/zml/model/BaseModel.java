package com.zml.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/8/25
 * Time: 14:37
 */
@Getter
@Setter
public class BaseModel {
    @TableId(type = IdType.AUTO)
    private Long id;
}
