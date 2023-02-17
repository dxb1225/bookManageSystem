package cn.kgc.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.controller
 * @DESCRIPTION:
 * @DATE: 2023/2/17 21:04
 * @Version:1.0
 */
@Controller
public class BaseController {


    @RequestMapping("/welcome")
    public  String welcome(Model model){
        return  "welcome";
    }
}
