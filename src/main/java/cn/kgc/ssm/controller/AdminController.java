package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.service.AdminService;
import cn.kgc.ssm.utils.DataInfo;
import com.alibaba.druid.sql.visitor.functions.If;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
        return DataInfo.ok("ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/queryAdminById")
    public String queryAdminById(Integer id, Model model){
        Admin admin = adminService.queryAdminById(id);
        model.addAttribute("admin", admin);
        return "admin/updateAdmin";
    }

    @RequestMapping("/findAllAdminType")
    @ResponseBody
    public List<Integer> findAll(Integer id){
        List<Integer> allAdminType = adminService.findAllAdminType();
        return allAdminType;
    }

    @RequestMapping("/admin/updateAdmin")
    @ResponseBody
    public boolean updateAdmin(Admin admin){
        boolean flag = false;
        int i = adminService.updateAdminById(admin);
        if(i>0){
            flag=true;
        }
        return flag;
    }

    @RequestMapping("/adminAdd")
    public String adminAdd(){
        return "admin/adminAdd";
    }

    @RequestMapping("/addAdmin")
    @ResponseBody
    public int addAdmin(Admin admin){
        int i = adminService.addAdmin(admin);
        return i;
    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public int deleteAdmin(@Param("id") Integer id){
        int i = adminService.deleteAdmin(id);
        return i;
    }


    @RequestMapping(value = "/checkOldPwd", method = RequestMethod.GET)
    @ResponseBody
    public boolean checkOldPwd(@RequestParam("oldPwd") String oldPwd,@RequestParam("username") String username){
        boolean flag=false;
        Admin admin = adminService.queryUserByNameAndPassword(username, oldPwd);
        if (admin!=null){
            flag=true;
        }
        return flag;
    }
    @RequestMapping(value = "/updateAdminPwd", method = RequestMethod.POST)
    @ResponseBody
    public int updateAdminPwd(@RequestParam("password") String newPwd,@RequestParam("id") Integer id){
        boolean flag=false;
        Admin admin = new Admin(id,newPwd);
        int i = adminService.updateAdminPwd(admin);
        if (i>0){
            flag=true;
        }
        return i;
    }

}
