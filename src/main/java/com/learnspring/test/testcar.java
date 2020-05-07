package com.learnspring.test;

import com.learnspring.entity.Car;
import com.learnspring.factory.StaticCarFactory;

public class testcar {
    public static void main(String[] args){
        Car car= StaticCarFactory.getCar(1L);

    }
}
