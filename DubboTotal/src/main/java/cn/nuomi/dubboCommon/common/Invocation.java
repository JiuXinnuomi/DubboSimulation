package cn.nuomi.dubboCommon.common;

import java.io.Serializable;

public class Invocation implements Serializable {

    private String methodName;
    private String interfaceName;
    private String verison;
    private Class[] paramType;
    private Object[] params;

    public Invocation(String methodName, String interfaceName, String verison, Class[] paramType, Object[] params) {
        this.methodName = methodName;
        this.interfaceName = interfaceName;
        this.verison = verison;
        this.paramType = paramType;
        this.params = params;
    }

    public String getVerison() {
        return verison;
    }

    public void setVerison(String verison) {
        this.verison = verison;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}
