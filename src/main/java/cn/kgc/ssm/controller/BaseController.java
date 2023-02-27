package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Notice;
import cn.kgc.ssm.service.NoticeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.http.HttpRequest;
import java.util.List;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.controller
 * @DESCRIPTION:
 * @DATE: 2023/2/17 21:04
 * @Version:1.0
 */
@Controller
public class BaseController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/welcome")
    public  String welcome(Model model){
        PageInfo<Notice> pageInfo =  noticeService.queryAllNotice(null,1,5);
        if (pageInfo!=null){
            List<Notice> noticeList = pageInfo.getList();
            model.addAttribute("noticeList",noticeList);
        }
        return  "welcome";
    }




    @GetMapping("/updatePassword")
    public String updatePwd(){
        return "pwdUpdate/updatePwd";
    }
}
