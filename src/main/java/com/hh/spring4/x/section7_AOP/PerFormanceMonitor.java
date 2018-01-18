package com.hh.spring4.x.section7_AOP;

/**
 * DESC: 调用性能监视
 * Created by Hh on 2018/1/17
 */
public class PerFormanceMonitor {
    // 通过一个ThreadLocal 保存于调用线程相关的性能见识信息
    private static ThreadLocal<MethodPerformance> performanceRecord
            = new ThreadLocal<>();

    public static void begin(String method) {
        System.out.println("begin monitor.....");
        MethodPerformance mp = new MethodPerformance(method);
        performanceRecord.set(mp);
    }

    public static void end(){
        System.out.println("end monitor......");
        MethodPerformance mp = performanceRecord.get();
        mp.printPerformance();
    }

}
