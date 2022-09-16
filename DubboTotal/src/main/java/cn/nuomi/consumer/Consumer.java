package cn.nuomi.consumer;

import cn.nuomi.dubboCommon.Invocation;
import cn.nuomi.dubboCommon.rpcNetwork.http.HttpClient;
import cn.nuomi.dubboService.api.UserService;

public class Consumer {

    public static void main(String[] args) {

        //创建发送对象
        Invocation invocation = new Invocation("call",UserService.class.getName(),"1.0",new Class[]{String.class},new Object[]{"huangyu"});

        //使用HttpClient发送请求
        String receiveMsg = new HttpClient().send("localhost", 8080, invocation);
        System.out.println(receiveMsg);

    }
}
