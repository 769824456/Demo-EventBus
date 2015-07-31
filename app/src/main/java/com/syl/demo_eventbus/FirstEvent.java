package com.syl.demo_eventbus;

/*
 * PROJECT_NAME :Demo-EventBus
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun 
 * CREATE AT : 7/31/2015 2:04 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :
 */
public class FirstEvent {
    private String msg;

    public FirstEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
