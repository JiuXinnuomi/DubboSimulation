package cn.nuomi.dubboCommon.common;

import cn.nuomi.dubboCommon.invoker.Invoker;

import java.util.List;
import java.util.Random;

public class LoadBalance {

    public static Invoker random(List<Invoker> invokers) {
        Random random =new Random();
        int n = random.nextInt(invokers.size());
        return invokers.get(n);
    }
}
