package cn.nuomi.dubboCommon.rpcNetwork.http;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.LocalRegister;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.invoker.Invoker;
import cn.nuomi.dubboCommon.protocol.Protocol;
import cn.nuomi.online.RemoteRegister;

public class HttpProtocol implements Protocol {

    @Override
    public void export(URL url) {
        //本地注册
        LocalRegister.regist(url.getInterfaceClass(),url.getInterfaceImpl());
        //注册中心注册
        RemoteRegister.regist(url.getInterfaceClass(),url);
        new HttpServer().start(url.getHostname(), url.getPort());
    }

    @Override
    public Invoker refer(URL url) {
        return new HttpInvoker(url);
    }
}
