package cn.nuomi.dubboCommon;

import cn.nuomi.dubboCommon.rpcNetwork.http.HttpClient;
import cn.nuomi.dubboService.api.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {

    public static <T> T gerProxy(final Class<UserService> interfaceClass,String version){

        //TODO 可选择使用不同的动态代理方式

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //创建发送对象
                Invocation invocation = new Invocation(method.getName(), interfaceClass.getName(),version, method.getParameterTypes(), args);

                //TODO 提供者的地址不能写死，通过接口信息获取并自动配置最大限度的信息
                //使用HttpClient发送请求
                //TODO 由开发者来决定使用何种网络通信进行发送，不能写死
                String receiveMsg = new HttpClient().send("localhost", 8080, invocation);

                return receiveMsg;
            }
        });
    }
}
