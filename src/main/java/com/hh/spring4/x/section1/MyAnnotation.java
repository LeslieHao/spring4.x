package com.hh.spring4.x.section1;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * DESC:
 * Created by Hh on 2018/1/2
 */
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String role();
}
