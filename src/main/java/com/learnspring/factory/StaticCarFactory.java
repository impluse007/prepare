package com.learnspring.factory;

import com.learnspring.entity.Car;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
    private static Map<Long, Car> carMap;
    static{//类一旦被加载就会被实例化
        carMap = new HashMap<Long, Car>();
        carMap.put(1L,new Car(1L,"bm"));
        carMap.put(2L,new Car(2L,"bc"));
    }
    public static Car getCar(long id){
        return carMap.get(id);
    }

}
