package cn.nuomi.dubboCommon.rpcNetwork.http;

import cn.nuomi.dubboCommon.common.Invocation;
import cn.nuomi.dubboCommon.common.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HttpServletHandler {

    public void handle(HttpServletRequest req, HttpServletResponse resp){

        //拿到请求中的URL处理请求并调用提供者相应接口下的类
        //接口名,方法名，参数，地址，版本号。
        StringBuffer requestURL = req.getRequestURL();
        try {
            //使用与消费者相同的序列化协议。将传输的信息流转换成对象
            Invocation invocation = (Invocation) new ObjectInputStream(req.getInputStream()).readObject();

            Class classImpl = LocalRegister.get(invocation.getInterfaceName()+"@"+ invocation.getVerison());

            Method method = classImpl.getMethod(invocation.getMethodName(), invocation.getParamType());

            String result = (String) method.invoke(classImpl.newInstance(), invocation.getParams());


            //将结果通过resp返回给消费者请求端
            IOUtils.write(result, resp.getOutputStream());


        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
