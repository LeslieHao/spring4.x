package com.hh.spring4.x.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;

/**
 * DESC:
 * Created by Hh on 2018/1/23
 */

@Controller
@RequestMapping("/test")
public class ControllerTest {

    @RequestMapping("/t1/{str}")
    public void test1(@PathVariable("str") String str) {
        System.out.println("url 参数" + str);
    }

    @RequestMapping("/t2")
    public void test2(String str) {
        System.out.println("url 参数" + str);
    }

    @RequestMapping("/t3")
    public void test3(@CookieValue("cookie") String str) {
        System.out.println("url 参数" + str);
    }

    @RequestMapping("t4")
    public void test4(HttpServletRequest request, HttpServletResponse response, HttpSession session, OutputStream os) {
        session.getAttribute("");
        request.getSession();
        response.addCookie(new Cookie("userName", "Tom"));
    }
}
