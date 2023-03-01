package cn.kgc.ssm.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.pojo.ReaderInfo;
import cn.kgc.ssm.service.AdminService;
import cn.kgc.ssm.service.LendListService;
import cn.kgc.ssm.service.ReaderInfoService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import java.io.Console;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ReaderInfoController {
    @Autowired
    private ReaderInfoService readerInfoService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private LendListService lendListService;

    @GetMapping("/readerIndex")
    public String readerIndex() {
        return "reader/readerIndex";
    }

    @RequestMapping("/readerAll")
    @ResponseBody
    public DataInfo queryReaderAll(ReaderInfo readerInfo, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "15") Integer limit) {
        PageInfo<ReaderInfo> pageInfo = readerInfoService.queryAllReaderInfo(readerInfo, page, limit);
        return DataInfo.ok("成功", pageInfo.getTotal(), pageInfo.getList());
    }


    // public String readerAdd(){return "reader/readerAdd";}
    @RequestMapping("/readerAdd")
    public String readerAdd() {

        return "reader/readerAdd";
    }

    @RequestMapping("/addReaderSubmit")
    @ResponseBody
    public DataInfo addReaderSubmit(@RequestBody ReaderInfo readerInfo){
        if (readerInfo.getRegisterDate()==null){
            readerInfo.setRegisterDate(new Date());//设置创建时间
        }

        readerInfo.setPassword("123456");//设置默认密码
        readerInfoService.addReaderInfoSubmit(readerInfo);
        return DataInfo.ok();
    }

    @GetMapping("/queryReaderInfoById")
    public String queryReaderInfoById(Integer id, Model model) {
        ReaderInfo readerInfo = readerInfoService.queryReaderInfoById(id);
        model.addAttribute("info", readerInfo);
        return "reader/updateReader";
    }


    /**
     * 修改提交
     */
    @RequestMapping("/updateReaderSubmit")
    @ResponseBody
    public DataInfo updateReaderSubmit(@RequestBody ReaderInfo readerInfo){
        readerInfoService.updateReaderInfoSubmit(readerInfo);
        return DataInfo.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteReader")
    @ResponseBody
    public DataInfo deleteReader(String ids){

        List<String> list= Arrays.asList(ids.split(","));
        readerInfoService.deleteReaderInfoByIds(list);
        return DataInfo.ok();
    }
    @RequestMapping(value = "/checkOldPwdRea", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkOldPwdRea(@RequestParam("oldPwd") String oldPwd,@RequestParam("username") String username){
        boolean flag=false;
        ReaderInfo readerInfo = readerInfoService.findUserByNameAndPassword(username, oldPwd);
        if (readerInfo!=null){
            flag=true;
        }
        return flag;
    }

    @RequestMapping(value = "/updateReaderPwd", method = RequestMethod.POST)
    @ResponseBody
    public int updateAdminPwd(@RequestParam("password") String newPwd,@RequestParam("id") Integer id){
        boolean flag=false;
        ReaderInfo readerInfo = new ReaderInfo(id,newPwd);
        int i = readerInfoService.updateReaderPwd(readerInfo);
        if (i>0){
            flag=true;
        }
        return i;
    }
}
