package cn.nuomi.provider.impl;

import cn.nuomi.dubboService.api.UserService;
import cn.nuomi.provider.entity.User;

public class UserImpl implements UserService {

    @Override
    public String call() {
        User hy = new User("nuomi",23);
        return hy.getName() + "收到了";
    }
}
