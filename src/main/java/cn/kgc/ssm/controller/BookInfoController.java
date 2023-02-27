package cn.kgc.ssm.controller;

import cn.kgc.ssm.pojo.BookInfo;
import cn.kgc.ssm.pojo.TypeInfo;
import cn.kgc.ssm.service.BookInfoService;
import cn.kgc.ssm.service.TypeInfoService;
import cn.kgc.ssm.utils.DataInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private TypeInfoService typeInfoService;

    @GetMapping("/bookIndex")
    public String bookIndex(){
        return "book/bookIndex";

    }
    @RequestMapping("/bookAll")
    @ResponseBody
    public DataInfo bookAll(BookInfo bookInfo, @RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "15") Integer limit){
        PageInfo<BookInfo> pageInfo = bookInfoService.findAll(bookInfo,page,limit);
        return DataInfo.ok("成功",pageInfo.getTotal(),pageInfo.getList());
    }
    @RequestMapping("/findAllList")
    @ResponseBody
    public List<TypeInfo> findAll(){
        PageInfo<TypeInfo> pageInfo = typeInfoService.queryTypeInfoAll(null,1,100);
        List<TypeInfo> lists = pageInfo.getList();
        return lists;
    }

    @GetMapping("/bookAdd")
    public String bookAdd(){
        return "book/bookAdd";
    }
    @RequestMapping("/bookAdd")
    @ResponseBody
    public int addBook(BookInfo bookInfo){
        int i = bookInfoService.addbookInfo(bookInfo);
        return i;
    }
    @RequestMapping("/bookdelete")
    @ResponseBody
    public int addBook(int id){
        int i = bookInfoService.deletebookInfo(id);
        return i;
    }

    @RequestMapping(value = "/bookdeleteByIds", method = RequestMethod.POST)
    @ResponseBody
    public int addBook(@RequestParam("ids") String ids){

        int i = bookInfoService.deletebookInfoByIds(ids);
        return i;
    }
    @GetMapping("/queryBookInfoById")
    public String queryTypeInfoById(Integer id, Model model){
        BookInfo bookInfo= bookInfoService.findbookInfoById(id);
        model.addAttribute("info",bookInfo);
        return "book/updateBook";
    }

    @RequestMapping(value = "/bookUpdate", method = RequestMethod.POST)
    @ResponseBody
    public int updateBook(BookInfo bookInfo){
        int i = bookInfoService.updatebookInfo(bookInfo);
        return i;
    }

}
