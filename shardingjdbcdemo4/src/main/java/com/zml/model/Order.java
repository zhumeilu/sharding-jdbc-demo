package com.zml.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/12
 * Time: 17:56
 */
@Getter
@Setter
public class Order {

    private long orderId;

    private int userId;

    private String status;
}
