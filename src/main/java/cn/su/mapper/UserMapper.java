package cn.su.mapper;

import cn.su.model.User;

/**
 * Created by zl on 2015/8/27.
 */
public interface UserMapper {
    public User findUserInfo();

    public void insertUser(User user);
}
