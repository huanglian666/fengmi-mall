import com.fengmi.goods.mapper.MallGoodsMapper;
import com.fengmi.goods.service.impl.MallGoodsServiceImpl;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: MyTest
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/28 20:49
 **/
@SpringBootTest
//@MapperScan("com.fengmi.goods.mapper")
@EnableDiscoveryClient
@MapperScan("com.fengmi.goods.mapper")
public class MyTest {
    @Autowired
    private MallGoodsServiceImpl mallGoodsService;
    @Test
    public void test(){
        mallGoodsService.findAllEsGoods().forEach(System.out::println);
    }
}
