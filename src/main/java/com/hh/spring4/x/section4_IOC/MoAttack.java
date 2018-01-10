package com.hh.spring4.x.section4_IOC;

/**
 * DESC: 三种注入方式
 * Created by Hh on 2018/1/9
 */
public class MoAttack implements ActorArrangeable{

    //  剧本和演员直接耦合
//    public void cityGateAsk(){
//        LiuDeHua liuDeHua = new LiuDeHua();
//        liuDeHua.responseAsk("墨者革离！");
//    }


    public void cityGateAsk(){
        geLi.responseAsk("墨者革离！");
    }

    private GeLi geLi;

    // 构造函数注入
    public MoAttack(GeLi geLi) {
        this.geLi = geLi;
    }

    // 属性注入
    public void setGeLi(GeLi geLi) {
        this.geLi = geLi;
    }

    // 接口注入
    @Override
    public void injectGeli(GeLi geLi) {
        this.geLi = geLi;
    }

    public MoAttack() {
    }


}
