package cn.nuomi.dubboCommon.protocol;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.URL;
import cn.nuomi.dubboCommon.invoker.Invoker;

/**
 * Protocol是封装开发者暴露和调用服务的接口类，
 * 通过Protocol接口使开发者可以根据参数来自动获取对应的暴露类型，
 * 通过封装，将Dobbo底层暴露服务的方法对消费者隐形，
 */
public interface Protocol {
    void export(URL url);
    Invoker refer(URL url);
}
