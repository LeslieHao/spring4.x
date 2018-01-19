package com.hh.spring4.x.section8_AspectJ;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
public class ForumService {

    @NeedTest( str = "Hello")
    public void deleteForum(int id) {
        System.out.println("deleteForum..." + id);
    }
    @NeedTest(value = false,str = "How r u")
    public void deleteTopic(int id) {
        System.out.println("deleteTopic..." + id);
    }
}
