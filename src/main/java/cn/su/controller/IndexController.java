package cn.su.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sujinxian on 2016/8/18.
 */

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex()
    {
        //model.addAttribute("su","djsjd");
        return "index";
    }

}
