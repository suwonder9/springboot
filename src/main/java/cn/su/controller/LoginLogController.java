package cn.su.controller;

import cn.su.model.LoginLog;
import cn.su.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by sujinxian on 2016/8/18.
 */

@Controller
public class LoginLogController {

    private Logger logger = Logger.getLogger(LoginLogController.class);

    @Autowired
    LoginLogService loginLogService;

    @RequestMapping("/insertLog")
    @ResponseBody
    public String insert()
    {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        LoginLog log = new LoginLog();
        log.setLoggername("大家爱家");
        log.setTime(now);

        try{
            //loginLogService.insert(log);
            logger.info("插入成功");
        }catch (Exception e)
        {
            logger.error("插入失败"+e);
        }
        return "loginLog";
    }





}
