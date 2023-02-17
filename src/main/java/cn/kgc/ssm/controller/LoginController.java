package cn.kgc.ssm.controller;

import cn.kgc.ssm.codeutil.IVerifyCodeGen;
import cn.kgc.ssm.codeutil.SimpleCharVerifyCodeGenImpl;
import cn.kgc.ssm.codeutil.VerifyCode;
import cn.kgc.ssm.pojo.Admin;
import cn.kgc.ssm.pojo.ReaderInfo;
import cn.kgc.ssm.service.AdminService;
import cn.kgc.ssm.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author:邓湘标
 * @Package:cn.kgc.ssm.controller
 * @DESCRIPTION:
 * @DATE: 2023/2/17 10:49
 * @Version:1.0
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private ReaderInfoService readerService;

    @RequestMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            request.getSession().setAttribute("VerifyCode", code);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            System.out.println("异常处理");
        }
    }

    @RequestMapping("/loginIn")
    public String loginIn(HttpServletRequest request, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code=request.getParameter("captcha");
        String type=request.getParameter("type");
        HttpSession session = request.getSession();
        String realCode = (String)session.getAttribute("VerifyCode");
        if (!realCode.toLowerCase().equals(code.toLowerCase())){
            model.addAttribute("msg","验证码不正确");
            return "login";
        }else{
            if(type.equals("1")){
                Admin admin=adminService.queryUserByNameAndPassword(username,password);
                if(admin==null){
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                if(admin.getAdminType() == 1){
                    session.setAttribute("user",admin);
                    session.setAttribute("type","superAdmin");
                }else {
                    session.setAttribute("user",admin);
                    session.setAttribute("type","admin");
                }
            }else{
                ReaderInfo readerInfo=readerService.queryUserInfoByNameAndPassword(username,password);
                if(readerInfo==null){
                    model.addAttribute("msg","用户名或密码错误");
                    return "login";
                }
                session.setAttribute("user",readerInfo);
                session.setAttribute("type","reader");
            }
            return "index";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();//注销
        return "login";
    }
}
