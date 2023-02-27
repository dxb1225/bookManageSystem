package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.TypeInfo;
import cn.kgc.ssm.service.BookInfoService;
import cn.kgc.ssm.service.TypeInfoService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;



@Controller
public class TypeInfoController {
    @Autowired
    private TypeInfoService typeInfoService;
//    @Autowired
//    private BookInfoService bookInfoService;

    @GetMapping("/typeIndex")
    public String typeIndex(){

        return "type/typeIndex";
    }
    @RequestMapping("/typeAll")
    @ResponseBody
    public DataInfo typeAll(String name, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue ="15") Integer limit){
        PageInfo<TypeInfo> pageInfo = typeInfoService.queryTypeInfoAll(name, page, limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }

    @GetMapping("/typeAdd")
    public String typeAdd(){

        return "type/typeAdd";
    }
    @PostMapping("/addTypeSubmit")
    @ResponseBody
    public  int addTypeSubmit(TypeInfo info){
        int i = typeInfoService.addTypeSubmit(info);
        return i;
    }



    /**
     * 类型根据id查询(修改)
     */
    @GetMapping("/queryTypeInfoById")
    public String queryTypeInfoById(Integer id,Model model){
        TypeInfo info = typeInfoService.queryTypeInfoById(id);
        model.addAttribute("info",info);
        return "type/updateType";
    }
    /**
     * 修改提交功能
     */
    @RequestMapping(value = "/updateTypeSubmit",method = RequestMethod.POST)
    @ResponseBody
    public boolean updateTypeSubmit(TypeInfo typeInfo){
        boolean flag =false;
        int i = typeInfoService.updateTypeSubmit(typeInfo);
        if (i>0){
            flag=true;
        }
        return flag;
    }
    /**
     * 类型删除
     */

    @RequestMapping("/deleteTypeByIds")
    @ResponseBody
    public int deleteType(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        int i = typeInfoService.deleteTypeByIds(list);
        return i;
    }

    @RequestMapping("/deleteTypeById")
    @ResponseBody
    public int deleteTypeById(Integer id){
        return typeInfoService.deleteTypeById(id);
    }






}
