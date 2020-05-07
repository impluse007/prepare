package com.learnspring.IoC;

import com.learnspring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("./src/main/resources/spring.xml");
        Student student = (Student) applicationContext.getBean("student3");
        System.out.println(student);

    }
}
