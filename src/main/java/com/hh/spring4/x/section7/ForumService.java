package com.hh.spring4.x.section7;

/**
 * DESC:
 * Created by Hh on 2018/1/17
 */
public class ForumService {



    public void removeTopic(int topicId) {

        // 开始对该方法进行性能监视
        PerFormanceMonitor.begin("com.hh.spring4.x.section7.ForumService.removeTopic");
        System.out.println("模拟删除Topic 记录" + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 结束监视
        PerFormanceMonitor.end();
    }

    public void removeForum(int forumId) {
        // 开始对该方法进行性能监视
        PerFormanceMonitor.begin("com.hh.spring4.x.section7.removeForum.removeForum");
        System.out.println("模拟删除Forum 记录" + forumId);
        try {
            Thread.currentThread().sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 结束监视
        PerFormanceMonitor.end();
    }

    public static void main(String[] args) {
        ForumService forumService = new ForumService();
        forumService.removeForum(001);
    }
}
