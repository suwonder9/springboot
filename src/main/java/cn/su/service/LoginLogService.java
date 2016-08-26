package cn.su.service;

import cn.su.mapper.LoginLogMapper;
import cn.su.model.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sujinxian on 2016/8/18.
 */

@Service
public class LoginLogService {

    @Autowired
    LoginLogMapper  loginLogMapper;

    @Transactional
    public void  insert(LoginLog log)
    {
        loginLogMapper.insert(log);
    }
}
