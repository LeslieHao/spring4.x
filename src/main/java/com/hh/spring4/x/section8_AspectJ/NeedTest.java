package com.hh.spring4.x.section8_AspectJ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
@Retention(RetentionPolicy.RUNTIME) // 声明注解保留期限--> 运行期间被JVM 读取
@Target(ElementType.METHOD) // 声明可以使用该注解的目标类型
public @interface NeedTest {

    boolean value() default true;

    String str() default "no no no~";
}
