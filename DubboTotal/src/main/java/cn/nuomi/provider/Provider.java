package cn.nuomi.provider;

import cn.nuomi.dubboCommon.common.LocalRegister;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.protocol.Protocol;
import cn.nuomi.dubboCommon.protocol.ProtocolFactory;
import cn.nuomi.dubboService.api.UserService;
import cn.nuomi.online.RemoteRegister;
import cn.nuomi.provider.impl.UserImpl;

public class Provider {

    public static void main(String[] args) {

//        HttpServer httpServer = new HttpServer();
//        httpServer.start("localhost",8080);

//        String rpcName = System.getProperty("protocol");
//        Protocol protocol = ProtocolFactory.getProtocol(rpcName);
//        protocol.start(url);

        String protocolKey = System.getProperty("protocolKey");
        URL url = new URL("localhost",8080,protocolKey,UserService.class.getName()+"@1.0",UserImpl.class);
        Protocol protocol = ProtocolFactory.getProtocol(protocolKey);
        protocol.export(url);
    }
}
