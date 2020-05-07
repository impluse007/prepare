package com.learnspring.IoC;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private Map<String,Object> ioc=new HashMap<String,Object>();
    public ClassPathXmlApplicationContext(String path){//ioc的原理，这里本质上是xml的解析和反射的运用
        try {
            SAXReader reader = new SAXReader();
            Document document=reader.read(path);
            Element root = document.getRootElement();
            Iterator<Element> iterator =root.elementIterator();
            while(iterator.hasNext()){
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className=element.attributeValue("class");
                Class clas =Class.forName(className);
                Constructor constructor= clas.getConstructor();
                Object object=constructor.newInstance();
                //这里可以给目标对象进行赋值
                Iterator<Element> beanIter =element.elementIterator();
                while(beanIter.hasNext()){
                    Element property = beanIter.next();
                    String name = property.attributeValue("name");
                    String valuestr = property.attributeValue("value");
                    String ref =property.attributeValue("ref");
                    System.out.println(ref);
                    String methodName="set"+name.substring(0,1).toUpperCase()+name.substring(1);
                    Field field =clas.getDeclaredField(name);
                    if(ref == null){
                        Method method = clas.getDeclaredMethod(methodName,field.getType());//这里不传类型会找不到方法=
                        Object value =null;
                        //根据成员变量的数据类型对value进行转换
                        if(field.getType().getName() == "long"){
                            value = Long.parseLong(valuestr);
                        }
                        if(field.getType().getName() == "java.lang.String"){
                            value =valuestr;
                        }
                        if(field.getType().getName() == "int"){
                            value =Integer.parseInt(valuestr);
                        }
                        method.invoke(object,value);

                    }
                    else
                        {//这里就需要做一个DI

                    }
                    ioc.put(id,object);

                }

            }

        }catch(DocumentException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch(NoSuchMethodException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch(InvocationTargetException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }
    }
    public Object getBean(String id){
        return ioc.get(id);
    }
}
