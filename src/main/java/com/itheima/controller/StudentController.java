package com.itheima.controller;

import com.itheima.entity.Student;
import com.itheima.entity.StudentDao;
import com.itheima.jdbc.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void main(String[] args) {
        System.out.println("欢迎来到学生管理系统");
        System.out.println("请输入用户名：");
        Scanner sca = new Scanner(System.in);
        String name = sca.nextLine();
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-Student.xml");
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
        List<Student> student = studentDao.findAllStudent();
        for (Student stu : student){
          if (name.equals(stu.getUsername())){
              System.out.println("请输入" + stu.getUsername() + "的密码");
          }
          String mima = sca.nextLine();
           if (mima.equals(stu.getPassword())){
               System.out.println("用户登陆成功！");
               System.out.println(stu.getUsername()+"是"+stu.getCourse()+"班的");
               return;
           } else {
               System.out.println("账号密码错误");
               return;
           }
        }
    }
}
