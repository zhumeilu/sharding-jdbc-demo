package com.zml.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.zml.model.Order;
import com.zml.model.User;

import java.util.List;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/12
 * Time: 17:57
 */
public interface OrderMapper {
    void createIfNotExistsTable();

    void truncateTable();

    Long insert(Order model);

    void delete(Long orderId);

    void dropTable();

    List<User> testLeftJoin();
    List<User> testBetween();
    List<User> testLeftJoinPage(Page pageInfo);
}
