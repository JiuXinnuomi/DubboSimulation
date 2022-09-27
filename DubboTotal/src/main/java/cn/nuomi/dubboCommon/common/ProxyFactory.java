package cn.nuomi.dubboCommon.common;

import cn.nuomi.dubboCommon.invoker.ClusterInvoker;
import cn.nuomi.dubboCommon.invoker.Invoker;
import cn.nuomi.dubboService.api.UserService;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    @SuppressWarnings("unchecked")
    public static <T> T gerProxy(final Class<UserService> interfaceClass,String version){

        //TODO 可选择使用不同的动态代理方式
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                String mock = System.getProperty("mock");
                if (mock != null && mock.startsWith("return:")){
                    return mock.replace("return:","");
                }

                //重投服务
                int retry = 3;
                while (retry > 0) {
                    //服务容错
                    try {
                        //创建发送对象
                        Invocation invocation = new Invocation(method.getName(), interfaceClass.getName(), version, method.getParameterTypes(), args);

                        //提供者的地址不能写死，通过接口信息获取并自动配置最大限度的信息. 此处远程注册跨进程，无法共享同一块内存资源
                        //TODO 设置本地缓存，提高远程查询效率，刷新本地缓存
//                        List<URL> urlList = RemoteRegister.get(interfaceClass.getName());
                        Invoker clusterInvoker = ClusterInvoker.join(interfaceClass);

                        //熔断降级，限流分发建议单独使用一个类进行
                        //TODO 负载均衡，重投时排除已加载过的策略
//                        URL sendUrl = LoadBalance.random(urlList);
                        String invokeMsg = clusterInvoker.invoke(invocation);

                        //使用HttpClient发送请求
                        //TODO 由开发者来决定使用何种网络通信进行发送，不能写死

                        return invokeMsg;
                    } catch (Exception e) {
                        retry--;
                        //TODO 服务容错，根据配置针对不同错误返回不通信息. 专属类+方法
                        if (retry == 0) {
                            return "当前服务不存在";
                        }
                    }
                }
                return "重投策略配置异常";
            }
        });
    }
}
