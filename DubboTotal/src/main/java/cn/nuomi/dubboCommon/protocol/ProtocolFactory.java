package cn.nuomi.dubboCommon.protocol;

import cn.nuomi.dubboCommon.rpcNetwork.http.HttpProtocol;
import cn.nuomi.dubboCommon.rpcNetwork.netty.DubboProtocol;

/**
 * Protocol工厂的存在主要是为了创建不同类型的Protocol对象，
 * 工厂根据指定的条件创建不同的对象，有自动化对象需求时才需要创建工厂，
 */
public class ProtocolFactory {

    public static Protocol getProtocol(String name){

        switch (name){
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }

        return new DubboProtocol();
    }
}
