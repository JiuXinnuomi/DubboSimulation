package cn.nuomi.dubboCommon.rpcNetwork.http;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req处理提供者端服务器接收的请求,可以在Servlet中实现过滤器链,处理链
        new HttpServletHandler().handle(req,resp);

    }
}
