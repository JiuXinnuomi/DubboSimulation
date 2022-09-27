package cn.nuomi.dubboCommon.invoker;

import cn.nuomi.dubboCommon.common.Invocation;

/**
 * Invoker作为封装网络框架的一个抽象类，
 * 每一个Invoker代表一个URL接口抽象类，利用接口可以同时容纳各种不同的网络层框架
 * 利用集群管理将所有网络层框架集合，供给消费者调用各种不同版本
 */
public interface Invoker {

    String invoke(Invocation invocation);
}
