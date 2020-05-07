package com.learnspring.test;

import com.learnspring.entity.Student;
import com.learnspring.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("spring_di.xml");
        User user=(User)applicationContext.getBean("user");
        Student student=(Student)applicationContext.getBean("student");

    }
}
