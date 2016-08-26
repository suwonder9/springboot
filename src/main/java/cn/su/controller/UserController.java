package cn.su.controller;

import cn.su.model.User;
import cn.su.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zl on 2015/8/27.
 */
@Controller
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo() {
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
            logger.info("user.getAge():"+user.getAge());
        }
        return user;
    }

    @RequestMapping("/insertUser")
    @ResponseBody
    public void insertUser(){
        try{
            User user = new User();
            user.setAge(20);
            user.setName("神人");
            user.setPassword("123456");
            userService.insertUser(user);
        }catch (Exception e)
        {

        }
    }
}
