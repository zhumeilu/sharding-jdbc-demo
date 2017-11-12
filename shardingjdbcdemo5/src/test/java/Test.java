import com.baomidou.mybatisplus.plugins.Page;
import com.zml.mapper.OrderMapper;
import com.zml.model.Order;
import com.zml.model.User;
import com.zml.service.DemoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/12
 * Time: 17:57
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:mybatisShardingTableOnlyContext.xml"}) //加载配置文件
public class Test {

    @Autowired
    private DemoService demoService;

    @Resource
    private OrderMapper orderRepository;

    @org.junit.Test
    public void test(){
        demoService.demo();
    }


    @org.junit.Test
    public void testLeftJoin(){
        List<User> users = orderRepository.testLeftJoin();
        System.out.println(users);

    }

    @org.junit.Test
    public void testLeftJoinPage(){
        Page<User> pageInfo  = new Page<User>(1,1);
        List<User> users = orderRepository.testLeftJoinPage(pageInfo);
        System.out.println(users);

    }
    @org.junit.Test
    public void testBetween(){
        long currentTimeMillis = System.currentTimeMillis();
        List<User> users = orderRepository.testBetween();
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("耗时："+(currentTimeMillis1-currentTimeMillis));
        System.out.println(users);

    }
    @org.junit.Test
    public void testBetween2() throws ParseException {
//        orderRepository.createIfNotExistsTable();
//        orderRepository.truncateTable();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long currentTimeMillis = System.currentTimeMillis();
        List<Order> orders = orderRepository.testBetween2(sdf.parse("2017-11-1"),sdf.parse("2017-11-30"));
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("耗时："+(currentTimeMillis1-currentTimeMillis));
        System.out.println(orders);

    }

    @org.junit.Test
    public void testInsert2(){
        Order order = new Order();
        order.setOrderId(2);
        order.setCreateDate(new Date());
        order.setUserId(2);
        order.setStatus("insert2_test");
        orderRepository.insert2(order);
    }
}
