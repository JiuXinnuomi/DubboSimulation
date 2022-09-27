package cn.nuomi.dubboCommon.rpcNetwork.netty;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.invoker.Invoker;

public class DubboInvoker implements Invoker{

    private URL url;

    public DubboInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        NettyClient nettyClient = new NettyClient();
        return nettyClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
