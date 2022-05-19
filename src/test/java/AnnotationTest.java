import com.itheima.jdbc.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        accountDao.transfer("itheima","tom",111.00);
        System.out.println("转账成功");
    }
}
