package com.zml.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/12
 * Time: 17:56
 */
@Getter
@Setter
@ToString
public class Order {

    private Integer orderId;

    private Integer userId;

    private String status;
    private Date createDate;
}
