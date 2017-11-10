import com.zml.mapper.AdminMapper;
import com.zml.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.Date;

/**
 * Description:
 * User: zhumeilu
 * Date: 2017/11/9
 * Time: 16:09
 */
@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:spring/springmvc-servlet.xml"}) //加载配置文件
public class MapperTest {


    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void test(){
        Admin admin = adminMapper.selectByUserId(1L);
        System.out.println(admin.getUsername());

        Admin admin2 = adminMapper.selectByUserId(2L);
        System.out.println(admin2.getUsername());
    }
    @Test
    public void test3(){
        Admin admin = new Admin ();
        admin.setCreateDate(new Date());
        admin.setUsername("zml201711");
        admin.setUser_id(11L);
        adminMapper.insert(admin);
    }


}
