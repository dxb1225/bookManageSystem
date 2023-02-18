package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.service.AdminService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.controller
 * @DESCRIPTION:
 * @DATE: 2023/2/17 20:41
 * @Version:1.0
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/adminIndex")
    public String adminIndex(){
        return "admin/adminIndex";
    }

    @RequestMapping("/adminAll")
    @ResponseBody
    public DataInfo queryAdminAll(Admin admin, @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo<Admin> pageInfo = adminService.queryAdminAll(admin, pageNum);
        Map<String,Object> map = new HashMap<>();
        map.put("ok", pageInfo.getList());
        return DataInfo.ok("ok",pageInfo.getTotal(),pageInfo.getList());
    }

}
