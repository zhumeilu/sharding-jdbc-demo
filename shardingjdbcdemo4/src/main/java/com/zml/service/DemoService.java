package com.zml.service;

import com.zml.mapper.OrderMapper;

import com.zml.model.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DemoService {
    
    @Resource
    private OrderMapper orderRepository;
    

    public void demo() {
        orderRepository.createIfNotExistsTable();
        orderRepository.truncateTable();
        List<Long> orderIds = new ArrayList<Long>(10);
        System.out.println("1.Insert--------------");
        for (int i = 0; i < 10; i++) {
            Order order = new Order();
            order.setUserId(51);
            order.setOrderId(i+1);
            order.setStatus("INSERT_TEST");
            orderRepository.insert(order);
            long orderId = order.getOrderId();
            orderIds.add(orderId);
            

        }

//        System.out.println("2.Delete--------------");
//        for (Long each : orderIds) {
//            orderRepository.delete(each);
//            orderItemRepository.delete(each);
//        }
//        System.out.println(orderItemRepository.selectAll());
//        orderItemRepository.dropTable();
//        orderRepository.dropTable();
    }
}
