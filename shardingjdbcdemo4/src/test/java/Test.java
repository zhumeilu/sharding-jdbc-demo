import com.baomidou.mybatisplus.plugins.Page;
import com.zml.mapper.OrderMapper;
import com.zml.model.User;
import com.zml.service.DemoService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
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
        List<User> users = orderRepository.testBetween();
        System.out.println(users);

    }
}
