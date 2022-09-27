package cn.nuomi.consumer;

import cn.nuomi.dubboCommon.common.ProxyFactory;
import cn.nuomi.dubboService.api.UserService;

public class Consumer {

    public static void main(String[] args) {

        UserService userService = ProxyFactory.gerProxy(UserService.class,"1.0");
        String call = userService.call("huangyu");
        System.out.println(call);

    }
}
