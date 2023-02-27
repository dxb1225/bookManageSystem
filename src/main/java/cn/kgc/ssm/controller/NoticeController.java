package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.pojo.Notice;
import cn.kgc.ssm.service.AdminService;
import cn.kgc.ssm.service.NoticeService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/noticeIndexOfBack")
    public String noticeIndexOfBack(){
        return "notice/noticeIndexOfBack";
    }

    @GetMapping("/noticeIndexOfReader")
    public String noticeIndexOfReader(){
        return "notice/noticeIndexOfReader";
    }

    @RequestMapping("/noticeAll")
    @ResponseBody
    public DataInfo noticeAll(Notice notice,@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<Notice> pageInfo = noticeService.queryAllNotice(notice,page,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/noticeAdd")
    public String noticeAdd(Model model,@RequestParam(defaultValue = "1") Integer pageNum){
        return "notice/noticeAdd";
    }

    @RequestMapping("/addNoticeSubmit")
    @ResponseBody
    public int addNoticeSubmit(Notice notice){
        notice.setCreateDate(new Date());
        int i = noticeService.noticeAdd(notice);
        return i;
    }

    @GetMapping("/queryNoticeById")
    public String queryNoticeById(Integer id,Model model){
        Notice notice = noticeService.queryNoticeById(id);
        model.addAttribute("info",notice);
        return "notice/updateNotice";
    }

    @RequestMapping("/deleteNotices")
    @ResponseBody
    public int deleteNotice(@RequestParam("id") String ids){
        System.out.println(ids);
        List<String> list = Arrays.asList(ids.split(","));

        int i = noticeService.delNotices(list);
        return i;
    }

    @RequestMapping("/deleteNotice")
    @ResponseBody
    public int deleteNotice(Integer id){
        int i = noticeService.delNotice(id);
        return i;
    }


}
