package cn.su.mapper;

import cn.su.model.LoginLog;

public interface LoginLogMapper {
    int insert(LoginLog record);

    int insertSelective(LoginLog record);
}