package cn.su.service;

import cn.su.mapper.UserMapper;
import cn.su.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zl on 2015/8/27.
 */

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(){
        User user=userMapper.findUserInfo();
        //User user=null;
        return user;
    }

    @Transactional
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

}
