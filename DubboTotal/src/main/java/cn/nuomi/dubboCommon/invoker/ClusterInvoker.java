package cn.nuomi.dubboCommon.invoker;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.LoadBalance;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.protocol.Protocol;
import cn.nuomi.dubboCommon.protocol.ProtocolFactory;
import cn.nuomi.online.RemoteRegister;

/**
 * 将底层网络框架统一封装到集合中供消费端进行调用，
 * 这样可以将接口服务的不同网络框架实现类型全部暴露出来，起到了集群的作用，
 */
import java.util.List;

public class ClusterInvoker implements Invoker{

    private List<Invoker> invokers;

    public List<Invoker> getInvokers() {
        return invokers;
    }

    public void addInvoker(Invoker invoker){
        invokers.add(invoker);
    }

    public static Invoker join(Class interfaceClass){
        ClusterInvoker clusterInvoker = new ClusterInvoker();

        // 从注册中心查看urls
        List<URL> urlList = RemoteRegister.get(interfaceClass.getName());

        urlList.forEach(url -> {
            Protocol protocol = ProtocolFactory.getProtocol(url.getProtocol());
            Invoker invoker = protocol.refer(url);
            clusterInvoker.addInvoker(invoker);
        });

        return clusterInvoker;
    }

    @Override
    public String invoke(Invocation invocation) {
        Invoker invoker = LoadBalance.random(invokers);
        return invoker.invoke(invocation);
    }
}
