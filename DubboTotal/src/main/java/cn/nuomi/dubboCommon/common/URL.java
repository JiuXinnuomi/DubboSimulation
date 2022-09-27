package cn.nuomi.dubboCommon.common;

import cn.nuomi.dubboCommon.protocol.Protocol;

public class URL {

    private String hostname;
    private int port;
    private String protocol; //URL选择的网络底层启动类
    private String interfaceClass;  //接口名
    private Class interfaceImpl;   //接口的具体实现类

    public URL(String hostname, int port, String protocol, String interfaceClass, Class interfaceImpl) {
        this.hostname = hostname;
        this.port = port;
        this.protocol = protocol;
        this.interfaceClass = interfaceClass;
        this.interfaceImpl = interfaceImpl;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getInterfaceClass() {
        return interfaceClass;
    }

    public void setInterfaceClass(String interfaceClass) {
        this.interfaceClass = interfaceClass;
    }

    public Class getInterfaceImpl() {
        return interfaceImpl;
    }

    public void setInterfaceImpl(Class interfaceImpl) {
        this.interfaceImpl = interfaceImpl;
    }
}
