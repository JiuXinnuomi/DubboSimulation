package cn.nuomi.provider;

import cn.nuomi.dubboCommon.LocalRegister;
import cn.nuomi.dubboCommon.URL;
import cn.nuomi.dubboCommon.rpcNetwork.http.HttpServer;
import cn.nuomi.dubboService.api.UserService;
import cn.nuomi.online.RemoteRegister;
import cn.nuomi.provider.impl.UserImpl;

public class Provider {

    public static void main(String[] args) {

        //本地注册
        LocalRegister.regist(UserService.class.getName()+"@1.0", UserImpl.class);

        //注册中心注册
        //TODO 如何处理提供注册的过程同样不写死，不用通过修改代码来注册
        URL url = new URL("localhost",8080);
        RemoteRegister.regist(UserService.class.getName()+"@1.0",url);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8080);
    }
}
