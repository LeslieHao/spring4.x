package com.hh.spring4.x.mvc.controller;

import com.hh.spring4.x.mvc.model.User;
import com.hh.spring4.x.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * DESC: Spring mvc 处理请求的整个过程
 * 1.DispatcherServlet 接收到客户端的 /user 请求
 * 2.DispatcherServlet 使用DefaultAnnotationHandlerMapping 查找负责处理该请求的处理器你
 * 3.DispatcherServlet 将请求分发给/user 处理器
 * 4.处理器完成业务处理，返回ModelAndView 对象
 * 5.DispatcherServlet 调用InteralResourceResolver 组件对MV 中的视图名进行全解析，得到/WEB-INF/view/user/createSuccess.jsp
 * 6.渲染数据
 * 7.返回响应页面给客户端
 * Created by Hh on 2018/1/23
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createUser(ModelAndView mv, User user) {
        userService.createUser(user);
        mv.addObject("user", user);
        return "createSuccess";
    }


}
