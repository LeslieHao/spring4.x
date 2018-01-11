package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * DESC:
 * Created by Hh on 2018/1/11
 */
public class Foo {

    private String iDCard;

    public void setIDCard(String iCard) {
        this.iDCard = iCard;
    }

    public String getiCard() {
        return iDCard;
    }

    public static void main(String[] args) {
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) bf);
        reader.loadBeanDefinitions(res);
        Foo foo = (Foo) bf.getBean("foo");
        System.out.println(foo.getiCard());
    }
}
