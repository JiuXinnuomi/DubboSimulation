package cn.nuomi.provider;

import cn.nuomi.dubboCommon.providerIo.rpcNetwork.http.HttpServer;

public class Provider {

    public static void main(String[] args) {

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8081);
    }
}
