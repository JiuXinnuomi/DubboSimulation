package cn.nuomi.provider;

import cn.nuomi.dubboCommon.LocalRegister;
import cn.nuomi.dubboCommon.rpcNetwork.http.HttpServer;
import cn.nuomi.dubboService.api.UserService;
import cn.nuomi.provider.impl.UserImpl;

public class Provider {

    public static void main(String[] args) {

        //本地注册
        LocalRegister.regist(UserService.class.getName()+"@1.0", UserImpl.class);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8081);
    }
}
