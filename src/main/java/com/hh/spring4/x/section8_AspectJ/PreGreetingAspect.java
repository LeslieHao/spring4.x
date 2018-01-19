package com.hh.spring4.x.section8_AspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * DESC:
 * Created by Hh on 2018/1/19
 */
@Aspect // 将PreGreetingAspect 标注为一个切面
public class PreGreetingAspect {

//    @Before("execution(* greetTo(..))") // 定义切点的增强类型
//    public void beforeGreeting(JoinPoint joinPoint){
//        Object args[] = joinPoint.getArgs();
//        System.out.println("=====before======");
//        System.out.println("How r u ~");
//        System.out.println("参数1："+args[0]);
//        System.out.println("=====before======");
//    }
//
    @Around(value = "@annotation(Greeting)")
    public void aroundGreeting( ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object args[] = proceedingJoinPoint.getArgs();
        System.out.println("=====around======");
        String returnVal = (String) proceedingJoinPoint.proceed(args);
        System.out.println("returnVal："+returnVal);
        System.out.println("=====around======");
    }

    @AfterReturning(value = "@annotation(Greeting)", returning = "val")
    public void afterGreeting(JoinPoint joinPoint, String val) throws Throwable {
        Object args[] = joinPoint.getArgs();
        System.out.println("=====after======");
        System.out.println("方法执行后 returnVal：" + val+",参数："+args[0]);
        System.out.println("=====after======");
    }
}
