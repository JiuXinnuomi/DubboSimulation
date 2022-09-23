package cn.nuomi.online;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.nuomi.dubboCommon.URL;
import org.springframework.util.ObjectUtils;

public class RemoteRegister {

    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static void regist(String interfaceName, URL url) {
        List<URL> urlList = REGISTER.get(interfaceName);
        if (ObjectUtils.isEmpty(urlList)){
            urlList = new ArrayList<>();
            REGISTER.put(interfaceName,urlList);
        }else {
            urlList.add(url);
        }
    }

    public static List<URL> get(String interfaceName) {
        return REGISTER.get(interfaceName);
    }

    //    public static void regist(String interfaceName, List<String> urlList) {
//        List<String> list = map.get(interfaceName);
//        if (ObjectUtils.isEmpty(list)){
//            map.put(interfaceName,urlList);
//        }else {
//            for (String address : urlList){
//                regist(interfaceName,address);
//            }
//        }
//    }
//
//    public static void regist(String interfaceName,String address){
//        List<String> urlList = map.get(interfaceName);
//        urlList.add(address);
//    }

}
