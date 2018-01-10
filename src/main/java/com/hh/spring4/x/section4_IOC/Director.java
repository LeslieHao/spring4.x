package com.hh.spring4.x.section4_IOC;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * DESC: 导演类
 * Created by Hh on 2018/1/10
 */
public class Director {

    public void direct(){
        // 指定角色饰演者
        GeLi geLi = new LiuDeHua();
        // 注入具体饰演者到剧本
//        MoAttack moAttack = new MoAttack(geLi);

        MoAttack moAttack = new MoAttack();
        moAttack.setGeLi(geLi);

        moAttack.injectGeli(geLi);
        moAttack.cityGateAsk();
    }
}
