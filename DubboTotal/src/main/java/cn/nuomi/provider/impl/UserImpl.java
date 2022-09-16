package cn.nuomi.provider.impl;

import cn.nuomi.dubboService.api.UserService;
import cn.nuomi.provider.entity.User;

public class UserImpl implements UserService {

    @Override
    public String call(String name) {
        User hy = new User("nuomi",23);
        return hy.getName() + "替" + name + "收到了";
    }
}
