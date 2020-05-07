package com.learnspring.test;

import com.learnspring.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        Student student=new Student();
//        student.setAge(1);
//        student.setName("may");
//        student.setId(12312321);
//        System.out.println(student);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }
}
