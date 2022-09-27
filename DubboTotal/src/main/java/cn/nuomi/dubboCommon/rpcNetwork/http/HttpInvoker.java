package cn.nuomi.dubboCommon.rpcNetwork.http;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.invoker.Invoker;

public class HttpInvoker implements Invoker {

    private URL url;

    public HttpInvoker(URL url) {
        this.url = url;
    }

    @Override
    public String invoke(Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getHostname(), url.getPort(), invocation);
    }
}
