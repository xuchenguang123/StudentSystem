import com.itheima.jdbc.Account;
import com.itheima.jdbc.AccountDao;
import com.itheima.jdbc.AccountDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        jdbcTemplate.execute("create table account("+
                "id int primary key auto_increment,"
                + "username varchar(50),"
                + "balance double)");
        System.out.println("账户表account创建成功");
    }
    @Test
    public void addAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao  = (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setUsername("tom");
        account.setBalance(10000000000.00);
        int num = accountDao.addAccount(account);
        if(num > 0){
            System.out.println("成功插入了"+num+"条数据");
        } else {
            System.out.println("插入操作执行失败");
        }
    }

    @Test
    public void updateAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = new Account();
        account.setId(1);
        account.setUsername("tom");
        account.setBalance(99999.99);
        int num = accountDao.updateAccount(account);
        if (num > 0){
            System.out.println("成功更改了" + num + "条数据");
        } else{
            System.out.println("更改数据失败");
        }
    }
    @Test
    public void deleteAccountTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        int num = accountDao.dedleteAccount(1);
        if (num > 0){
            System.out.println("成功删除了"+num+"条数据");
        } else {
            System.out.println("删除数据失败");
        }
    }

    @Test
    public void findAccountByIdTest(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void findAllAccount(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountDao accountDao = (AccountDao) applicationContext.getBean("accountDao");
        List<Account> account = accountDao.findAllAccount();
        for (Account act : account){
            System.out.println(act);
        }
    }
}
